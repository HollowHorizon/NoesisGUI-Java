//
// Created by Sixik on 10.12.2025.
//

#include <jni.h>

#include "../utils/NSJniUtils.h"
#include "NsGui/SolidColorBrush.h"

static Noesis::SolidColorBrush *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.SolidColorBrush ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::SolidColorBrush *>(handle);
}

extern "C" {

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSSolidColorBrush_nCreateByColor(JNIEnv* env, jclass clazz, jobject color) {
    Noesis::Color nColor = Noesis::Color();
    NSJniUtils::ColorToCopy(env, nColor, color);
    return reinterpret_cast<jlong>(new Noesis::SolidColorBrush(nColor));
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSSolidColorBrush_nGetColor(JNIEnv* env, jclass clazz, jlong ptr, jobject color) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    NSJniUtils::ColorFromCopy(env, component->GetColor(), color);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSSolidColorBrush_nSetColor(JNIEnv* env, jclass clazz, jlong ptr, jobject color) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    Noesis::Color ncolor = Noesis::Color();
    NSJniUtils::ColorToCopy(env, ncolor, color);
    component->SetColor(ncolor);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSSolidColorBrush_nColorProperty(JNIEnv* env, jclass clazz) {
    return reinterpret_cast<jlong>(Noesis::SolidColorBrush::ColorProperty);
}

    }
