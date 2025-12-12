//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "NsGui/StackPanel.h"

extern "C" {
static Noesis::StackPanel *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.StackPanel ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::StackPanel *>(handle);
}


JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSStackPanel_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::StackPanel());
}

JNIEXPORT jint JNICALL
Java_dev_sixik_noesisgui_nsgui_NSStackPanel_nGetOrientation(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetOrientation();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSStackPanel_nSetOrientation(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetOrientation(static_cast<Noesis::Orientation>(value));
}
}
