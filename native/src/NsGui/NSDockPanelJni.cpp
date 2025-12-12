//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "NsGui/DockPanel.h"

extern "C" {
    static Noesis::DockPanel *getComponent(JNIEnv *env, const jlong handle) {
        if (handle == 0) {
            jclass excCls = env->FindClass("java/lang/IllegalStateException");
            if (excCls != nullptr) {
                env->ThrowNew(excCls, "Noesis.DockPanel ptr is null");
            }
            return nullptr;
        }
        return reinterpret_cast<Noesis::DockPanel *>(handle);
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSDockPanel_nCreate(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(new Noesis::DockPanel());
    }

    JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSDockPanel_nGetDockStatic(JNIEnv* env, jclass clazz, jlong element_ptr) {
        return Noesis::DockPanel::GetDock(reinterpret_cast<Noesis::DependencyObject *>(element_ptr));
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSDockPanel_nSetDockStatic(JNIEnv* env, jclass clazz, jlong element_ptr, jint value) {
        Noesis::DockPanel::SetDock(reinterpret_cast<Noesis::DependencyObject *>(element_ptr), static_cast<Noesis::Dock>(value));
    }

    JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSDockPanel_nGetLastChildFill(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return 0;
        return component->GetLastChildFill();
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSDockPanel_nSetLastChildFill(JNIEnv* env, jclass clazz, jlong ptr, jboolean value) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->SetLastChildFill(value);
    }

}
