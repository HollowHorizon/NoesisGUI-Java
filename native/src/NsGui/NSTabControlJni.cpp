//
// Created by Sixik on 16.12.2025.
//

#include <jni.h>

#include "NsGui/TabControl.h"

extern "C" {
static Noesis::TabControl *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.TabControl ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::TabControl *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTabControl_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::TabControl());
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTabControl_nGetContentTemplate(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetContentTemplate());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTabControl_nSetContentTemplate(
    JNIEnv *env, jclass clazz, jlong ptr, jlong element_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetContentTemplate(reinterpret_cast<Noesis::DataTemplate *>(element_ptr));
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTabControl_nGetContentTemplateSelector(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetContentTemplateSelector());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTabControl_nSetContentTemplateSelector(
    JNIEnv *env, jclass clazz, jlong ptr, jlong selector_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetContentTemplateSelector(reinterpret_cast<Noesis::DataTemplateSelector *>(selector_ptr));
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTabControl_nGetSelectedContent(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetSelectedContent());
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTabControl_nGetSelectedContentTemplate(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetSelectedContentTemplate());
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTabControl_nGetSelectedContentTemplateSelector(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetSelectedContentTemplateSelector());
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTabControl_nGetTabStripPlacement(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetTabStripPlacement();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTabControl_nSetTabStripPlacement(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetTabStripPlacement(static_cast<Noesis::Dock>(value));
}
}
