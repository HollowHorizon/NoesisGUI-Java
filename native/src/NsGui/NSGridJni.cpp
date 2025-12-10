//
// Created by Sixik on 10.12.2025.
//

#include <jni.h>

#include "NsGui/Grid.h"

extern "C" {

    static Noesis::Grid *getComponent(JNIEnv *env, const jlong handle) {
        if (handle == 0) {
            jclass excCls = env->FindClass("java/lang/IllegalStateException");
            if (excCls != nullptr) {
                env->ThrowNew(excCls, "Noesis.Grid ptr is null");
            }
            return nullptr;
        }
        return reinterpret_cast<Noesis::Grid *>(handle);
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGrid_nCreate(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(new Noesis::Grid());
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGrid_nGetColumnDefinitions(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return 0;
        return reinterpret_cast<jlong>(component->GetColumnDefinitions());
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGrid_nGetRowDefinitions(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return 0;
        return reinterpret_cast<jlong>(component->GetRowDefinitions());
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGrid_nGetColumn(JNIEnv* env, jclass clazz, jlong element_ptr) {
        return Noesis::Grid::GetColumn(reinterpret_cast<Noesis::DependencyObject*>(element_ptr));
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSGrid_nSetColumn(JNIEnv* env, jclass clazz, jlong element_ptr, jint column) {
        Noesis::Grid::SetColumn(reinterpret_cast<Noesis::DependencyObject*>(element_ptr), column);
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGrid_nGetColumnSpan(JNIEnv* env, jclass clazz, jlong element_ptr) {
        return Noesis::Grid::GetColumnSpan(reinterpret_cast<Noesis::DependencyObject*>(element_ptr));
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSGrid_nSetColumnSpan(JNIEnv* env, jclass clazz, jlong element_ptr, jint column_span) {
        Noesis::Grid::SetColumnSpan(reinterpret_cast<Noesis::DependencyObject*>(element_ptr), column_span);
    }

    JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSGrid_nGetIsSharedSizeScope(JNIEnv* env, jclass clazz, jlong element_ptr) {
        return Noesis::Grid::GetIsSharedSizeScope(reinterpret_cast<Noesis::DependencyObject*>(element_ptr));
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSGrid_nSetIsSharedSizeScope(JNIEnv* env, jclass clazz, jlong element_ptr, jboolean value) {
        Noesis::Grid::SetIsSharedSizeScope(reinterpret_cast<Noesis::DependencyObject*>(element_ptr), value);
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGrid_nGetRow(JNIEnv* env, jclass clazz, jlong element_ptr) {
        return Noesis::Grid::GetRow(reinterpret_cast<Noesis::DependencyObject*>(element_ptr));
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSGrid_nSetRow(JNIEnv* env, jclass clazz, jlong element_ptr, jint row) {
        Noesis::Grid::SetRow(reinterpret_cast<Noesis::DependencyObject*>(element_ptr), row);
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGrid_nGetRowSpan(JNIEnv* env, jclass clazz, jlong element_ptr) {
        return Noesis::Grid::GetRowSpan(reinterpret_cast<Noesis::DependencyObject*>(element_ptr));
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSGrid_nSetRowSpan(JNIEnv* env, jclass clazz, jlong element_ptr, jint rowSpan) {
        Noesis::Grid::SetRowSpan(reinterpret_cast<Noesis::DependencyObject*>(element_ptr), rowSpan);
    }

}
