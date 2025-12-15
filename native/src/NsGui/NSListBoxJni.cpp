//
// Created by Sixik on 16.12.2025.
//

#include <jni.h>

#include "NsGui/ListBox.h"

extern "C" {
    static Noesis::ListBox *getComponent(JNIEnv *env, const jlong handle) {
        if (handle == 0) {
            jclass excCls = env->FindClass("java/lang/IllegalStateException");
            if (excCls != nullptr) {
                env->ThrowNew(excCls, "Noesis.ListBox ptr is null");
            }
            return nullptr;
        }
        return reinterpret_cast<Noesis::ListBox *>(handle);
    }


    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSListBox_nCreate(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(new Noesis::ListBox());
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSListBox_nGetSelectedItems(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return 0;
        return reinterpret_cast<jlong>(component->GetSelectedItems());
    }

    JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSListBox_nGetSelectionMode(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return 0;
        return component->GetSelectionMode();
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSListBox_nSetSelectionMode(JNIEnv* env, jclass clazz, jlong ptr, jint value) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->SetSelectionMode(static_cast<Noesis::SelectionMode>(value));
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSListBox_nSelectAll(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->SelectAll();
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSListBox_nUnselectAll(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->UnselectAll();
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSListBox_nScrollIntoView(JNIEnv* env, jclass clazz, jlong ptr, jlong element_ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->ScrollIntoView(reinterpret_cast<Noesis::BaseComponent *>(element_ptr));
    }
}
