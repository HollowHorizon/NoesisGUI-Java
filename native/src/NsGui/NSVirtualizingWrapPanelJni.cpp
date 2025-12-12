//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "NsGui/VirtualizingWrapPanel.h"

extern "C" {
static Noesis::VirtualizingWrapPanel *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.VirtualizingWrapPanel ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::VirtualizingWrapPanel *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSVirtualizingWrapPanel_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::VirtualizingWrapPanel());
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSVirtualizingWrapPanel_nGetItemWidth(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetItemWidth();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSVirtualizingWrapPanel_nSetItemWidth(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetItemWidth(value);
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSVirtualizingWrapPanel_nGetItemHeight(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetItemHeight();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSVirtualizingWrapPanel_nSetItemHeight(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetItemHeight(value);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSVirtualizingWrapPanel_nGetOrientation(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetOrientation();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSVirtualizingWrapPanel_nSetOrientation(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetOrientation(static_cast<Noesis::Orientation>(value));
}
}
