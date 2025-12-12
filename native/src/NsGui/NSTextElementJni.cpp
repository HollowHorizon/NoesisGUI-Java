//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "../utils/NSJniUtils.h"
#include "NsGui/TextElement.h"

extern "C" {
static Noesis::TextElement *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.TextElement ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::TextElement *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetBackground(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetBackground());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetBackground(
    JNIEnv *env, jclass clazz, jlong ptr, jlong brush_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetBackground(reinterpret_cast<Noesis::Brush *>(brush_ptr));
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetCharacterSpacing(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetCharacterSpacing();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetCharacterSpacing(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetCharacterSpacing(value);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetFontFamily(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetFontFamily());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetFontFamily(
    JNIEnv *env, jclass clazz, jlong ptr, jlong fontFamily_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetFontFamily(reinterpret_cast<Noesis::FontFamily *>(fontFamily_ptr));
}

JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetFontSize(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetFontSize();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetFontSize(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetFontSize(value);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetFontStretch(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetFontStretch();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetFontStretch(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetFontStretch(static_cast<Noesis::FontStretch>(value));
}

JNIEXPORT jint JNICALL
Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetFontStyle(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetFontStyle();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetFontStyle(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetFontStyle(static_cast<Noesis::FontStyle>(value));
}

JNIEXPORT jint JNICALL
Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetFontWeight(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetFontWeight();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetFontWeight(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetFontWeight(static_cast<Noesis::FontWeight>(value));
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetForeground(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetForeground());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetForeground(
    JNIEnv *env, jclass clazz, jlong ptr, jlong brush_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetForeground(reinterpret_cast<Noesis::Brush *>(brush_ptr));
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetStroke(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetStroke());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetStroke(
    JNIEnv *env, jclass clazz, jlong ptr, jlong brush_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetStroke(reinterpret_cast<Noesis::Brush *>(brush_ptr));
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetStrokeThickness(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetStrokeThickness();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetStrokeThickness(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetStrokeThickness(value);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetTypography(
    JNIEnv *env, jclass clazz, jlong ptr, jobject typography) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    NSJniUtils::TypographyFromCopy(env, component->GetTypography(), typography);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetTypography(
    JNIEnv *env, jclass clazz, jlong ptr, jobject typography) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    NSJniUtils::TypographyToCopy(env, component->GetTypography(), typography);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetFontFamilyStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr) {
    return reinterpret_cast<jlong>(Noesis::TextElement::GetFontFamily(reinterpret_cast<Noesis::DependencyObject*>(element_ptr)));
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetFontFamilyStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr, jlong fontFamily_ptr) {
    Noesis::TextElement::SetFontFamily(reinterpret_cast<Noesis::DependencyObject*>(element_ptr), reinterpret_cast<Noesis::FontFamily *>(fontFamily_ptr));
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetFontSizeStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr) {
    return Noesis::TextElement::GetFontSize(reinterpret_cast<Noesis::DependencyObject*>(element_ptr));
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetFontSizeStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr, jfloat size) {
    Noesis::TextElement::SetFontSize(reinterpret_cast<Noesis::DependencyObject*>(element_ptr), size);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetFontStretchStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr) {
    return Noesis::TextElement::GetFontStretch(reinterpret_cast<Noesis::DependencyObject*>(element_ptr));
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetFontStretchStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr, jint value) {
    Noesis::TextElement::SetFontStretch(reinterpret_cast<Noesis::DependencyObject*>(element_ptr), static_cast<Noesis::FontStretch>(value));
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetFontStyleStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr) {
    return Noesis::TextElement::GetFontStyle(reinterpret_cast<Noesis::DependencyObject*>(element_ptr));
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetFontStyleStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr, jint value) {
    Noesis::TextElement::SetFontStyle(reinterpret_cast<Noesis::DependencyObject*>(element_ptr), static_cast<Noesis::FontStyle>(value));
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetFontWeightStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr) {
    return Noesis::TextElement::GetFontWeight(reinterpret_cast<Noesis::DependencyObject*>(element_ptr));
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetFontWeightStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr, jint value) {
    Noesis::TextElement::SetFontWeight(reinterpret_cast<Noesis::DependencyObject*>(element_ptr), static_cast<Noesis::FontWeight>(value));
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetForegroundStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr) {
    return reinterpret_cast<jlong>(Noesis::TextElement::GetForeground(reinterpret_cast<Noesis::DependencyObject*>(element_ptr)));
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetForegroundStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr, jlong brush_ptr) {
    Noesis::TextElement::SetForeground(reinterpret_cast<Noesis::DependencyObject*>(element_ptr), reinterpret_cast<Noesis::Brush *>(brush_ptr));
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetStrokeStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr) {
    return reinterpret_cast<jlong>(Noesis::TextElement::GetStroke(reinterpret_cast<Noesis::DependencyObject*>(element_ptr)));
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetStrokeStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr, jlong brush_ptr) {
    Noesis::TextElement::SetStroke(reinterpret_cast<Noesis::DependencyObject*>(element_ptr), reinterpret_cast<Noesis::Brush *>(brush_ptr));
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nGetStrokeThicknessStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr) {
    return Noesis::TextElement::GetStrokeThickness(reinterpret_cast<Noesis::DependencyObject*>(element_ptr));
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextElement_nSetStrokeThicknessStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr, jfloat value) {
    Noesis::TextElement::SetStrokeThickness(reinterpret_cast<Noesis::DependencyObject*>(element_ptr), value);
}
}
