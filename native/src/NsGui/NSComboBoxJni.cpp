//
// Created by Sixik on 16.12.2025.
//

#include <jni.h>

#include "NsGui/ComboBox.h"

extern "C" {
static Noesis::ComboBox *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.ComboBox ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::ComboBox *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::ComboBox());
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nGetIsDropDownOpen(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetIsDropDownOpen();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nSetIsDropDownOpen(
    JNIEnv *env, jclass clazz, jlong ptr, jboolean value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetIsDropDownOpen(value);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nGetIsEditable(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetIsEditable();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nSetIsEditable(
    JNIEnv *env, jclass clazz, jlong ptr, jboolean value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetIsEditable(value);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nGetIsReadOnly(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetIsReadOnly();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nSetIsReadOnly(
    JNIEnv *env, jclass clazz, jlong ptr, jboolean value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetIsReadOnly(value);
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nGetMaxDropDownHeight(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetMaxDropDownHeight();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nSetMaxDropDownHeight(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetMaxDropDownHeight(value);
}

JNIEXPORT jstring JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nGetPlaceholder(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return env->NewStringUTF("");
    return env->NewStringUTF(component->GetPlaceholder());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nSetPlaceholder(
    JNIEnv *env, jclass clazz, jlong ptr, jstring value) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr || value == nullptr) return;

    const char *cstr = env->GetStringUTFChars(value, nullptr);
    if (cstr == nullptr) {
        return;
    }


    obj->SetPlaceholder(cstr);
    env->ReleaseStringUTFChars(value, cstr);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nGetSelectionBoxItem(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetSelectionBoxItem());
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nGetSelectionBoxItemTemplate(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetSelectionBoxItemTemplate());
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nGetStaysOpenOnEdit(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetStaysOpenOnEdit();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nSetStaysOpenOnEdit(
    JNIEnv *env, jclass clazz, jlong ptr, jboolean value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetStaysOpenOnEdit(value);
}

JNIEXPORT jstring JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nGetText(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return env->NewStringUTF("");
    return env->NewStringUTF(component->GetText());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nSetText(
    JNIEnv *env, jclass clazz, jlong ptr, jstring value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;

    const char *cstr = env->GetStringUTFChars(value, nullptr);
    if (cstr == nullptr) {
        return;
    }


    component->SetText(cstr);
    env->ReleaseStringUTFChars(value, cstr);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSComboBox_nScrollIntoView(
    JNIEnv *env, jclass clazz, jlong ptr, jlong element_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->ScrollIntoView(reinterpret_cast<Noesis::BaseComponent *>(element_ptr));
}
}
