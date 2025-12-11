//
// Created by Sixik on 11.12.2025.
//

#include <jni.h>

#include "NsGui/RepeatButton.h"
#include "NsMath/AABBox.h"


extern "C" {

static Noesis::RepeatButton *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.RepeatButton ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::RepeatButton *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSRepeatButton_nCreate(JNIEnv* env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::RepeatButton());
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSRepeatButton_nGetDelay(JNIEnv* env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetDelay();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSRepeatButton_nSetDelay(JNIEnv* env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetDelay(value);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSRepeatButton_nGetInterval(JNIEnv* env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetInterval();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSRepeatButton_nSetInterval(JNIEnv* env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetInterval(value);
}
}
