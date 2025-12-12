//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "NsGui/Grid.h"
#include "NsGui/UICollection.h"
#include "NsGui/Trigger.h"

extern "C" {
static Noesis::TriggerCollection *getComponent(JNIEnv *env, const jlong handle) {
        if (handle == 0) {
            jclass excCls = env->FindClass("java/lang/IllegalStateException");
            if (excCls != nullptr) {
                env->ThrowNew(excCls, "Noesis.TriggerCollection ptr is null");
            }
            return nullptr;
        }
        return reinterpret_cast<Noesis::TriggerCollection *>(handle);
    }


    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSTriggerCollection_nGet(JNIEnv* env, jclass clazz, jlong ptr, jint value) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return 0;
        return reinterpret_cast<jlong>(component->Get(value));
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTriggerCollection_nSet(JNIEnv* env, jclass clazz, jlong ptr, jint value, jlong element_ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->Set(value, reinterpret_cast<Noesis::Trigger *>(element_ptr));
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTriggerCollection_nAdd(JNIEnv* env, jclass clazz, jlong ptr, jlong element_ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->Add(reinterpret_cast<Noesis::Trigger *>(element_ptr));
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSTriggerCollection_nInsert(JNIEnv* env, jclass clazz, jlong ptr, jint index, jlong element_ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->Insert(index, reinterpret_cast<Noesis::Trigger *>(element_ptr));
    }

    JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSTriggerCollection_nContains(JNIEnv* env, jclass clazz, jlong ptr, jlong element_ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return false;
        return component->Contains(reinterpret_cast<Noesis::Trigger *>(element_ptr));
    }

    JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSTriggerCollection_nIndexOf(JNIEnv* env, jclass clazz, jlong ptr, jlong element_ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return -1;
        return component->IndexOf(reinterpret_cast<Noesis::Trigger *>(element_ptr));
    }

    JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSTriggerCollection_nRemove(JNIEnv* env, jclass clazz, jlong ptr, jlong element_ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return false;
        return component->Remove(reinterpret_cast<Noesis::Trigger *>(element_ptr));
    }
}