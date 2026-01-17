//
// Created by Sixik on 16.12.2025.
//

#ifndef NOESIS_JNI_JNIXAMLPROVIDERUTILS_H
#define NOESIS_JNI_JNIXAMLPROVIDERUTILS_H
#include <vector>
#include <memory>
#include <string>
#include <unordered_map>

#include <iostream>
#include <jni.h>
#include <mutex>
#include <unordered_map>

#include "NsCore/DynamicCast.h"
#include "NsCore/Ptr.h"
#include "NsGui/MemoryStream.h"

namespace Noesis {
    class MemoryStream;
    class Stream;
}

namespace NoesisJava {
    class JniXamlProviderUtils {
    public:
        static std::mutex g_xamlCacheMutex;
        static std::unordered_map<std::string, std::shared_ptr<std::vector<uint8_t> > > g_xamlCache;
        static jobject g_xamlLoaderGlobal;
        static jmethodID g_midLoadXaml;

        static std::string NormalizeUri(const char *uri) {
            if (uri == nullptr) return "";

            std::string s(uri);

            // Strip common pack prefix if it appears
            const std::string pack = "pack://application:,,,/";
            if (s.rfind(pack, 0) == 0) {
                s = s.substr(pack.size());
            }

            // Remove leading '/'
            while (!s.empty() && s[0] == '/') s.erase(0, 1);

            return s;
        }

        static bool CallJavaLoadXaml(JNIEnv *env, const std::string &uri, std::vector<uint8_t> &out) {
            if (!env || !g_xamlLoaderGlobal || !g_midLoadXaml) return false;

            jstring jUri = env->NewStringUTF(uri.c_str());
            if (!jUri) {
                return false;
            }

            auto jBytesObj = (jbyteArray) env->CallObjectMethod(g_xamlLoaderGlobal, g_midLoadXaml, jUri);
            env->DeleteLocalRef(jUri);

            if (env->ExceptionCheck()) {
                env->ExceptionDescribe(); // you may want to redirect this into your logger
                env->ExceptionClear();
                return false;
            }

            if (jBytesObj == nullptr) {
                return false;
            }

            const jsize len = env->GetArrayLength(jBytesObj);
            out.resize((size_t) len);

            if (len > 0) {
                jbyte *ptr = env->GetByteArrayElements(jBytesObj, nullptr);
                if (ptr) {
                    memcpy(out.data(), ptr, (size_t) len);
                    env->ReleaseByteArrayElements(jBytesObj, ptr, JNI_ABORT);
                } else {
                    env->DeleteLocalRef(jBytesObj);
                    return false;
                }
            }

            env->DeleteLocalRef(jBytesObj);
            return true;
        }

        static Noesis::Ptr<Noesis::Stream> MakeStreamFromSharedBytes(
            const std::shared_ptr<std::vector<uint8_t> > &bytes) {
            const uint32_t sz = bytes ? (uint32_t) bytes->size() : 0u;
            const void *ptr = (sz > 0) ? (const void *) bytes->data() : nullptr;

            const Noesis::Ptr<Noesis::MemoryStream> ms = *new Noesis::MemoryStream(ptr, sz);
            ms->SetPosition(0);
            return Noesis::StaticPtrCast<Noesis::Stream>(ms);
        }
    };
}

#endif //NOESIS_JNI_JNIXAMLPROVIDERUTILS_H
