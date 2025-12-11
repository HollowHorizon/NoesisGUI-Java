//
// Created by Sixik on 11.12.2025.
//

#include <jni.h>

#include "NsGui/Button.h"

namespace Noesis {
    class Button;
}

extern "C" {

    static Noesis::Button *getComponent(JNIEnv *env, const jlong handle) {
        if (handle == 0) {
            jclass excCls = env->FindClass("java/lang/IllegalStateException");
            if (excCls != nullptr) {
                env->ThrowNew(excCls, "Noesis.Button ptr is null");
            }
            return nullptr;
        }
        return reinterpret_cast<Noesis::Button *>(handle);
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSButton_nCreate(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(new Noesis::Button());
    }

    JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSButton_nGetIsCancel(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return false;
        return component->GetIsCancel();
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSButton_nSetIsCancel(JNIEnv* env, jclass clazz, jlong ptr, jboolean value) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->SetIsCancel(value);
    }

    JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSButton_nGetIsDefault(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return false;
        return component->GetIsDefault();
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSButton_nSetIsDefault(JNIEnv* env, jclass clazz, jlong ptr, jboolean value) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->SetIsDefault(value);
    }

    JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSButton_nGetIsDefaulted(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return false;
        return component->GetIsDefaulted();
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSButton_nIsCancelProperty(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(Noesis::Button::IsCancelProperty);
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSButton_nIsDefaultProperty(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(Noesis::Button::IsDefaultProperty);
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSButton_nIsDefaultedProperty(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(Noesis::Button::IsDefaultedProperty);
    }
}
