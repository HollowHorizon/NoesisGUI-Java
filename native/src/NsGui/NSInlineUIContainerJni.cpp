//
// Created by Sixik on 12.12.2025.
//


#include <jni.h>

#include "NsGui/InlineUIContainer.h"

extern "C" {
static Noesis::InlineUIContainer *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.InlineUIContainer ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::InlineUIContainer *>(handle);
}


JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSInlineUIContainer_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::InlineUIContainer());
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSInlineUIContainer_nGetChild(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSInlineUIContainer_nSetChild(
    JNIEnv *env, jclass clazz, jlong ptr, jlong element_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetChild(reinterpret_cast<Noesis::UIElement *>(element_ptr));
}
}
