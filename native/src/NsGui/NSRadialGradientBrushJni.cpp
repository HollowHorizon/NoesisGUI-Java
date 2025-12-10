//
// Created by Sixik on 11.12.2025.
//

#include <jni.h>

#include "../utils/NSJniUtils.h"
#include "NsGui/RadialGradientBrush.h"

extern "C" {
static Noesis::RadialGradientBrush *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.RadialGradientBrush ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::RadialGradientBrush *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSRadialGradientBrush_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::RadialGradientBrush());
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSRadialGradientBrush_nGetRadiusX(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetRadiusX();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSRadialGradientBrush_nSetRadiusX(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetRadiusX(value);
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSRadialGradientBrush_nGetRadiusY(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetRadiusY();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSRadialGradientBrush_nSetRadiusY(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetRadiusY(value);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSRadialGradientBrush_nGetCenter(
    JNIEnv *env, jclass clazz, jlong ptr, jobject point) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    NSJniUtils::PointFromCopy(env, component->GetCenter(), point);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSRadialGradientBrush_nSetCenter(
    JNIEnv *env, jclass clazz, jlong ptr, jobject point) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    Noesis::Point p  = Noesis::Point();
    NSJniUtils::PointToCopy(env, p, point);
    component->SetCenter(p);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSRadialGradientBrush_nGetGradientOrigin(
    JNIEnv *env, jclass clazz, jlong ptr, jobject point) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    NSJniUtils::PointFromCopy(env, component->GetGradientOrigin(), point);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSRadialGradientBrush_nSetGradientOrigin(
    JNIEnv *env, jclass clazz, jlong ptr, jobject point) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    Noesis::Point p  = Noesis::Point();
    NSJniUtils::PointToCopy(env, p, point);
    component->SetGradientOrigin(p);
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSRadialGradientBrush_nCenterProperty(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(Noesis::RadialGradientBrush::CenterProperty);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSRadialGradientBrush_nGradientOriginProperty(
    JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(Noesis::RadialGradientBrush::GradientOriginProperty);
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSRadialGradientBrush_nRadiusXProperty(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(Noesis::RadialGradientBrush::RadiusXProperty);
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSRadialGradientBrush_nRadiusYProperty(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(Noesis::RadialGradientBrush::RadiusYProperty);
}
}
