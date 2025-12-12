//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "NsGui/Span.h"

extern "C" {
static Noesis::Span *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.Span ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::Span *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSSpan_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::Span());
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSSpan_nGetInlines(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto span = getComponent(env, ptr);
    if (span == nullptr) return 0;
    return reinterpret_cast<jlong>(span->GetInlines());
}
}
