//
// Created by Sixik on 04.12.2025.
//

#include <jni.h>
#include <jni_md.h>

#include "NsRender/RenderTarget.h"

extern "C" {

    JNIEXPORT jlong JNICALL
    Java_dev_sixik_noesisgui_nsrenderer_NSRenderTarget_nativeGetTexturePtr(JNIEnv *env, jclass, jlong ptr) {
        auto renderTarget = reinterpret_cast<Noesis::RenderTarget *>(ptr);
        if (!renderTarget) {
            env->ThrowNew(env->FindClass("java/lang/IllegalStateException"), "Noesis.RenderTarget ptr is null");
            return 0;
        }
        return reinterpret_cast<jlong>(renderTarget->GetTexture());
    }
}
