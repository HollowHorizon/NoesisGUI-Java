//
// Created by Sixik on 11.12.2025.
//

#include <jni.h>

#include "NsGui/VisualBrush.h"

extern "C" {
    static Noesis::VisualBrush *getComponent(JNIEnv *env, const jlong handle) {
        if (handle == 0) {
            jclass excCls = env->FindClass("java/lang/IllegalStateException");
            if (excCls != nullptr) {
                env->ThrowNew(excCls, "Noesis.VisualBrush ptr is null");
            }
            return nullptr;
        }
        return reinterpret_cast<Noesis::VisualBrush *>(handle);
    }



    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSVisualBrush_nCreate(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(new Noesis::VisualBrush());
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSVisualBrush_nVisualProperty(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(Noesis::VisualBrush::VisualProperty);
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSVisualBrush_nGetVisual(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component =getComponent(env, ptr);
        if (component == nullptr) return 0;
        return reinterpret_cast<jlong>(component->GetVisual());
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSVisualBrush_nSetVisual(JNIEnv* env, jclass clazz, jlong ptr, jlong visual_ptr) {
        const auto component =getComponent(env, ptr);
        if (component == nullptr) return;
        component->SetVisual(reinterpret_cast<Noesis::Visual *>(visual_ptr));
    }

}
