//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "NsGui/WrapPanel.h"

extern "C" {
static Noesis::WrapPanel *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.WrapPanel ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::WrapPanel *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSWrapPanel_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::WrapPanel());
}


JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsgui_NSWrapPanel_nGetItemWidth(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetItemWidth();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSWrapPanel_nSetItemWidth(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetItemWidth(value);
}

JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsgui_NSWrapPanel_nGetItemHeight(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetItemHeight();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSWrapPanel_nSetItemHeight(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetItemHeight(value);
}

JNIEXPORT jint JNICALL
Java_dev_sixik_noesisgui_nsgui_NSWrapPanel_nGetOrientation(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetOrientation();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSWrapPanel_nSetOrientation(
    JNIEnv *env, jclass clazz, jlong ptr, jint orientation) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetOrientation(static_cast<Noesis::Orientation>(orientation));
}
}
