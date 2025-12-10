//
// Created by Sixik on 11.12.2025.
//

#include <jni.h>

#include "NsGui/Image.h"
#include "NsGui/ImageBrush.h"

extern "C" {
static Noesis::ImageBrush *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.ImageBrush ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::ImageBrush *>(handle);
}


JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSImageBrush_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::ImageBrush());
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSImageBrush_nCreateImage(
    JNIEnv *env, jclass clazz, jlong image_ptr) {
    return reinterpret_cast<jlong>(new Noesis::ImageBrush(reinterpret_cast<Noesis::ImageSource *>(image_ptr)));
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSImageBrush_nGetImageSource(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetImageSource());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSImageBrush_nSetImageSource(
    JNIEnv *env, jclass clazz, jlong ptr, jlong source_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetImageSource(reinterpret_cast<Noesis::ImageSource *>(source_ptr));
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSImageBrush_nGetShader(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetShader());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSImageBrush_nSetShader(
    JNIEnv *env, jclass clazz, jlong ptr, jlong shader_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetShader(reinterpret_cast<Noesis::BrushShader *>(shader_ptr));
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSImageBrush_nImageSourceProperty(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(Noesis::ImageBrush::ImageSourceProperty);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSImageBrush_nShaderProperty(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(Noesis::ImageBrush::ShaderProperty);
}
}
