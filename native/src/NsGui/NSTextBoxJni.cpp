//
// Created by Sixik on 11.12.2025.
//

#include <jni.h>

#include "../utils/NSJniUtils.h"
#include "NsGui/TextBox.h"

extern "C" {
static Noesis::TextBox *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.TextBox ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::TextBox *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::TextBox());
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetCaretIndex(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetCaretIndex();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nSetCaretIndex(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetCaretIndex(value);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetMaxLength(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetMaxLength();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nSetMaxLength(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetMaxLength(value);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetMaxLines(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetMaxLines();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nSetMaxLines(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetMaxLines(value);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetMinLines(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetMinLines();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nSetMinLines(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetMinLines(value);
}

JNIEXPORT jstring JNICALL
Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetPlaceholder(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return env->NewStringUTF("");
    return env->NewStringUTF(component->GetPlaceholder());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nSetPlaceholder(
    JNIEnv *env, jclass clazz, jlong ptr, jstring text) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;

    const char *cstr = env->GetStringUTFChars(text, nullptr);
    if (cstr == nullptr) {
        return;
    }

    component->SetPlaceholder(cstr);
    env->ReleaseStringUTFChars(text, cstr);
}

JNIEXPORT jstring JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetSelectedText(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return env->NewStringUTF("");
    return env->NewStringUTF(component->GetSelectedText());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nSetSelectedText(
    JNIEnv *env, jclass clazz, jlong ptr, jstring text) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;

    const char *cstr = env->GetStringUTFChars(text, nullptr);
    if (cstr == nullptr) {
        return;
    }

    component->SetSelectedText(cstr);
    env->ReleaseStringUTFChars(text, cstr);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetSelectionLength(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetSelectionLength();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nSetSelectionLength(
    JNIEnv *env, jclass clazz, jlong ptr, jint length) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetSelectionLength(length);
}

JNIEXPORT jint JNICALL
Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetSelectionStart(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetSelectionStart();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nSetSelectionStart(
    JNIEnv *env, jclass clazz, jlong ptr, jint pos) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetSelectionStart(pos);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nSelectAll(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SelectAll();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nSelect(JNIEnv *env, jclass clazz, jlong ptr,
                                                                        jint start, jint length) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->Select(start, length);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nClear(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->Clear();
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetCharacterIndexFromPoint(
    JNIEnv *env, jclass clazz, jlong ptr, jobject point, jboolean snapToText) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    Noesis::Point _p = Noesis::Point();
    NSJniUtils::PointToCopy(env, _p, point);
    return component->GetCharacterIndexFromPoint(_p, snapToText);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetCharacterIndexFromLineIndex(
    JNIEnv *env, jclass clazz, jlong ptr, jint lineIndex) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetCharacterIndexFromLineIndex(lineIndex);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetLineIndexFromCharacterIndex(
    JNIEnv *env, jclass clazz, jlong ptr, jint charIndex) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetCharacterIndexFromLineIndex(charIndex);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetLineLength(
    JNIEnv *env, jclass clazz, jlong ptr, jint lineIndex) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetLineLength(lineIndex);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetFirstVisibleLineIndex(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetFirstVisibleLineIndex();
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetLastVisibleLineIndex(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetLastVisibleLineIndex();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nScrollToLine(
    JNIEnv *env, jclass clazz, jlong ptr, jint lineIndex) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->ScrollToLine(lineIndex);
}

JNIEXPORT jint JNICALL
Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetTextAlignment(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetTextAlignment();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nSetTextAlignment(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetTextAlignment(static_cast<Noesis::TextAlignment>(value));
}

JNIEXPORT jstring JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetText(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return env->NewStringUTF("");
    return env->NewStringUTF(component->GetText());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nSetText(
    JNIEnv *env, jclass clazz, jlong ptr, jstring text) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;

    const char *cstr = env->GetStringUTFChars(text, nullptr);
    if (cstr == nullptr) {
        return;
    }

    component->SetText(cstr);
    env->ReleaseStringUTFChars(text, cstr);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetTextWrapping(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetTextWrapping();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nSetTextWrapping(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetTextWrapping(static_cast<Noesis::TextWrapping>(value));
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetTextView(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetTextView());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetRangeBounds(
    JNIEnv *env, jclass clazz, jlong ptr, jobject rect, jint start, jint end) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    NSJniUtils::RectFromCopy(env, component->GetRangeBounds(start, end), rect);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nHideCaret(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->HideCaret();
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetNumCompositionUnderlines(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetNumCompositionUnderlines();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetCompositionUnderline(
    JNIEnv *env, jclass clazz, jlong ptr, jobject line, jlong index) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    NSJniUtils::CompositionUnderlineFromCopy(env, component->GetCompositionUnderline(index), line);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nAddCompositionUnderline(
    JNIEnv *env, jclass clazz, jlong ptr, jobject line) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    Noesis::CompositionUnderline composition_underline = Noesis::CompositionUnderline();
    NSJniUtils::CompositionUnderlineToCopy(env, composition_underline, line);
    component->AddCompositionUnderline(composition_underline);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nClearCompositionUnderlines(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->ClearCompositionUnderlines();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nGetTypography(
    JNIEnv *env, jclass clazz, jlong ptr, jobject typography) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    NSJniUtils::TypographyFromCopy(env, component->GetTypography(), typography);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTextBox_nSetTypography(
    JNIEnv *env, jclass clazz, jlong ptr, jobject typography) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    NSJniUtils::TypographyToCopy(env, component->GetTypography(), typography);
}
}
