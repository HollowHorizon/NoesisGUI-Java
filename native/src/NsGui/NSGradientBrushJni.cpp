//
// Created by Sixik on 10.12.2025.
//

#include <jni.h>

#include "NsGui/GradientBrush.h"

namespace Noesis {
    class GradientStop;
    class GradientBrush;
}

extern "C" {

static Noesis::GradientBrush *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.GradientBrush ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::GradientBrush *>(handle);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSGradientBrush_nGetColorInterpolationMode(JNIEnv* env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetColorInterpolationMode();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSGradientBrush_nSetColorInterpolationMode(JNIEnv* env, jclass clazz, jlong ptr, jint ordinal) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetColorInterpolationMode(static_cast<Noesis::ColorInterpolationMode>(ordinal));
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGradientBrush_nGetGradientStops(JNIEnv* env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetGradientStops());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSGradientBrush_nSetGradientStops(JNIEnv* env, jclass clazz, jlong ptr, jlong collection_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetGradientStops(reinterpret_cast<Noesis::GradientStopCollection*>(collection_ptr));
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSGradientBrush_nGetMappingMode(JNIEnv* env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetMappingMode();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSGradientBrush_nSetMappingMode(JNIEnv* env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetMappingMode(static_cast<Noesis::BrushMappingMode>(value));
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSGradientBrush_nGetSpreadMethod(JNIEnv* env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetSpreadMethod();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSGradientBrush_nSetSpreadMethod(JNIEnv* env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetSpreadMethod(static_cast<Noesis::GradientSpreadMethod>(value));
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGradientBrush_nColorInterpolationModeProperty(JNIEnv* env, jclass clazz) {
    return reinterpret_cast<jlong>(Noesis::GradientBrush::ColorInterpolationModeProperty);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGradientBrush_nGradientStopsProperty(JNIEnv* env, jclass clazz) {
    return reinterpret_cast<jlong>(Noesis::GradientBrush::GradientStopsProperty);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGradientBrush_nMappingModeProperty(JNIEnv* env, jclass clazz) {
    return reinterpret_cast<jlong>(Noesis::GradientBrush::MappingModeProperty);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGradientBrush_nSpreadMethodProperty(JNIEnv* env, jclass clazz) {
    return reinterpret_cast<jlong>(Noesis::GradientBrush::SpreadMethodProperty);
}
}
