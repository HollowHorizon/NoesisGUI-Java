//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "NsGui/VirtualizingStackPanel.h"

extern "C" {
static Noesis::VirtualizingStackPanel *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.VirtualizingStackPanel ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::VirtualizingStackPanel *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSVirtualizingStackPanel_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::VirtualizingStackPanel());
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSVirtualizingStackPanel_nGetOrientation(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetOrientation();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSVirtualizingStackPanel_nSetOrientation(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetOrientation(static_cast<Noesis::Orientation>(value));
}
}
