//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "NsGui/UniformGrid.h"

extern "C" {
static Noesis::UniformGrid *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.UniformGrid ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::UniformGrid *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSUniformGrid_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::UniformGrid());
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSUniformGrid_nGetFirstColumn(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetFirstColumn();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSUniformGrid_nSetFirstColumn(
    JNIEnv *env, jclass clazz, jlong ptr, jlong value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetFirstColumn(value);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSUniformGrid_nGetColumns(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetColumns();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSUniformGrid_nSetColumns(
    JNIEnv *env, jclass clazz, jlong ptr, jlong value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetColumns(value);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSUniformGrid_nGetRows(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetRows();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSUniformGrid_nSetRows(
    JNIEnv *env, jclass clazz, jlong ptr, jlong value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetRows(value);
}
}
