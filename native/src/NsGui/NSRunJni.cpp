//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "NsGui/Run.h"

extern "C" {

static Noesis::Run *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.Run ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::Run *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSRun_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::Run());
}

JNIEXPORT jstring JNICALL Java_dev_sixik_noesisgui_nsgui_NSRun_nGetText(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return env->NewStringUTF("");
    return env->NewStringUTF(component->GetText());
}

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSRun_nSetText(JNIEnv *env, jclass clazz, jlong ptr, jstring text) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;

    const char *cstr = env->GetStringUTFChars(text, nullptr);
    if (cstr == nullptr) {
        return;
    }
    component->SetText(cstr);
    env->ReleaseStringUTFChars(text, cstr);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSRun_nGetFontFeatures(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetFontFeatures();
}
}
