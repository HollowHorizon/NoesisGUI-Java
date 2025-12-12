//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "NsGui/Inline.h"

extern "C" {
static Noesis::Inline *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.Inline ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::Inline *>(handle);
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSInline_nGetSiblingInlines(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetSiblingInlines());
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSInline_nGetPreviousInline(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetPreviousInline());
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSInline_nGetNextInline(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetNextInline());
}

JNIEXPORT jint JNICALL
Java_dev_sixik_noesisgui_nsgui_NSInline_nGetTextDecorations(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetTextDecorations();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSInline_nSetTextDecorations(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetTextDecorations(static_cast<Noesis::TextDecorations>(value));
}
}
