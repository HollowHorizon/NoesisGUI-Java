//
// Created by Sixik on 05.12.2025.
//

#ifndef NOESIS_JNI_JNI_H
#define NOESIS_JNI_JNI_H
#include <jni.h>

namespace NoesisJava {
    inline extern JavaVM* g_vm = nullptr;

    struct JniEnvScope {
        JNIEnv *env = nullptr;
        bool attached = false;

        JniEnvScope(JavaVM *vm) {
            const jint res = vm->GetEnv((void **) &env, JNI_VERSION_1_8);
            if (res == JNI_EDETACHED) {
                if (vm->AttachCurrentThread((void **) &env, nullptr) == 0) {
                    attached = true;
                }
            }
        }

        ~JniEnvScope() {
            if (attached) NoesisJava::g_vm->DetachCurrentThread();
        }

        operator JNIEnv *() const { return env; }
    };
}


#endif //NOESIS_JNI_JNI_H