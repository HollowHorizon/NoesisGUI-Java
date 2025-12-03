//
// Created by Sixik on 03.12.2025.
//
#include <jni.h>
#include <stdexcept>

#include <NsDrawing/CornerRadius.h>
#include <NsCore/String.h>

using namespace Noesis;

static CornerRadius *getCornerRadius(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.CornerRadius ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<CornerRadius *>(handle);
}

extern "C" {
JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSCornerRadius_nativeCreate(JNIEnv *env, jclass) {
    const auto *cornerRadius = new CornerRadius();
    return reinterpret_cast<jlong>(cornerRadius);
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSCornerRadius_nativeCreateRadius(JNIEnv *env, jclass, jfloat radius) {
    const auto *cornerRadius = new CornerRadius(radius);
    return reinterpret_cast<jlong>(cornerRadius);
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSCornerRadius_nativeCreateCorner(JNIEnv *env, jclass,
                                                                     jfloat tl, jfloat tr, jfloat br, jfloat bl) {
    const auto *cornerRadius = new CornerRadius(tl, tr, br, bl);
    return reinterpret_cast<jlong>(cornerRadius);
}

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSCornerRadius_nativeDestroy(JNIEnv *env, jclass, const jlong ptr) {
    delete getCornerRadius(env, ptr);
}

JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSCornerRadius_nativeGetTopLeft(JNIEnv *env, jclass, const jlong ptr) {
    const auto *cornerRadius = getCornerRadius(env, ptr);
    if (!cornerRadius) return 0.0f;
    return cornerRadius->topLeft;
}

JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSCornerRadius_nativeGetTopRight(JNIEnv *env, jclass, const jlong ptr) {
    const auto *cornerRadius = getCornerRadius(env, ptr);
    if (!cornerRadius) return 0.0f;
    return cornerRadius->topRight;
}

JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSCornerRadius_nativeGetBottomLeft(JNIEnv *env, jclass, const jlong ptr) {
    const auto *cornerRadius = getCornerRadius(env, ptr);
    if (!cornerRadius) return 0.0f;
    return cornerRadius->bottomLeft;
}

JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSCornerRadius_nativeGetBottomRight(JNIEnv *env, jclass, const jlong ptr) {
    const auto *cornerRadius = getCornerRadius(env, ptr);
    if (!cornerRadius) return 0.0f;
    return cornerRadius->bottomRight;
}

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSCornerRadius_nativeSetTopLeft(JNIEnv *env, jclass, const jlong ptr,
                                                                   const jfloat v) {
    auto *cornerRadius = getCornerRadius(env, ptr);
    if (!cornerRadius) return;
    cornerRadius->topLeft = v;
}

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSCornerRadius_nativeSetTopRight(JNIEnv *env, jclass, const jlong ptr,
                                                                    const jfloat v) {
    auto *cornerRadius = getCornerRadius(env, ptr);
    if (!cornerRadius) return;
    cornerRadius->topRight = v;
}

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSCornerRadius_nativeSetBottomRight(JNIEnv *env, jclass, const jlong ptr,
                                                                       const jfloat v) {
    auto *cornerRadius = getCornerRadius(env, ptr);
    if (!cornerRadius) return;
    cornerRadius->bottomRight = v;
}

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSCornerRadius_nativeSetBottomLeft(JNIEnv *env, jclass, const jlong ptr,
                                                                      const jfloat v) {
    auto *cornerRadius = getCornerRadius(env, ptr);
    if (!cornerRadius) return;
    cornerRadius->bottomLeft = v;
}
}
