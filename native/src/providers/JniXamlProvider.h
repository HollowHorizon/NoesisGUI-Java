//
// Created by Sixik on 16.12.2025.
//

#ifndef NOESIS_JNI_JNIXAMLPROVIDER_H
#define NOESIS_JNI_JNIXAMLPROVIDER_H
#include <mutex>
#include <string>

#include "JniXamlProviderUtils.h"
#include "../jni.h"
#include "../NsApp/JavaNotifyPropertyChangedBase.h"
#include "NsGui/Uri.h"
#include "NsGui/XamlProvider.h"

struct JniEnvScope {
    JNIEnv* env = nullptr;
    bool attached = false;

    JniEnvScope() {
        if (NoesisJava::g_vm == nullptr) return;

        // Check if already attached
        if (NoesisJava::g_vm->GetEnv((void**)&env, JNI_VERSION_1_6) != JNI_OK) {
            if (NoesisJava::g_vm->AttachCurrentThread((void**)&env, nullptr) == JNI_OK) {
                attached = true;
            } else {
                env = nullptr;
            }
        }
    }

    ~JniEnvScope() {
        if (attached && NoesisJava::g_vm) {
            NoesisJava::g_vm->DetachCurrentThread();
        }
    }
};

namespace NoesisJava {
    class JniXamlProvider : public Noesis::XamlProvider {

    public:
        Noesis::Ptr<Noesis::Stream> LoadXaml(const Noesis::Uri &uri) override
        {
            const std::string key = NoesisJava::JniXamlProviderUtils::NormalizeUri(uri.Str());
            if (key.empty()) return nullptr;

            // 1) Cache hit
            {
                std::lock_guard<std::mutex> lock(NoesisJava::JniXamlProviderUtils::g_xamlCacheMutex);
                auto it = NoesisJava::JniXamlProviderUtils::g_xamlCache.find(key);
                if (it != NoesisJava::JniXamlProviderUtils::g_xamlCache.end()) {
                    return NoesisJava::JniXamlProviderUtils::MakeStreamFromSharedBytes(it->second);
                }
            }

            // 2) Cache miss -> load from Java
            JniEnvScope scope = nullptr;
            if (!scope.env) return nullptr;

            std::vector<uint8_t> tmp;
            if (!NoesisJava::JniXamlProviderUtils::CallJavaLoadXaml(scope.env, key, tmp)) return nullptr;

            auto shared = std::make_shared<std::vector<uint8_t>>(std::move(tmp));

            // 3) Store
            {
                std::lock_guard<std::mutex> lock(NoesisJava::JniXamlProviderUtils::g_xamlCacheMutex);
                NoesisJava::JniXamlProviderUtils::g_xamlCache[key] = shared;
            }

            return NoesisJava::JniXamlProviderUtils::MakeStreamFromSharedBytes(shared);
        }
    };
}

#endif //NOESIS_JNI_JNIXAMLPROVIDER_H