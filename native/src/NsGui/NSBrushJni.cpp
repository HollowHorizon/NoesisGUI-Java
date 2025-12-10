//
// Created by Sixik on 10.12.2025.
//

#include <jni.h>

#include "NsGui/Brush.h"

namespace Noesis {

}

extern "C" {

    static Noesis::Brush *getComponent(JNIEnv *env, const jlong handle) {
        if (handle == 0) {
            jclass excCls = env->FindClass("java/lang/IllegalStateException");
            if (excCls != nullptr) {
                env->ThrowNew(excCls, "Noesis.Brush ptr is null");
            }
            return nullptr;
        }
        return reinterpret_cast<Noesis::Brush *>(handle);
    }

    JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSBrush_nGetOpacity(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return 0.0f;
        return component->GetOpacity();
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBrush_nSetOpacity(JNIEnv* env, jclass clazz, jlong ptr, jfloat value) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->SetOpacity(value);
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSBrush_nGetRelativeTransform(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return 0;
        return reinterpret_cast<jlong>(component->GetRelativeTransform());
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBrush_nSetRelativeTransform(JNIEnv* env, jclass clazz, jlong ptr, jlong transform_ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->SetRelativeTransform(reinterpret_cast<Noesis::Transform *>(transform_ptr));
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSBrush_nGetTransform(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return 0;
        return reinterpret_cast<jlong>(component->GetTransform());
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBrush_nSetTransform(JNIEnv* env, jclass clazz, jlong ptr, jlong transform_ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->SetTransform(reinterpret_cast<Noesis::Transform *>(transform_ptr));
    }

    JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSBrush_nIsTransparent(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return false;
        return component->IsTransparent();
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSBrush_nOpacityProperty(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(Noesis::Brush::OpacityProperty);
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSBrush_nRelativeTransformProperty(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(Noesis::Brush::RelativeTransformProperty);
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSBrush_nTransformProperty(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(Noesis::Brush::TransformProperty);
    }
}
