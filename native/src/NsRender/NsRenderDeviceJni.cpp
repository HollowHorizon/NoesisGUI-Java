//
// Created by Sixik on 04.12.2025.
//

#include <jni.h>
#include <jni_md.h>

#include "../utils/NSJniUtils.h"

extern "C" {

    static Noesis::DeviceCaps *getComponent(JNIEnv *env, const jlong handle) {
        if (handle == 0) {
            jclass excCls = env->FindClass("java/lang/IllegalStateException");
            if (excCls != nullptr) {
                env->ThrowNew(excCls, "Noesis.DeviceCaps ptr is null");
            }
            return nullptr;
        }
        return reinterpret_cast<Noesis::DeviceCaps *>(handle);
    }

    JNIEXPORT void JNICALL
    Java_dev_sixik_noesisgui_nsrenderer_NSRenderDevice_nativeGetCaps(JNIEnv *env, jclass, jlong ptr, jobject jobject) {
        const Noesis::DeviceCaps *data = getComponent(env, ptr);
        if (!data) return;
        NSJniUtils::DeviceCapsFromCopy(env, *data, jobject);
    }
}
