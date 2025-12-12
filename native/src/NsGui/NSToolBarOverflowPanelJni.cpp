//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "NsGui/ToolBarOverflowPanel.h"

extern "C" {
static Noesis::ToolBarOverflowPanel *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.ToolBarOverflowPanel ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::ToolBarOverflowPanel *>(handle);
}


JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSToolBarOverflowPanel_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::ToolBarOverflowPanel());
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSToolBarOverflowPanel_nGetWrapWidth(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetWrapWidth();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSToolBarOverflowPanel_nSetWrapWidth(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetWrapWidth(value);
}
}
