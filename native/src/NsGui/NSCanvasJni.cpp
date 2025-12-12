//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "NsGui/Canvas.h"

extern "C" {

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSCanvas_nCreate(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(new Noesis::Canvas());
    }

    JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSCanvas_nGetLeftStatic(JNIEnv* env, jclass clazz, jlong element_ptr) {
        return Noesis::Canvas::GetLeft(reinterpret_cast<Noesis::UIElement *>(element_ptr));
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSCanvas_nSetLeftStatic(JNIEnv* env, jclass clazz, jlong element_ptr, jfloat value) {
        Noesis::Canvas::SetLeft(reinterpret_cast<Noesis::UIElement *>(element_ptr), value);
    }

    JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSCanvas_nGetTopStatic(JNIEnv* env, jclass clazz, jlong element_ptr) {
        return Noesis::Canvas::GetTop(reinterpret_cast<Noesis::UIElement *>(element_ptr));
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSCanvas_nSetTopStatic(JNIEnv* env, jclass clazz, jlong element_ptr, jfloat value) {
        Noesis::Canvas::SetTop(reinterpret_cast<Noesis::UIElement *>(element_ptr), value);
    }

    JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSCanvas_nGetRightStatic(JNIEnv* env, jclass clazz, jlong element_ptr) {
        return Noesis::Canvas::GetRight(reinterpret_cast<Noesis::UIElement *>(element_ptr));
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSCanvas_nSetRightStatic(JNIEnv* env, jclass clazz, jlong element_ptr, jfloat value) {
        Noesis::Canvas::SetRight(reinterpret_cast<Noesis::UIElement *>(element_ptr), value);
    }

    JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSCanvas_nGetBottomStatic(JNIEnv* env, jclass clazz, jlong element_ptr) {
        return Noesis::Canvas::GetBottom(reinterpret_cast<Noesis::UIElement *>(element_ptr));
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSCanvas_nSetBottomStatic(JNIEnv* env, jclass clazz, jlong element_ptr, jfloat value) {
        Noesis::Canvas::SetBottom(reinterpret_cast<Noesis::UIElement *>(element_ptr), value);
    }
}
