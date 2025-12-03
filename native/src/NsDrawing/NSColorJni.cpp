//
// Created by Sixik on 03.12.2025.
//

// ColorJNI.cpp
#include <jni.h>
#include <stdexcept>

#include <NsDrawing/Color.h>
#include <NsCore/String.h>

using namespace Noesis;

static Color* getColor(JNIEnv* env, jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.Color ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Color*>(handle);
}

extern "C" {

    JNIEXPORT jlong JNICALL
    Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeCreate(JNIEnv* env, jclass) {
        Color* color = new Color();
        return reinterpret_cast<jlong>(color);
    }

    JNIEXPORT jlong JNICALL
    Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeCreateRGBA(JNIEnv* env, jclass,
        jfloat r, jfloat g, jfloat b, jfloat a) {
        auto color = new Color(r, g, b, a);
        return reinterpret_cast<jlong>(color);
    }

    JNIEXPORT void JNICALL
    Java_dev_sixik_noesisgui_nsdrawing_NSColor_nativeDestroy(JNIEnv* env, jclass, jlong ptr) {
        delete reinterpret_cast<Color*>(ptr);
    }
}