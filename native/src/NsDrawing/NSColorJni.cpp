//
// Created by Sixik on 03.12.2025.
//

// ColorJNI.cpp
#include <jni.h>
#include <stdexcept>

#include <NsDrawing/Color.h>
#include <NsCore/String.h>

#include "../utils/NSJniUtils.h"

using namespace Noesis;

static Color *getColor(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.Color ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Color *>(handle);
}

extern "C" {
// ---------------- Constructors | Destructors ----------------

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeCreate(JNIEnv *env, jclass) {
    const auto color = new Color();
    return reinterpret_cast<jlong>(color);
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeCreateRGBA(JNIEnv *env, jclass,
                                                            const jfloat r, const jfloat g, const jfloat b,
                                                            const jfloat a) {
    auto color = new Color(r, g, b, a);
    return reinterpret_cast<jlong>(color);
}

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeDestroy(JNIEnv *env, jclass, const jlong ptr) {
    delete reinterpret_cast<Color *>(ptr);
}

// ---------------- Methods ----------------

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeSetScR(JNIEnv *env, jclass,
                                                        const jlong ptr, const jfloat v) {
    Color *c = getColor(env, ptr);
    if (!c) return;
    c->SetScR(v);
}

JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeGetScR(JNIEnv *env, jclass, const jlong ptr) {
    const Color *c = getColor(env, ptr);
    if (!c) return 0.0f;
    return c->GetScR();
}

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeSetScG(JNIEnv *env, jclass,
                                                        const jlong ptr, const jfloat v) {
    Color *c = getColor(env, ptr);
    if (!c) return;
    c->SetScG(v);
}

JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeGetScG(JNIEnv *env, jclass, const jlong ptr) {
    const Color *c = getColor(env, ptr);
    if (!c) return 0.0f;
    return c->GetScG();
}

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeSetScB(JNIEnv *env, jclass,
                                                        const jlong ptr, const jfloat v) {
    Color *c = getColor(env, ptr);
    if (!c) return;
    c->SetScB(v);
}

JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeGetScB(JNIEnv *env, jclass, const jlong ptr) {
    const Color *c = getColor(env, ptr);
    if (!c) return 0.0f;
    return c->GetScB();
}

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeSetScA(JNIEnv *env, jclass,
                                                        const jlong ptr, const jfloat v) {
    Color *c = getColor(env, ptr);
    if (!c) return;
    c->SetScA(v);
}

JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeGetScA(JNIEnv *env, jclass, const jlong ptr) {
    const Color *c = getColor(env, ptr);
    if (!c) return 0.0f;
    return c->GetScA();
}

JNIEXPORT jint JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeGetPackedRGBA(JNIEnv *env, jclass, const jlong ptr) {
    const Color *c = getColor(env, ptr);
    if (!c) return 0;
    return c->GetPackedColorRGBA();
}

JNIEXPORT jint JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeGetPackedBGRA(JNIEnv *env, jclass, const jlong ptr) {
    const Color *c = getColor(env, ptr);
    if (!c) return 0;
    return c->GetPackedColorBGRA();
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeFromPackedRGBA(JNIEnv *env, jclass, const jint packed) {
    const Color c = Color::FromPackedRGBA(static_cast<uint32_t>(packed));
    return reinterpret_cast<jlong>(new Color(c));
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeFromPackedBGRA(JNIEnv *env, jclass, const jint packed) {
    const Color c = Color::FromPackedBGRA(static_cast<uint32_t>(packed));
    return reinterpret_cast<jlong>(new Color(c));
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeBlack(JNIEnv *env, jclass) {
    return reinterpret_cast<jlong>(new Color(Color::Black()));
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeWhite(JNIEnv *env, jclass) {
    return reinterpret_cast<jlong>(new Color(Color::White()));
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeRed(JNIEnv *env, jclass) {
    return reinterpret_cast<jlong>(new Color(Color::Red()));
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeGreen(JNIEnv *env, jclass) {
    return reinterpret_cast<jlong>(new Color(Color::Green()));
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeBlue(JNIEnv *env, jclass) {
    return reinterpret_cast<jlong>(new Color(Color::Blue()));
}

JNIEXPORT jstring JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeToString(JNIEnv *env, jclass, const jlong handle) {
    const Color *c = getColor(env, handle);
    if (!c) return nullptr;

    const String s = c->ToString(); // "#AARRGGBB"
    return env->NewStringUTF(s.Str());
}

JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeGetR(JNIEnv *env, jclass, const jlong handle) {
    const Color *c = getColor(env, handle);
    if (!c) return 0.0f;
    return c->r;
}

JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeGetG(JNIEnv *env, jclass, const jlong handle) {
    const Color *c = getColor(env, handle);
    if (!c) return 0.0f;
    return c->g;
}

JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeGetB(JNIEnv *env, jclass, const jlong handle) {
    const Color *c = getColor(env, handle);
    if (!c) return 0.0f;
    return c->b;
}

JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeGetA(JNIEnv *env, jclass, const jlong handle) {
    const Color *c = getColor(env, handle);
    if (!c) return 0.0f;
    return c->a;
}

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeSetA(JNIEnv *env, jclass, const jlong handle, const jfloat v) {
    Color *c = getColor(env, handle);
    if (!c) return;
    c->a = v;
}

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeSetR(JNIEnv *env, jclass, const jlong handle, const jfloat v) {
    Color *c = getColor(env, handle);
    if (!c) return;
    c->r = v;
}

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeSetG(JNIEnv *env, jclass, const jlong handle, const jfloat v) {
    Color *c = getColor(env, handle);
    if (!c) return;
    c->g = v;
}

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeSetB(JNIEnv *env, jclass, const jlong handle, const jfloat v) {
    Color *c = getColor(env, handle);
    if (!c) return;
    c->b = v;
}
}
