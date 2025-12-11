//
// Created by Sixik on 11.12.2025.
//

#include <jni.h>

#include "NsGui/GridViewColumnHeader.h"

extern "C" {

    static Noesis::GridViewColumnHeader *getComponent(JNIEnv *env, const jlong handle) {
        if (handle == 0) {
            jclass excCls = env->FindClass("java/lang/IllegalStateException");
            if (excCls != nullptr) {
                env->ThrowNew(excCls, "Noesis.GridViewColumnHeader ptr is null");
            }
            return nullptr;
        }
        return reinterpret_cast<Noesis::GridViewColumnHeader *>(handle);
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridViewColumnHeader_nCreate(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(new Noesis::GridViewColumnHeader());
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridViewColumnHeader_nGetColumn(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return 0;
        return reinterpret_cast<jlong>(component->GetColumn());
    }

    JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSGridViewColumnHeader_nGetRole(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return -1;
        return component->GetRole();
    }

}
