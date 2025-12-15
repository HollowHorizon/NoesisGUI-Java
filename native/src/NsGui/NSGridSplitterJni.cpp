//
// Created by Sixik on 15.12.2025.
//

#include <jni.h>

#include "NsGui/GridSplitter.h"

extern "C" {
static Noesis::GridSplitter *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.GridSplitter ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::GridSplitter *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridSplitter_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::GridSplitter());
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridSplitter_nGetDragIncrement(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetDragIncrement();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridSplitter_nSetDragIncrement(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetDragIncrement(value);
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridSplitter_nGetKeyboardIncrement(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetKeyboardIncrement();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridSplitter_nSetKeyboardIncrement(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetKeyboardIncrement(value);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridSplitter_nGetResizeDirection(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetResizeDirection();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridSplitter_nSetResizeDirection(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetResizeDirection(static_cast<Noesis::GridResizeDirection>(value));
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridSplitter_nGetResizeBehavior(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetResizeBehavior();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridSplitter_nSetResizeBehavior(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetResizeBehavior(static_cast<Noesis::GridResizeBehavior>(value));
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridSplitter_nGetShowsPreview(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetShowsPreview();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridSplitter_nSetShowsPreview(
    JNIEnv *env, jclass clazz, jlong ptr, jboolean value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetShowsPreview(value);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridSplitter_nGetPreviewStyle(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetPreviewStyle());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridSplitter_nSetPreviewStyle(
    JNIEnv *env, jclass clazz, jlong ptr, jlong style_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetPreviewStyle(reinterpret_cast<Noesis::Style *>(style_ptr));
}
}
