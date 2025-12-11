//
// Created by Sixik on 11.12.2025.
//

#include <jni.h>

#include "NsGui/RadioButton.h"

extern "C" {

    static Noesis::RadioButton *getComponent(JNIEnv *env, const jlong handle) {
        if (handle == 0) {
            jclass excCls = env->FindClass("java/lang/IllegalStateException");
            if (excCls != nullptr) {
                env->ThrowNew(excCls, "Noesis.RadioButton ptr is null");
            }
            return nullptr;
        }
        return reinterpret_cast<Noesis::RadioButton *>(handle);
    }

    JNIEXPORT jlong JNICALL
    Java_dev_sixik_noesisgui_nsgui_NSRadioButton_nCreate(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(new Noesis::RadioButton());
    }

    JNIEXPORT jstring JNICALL
    Java_dev_sixik_noesisgui_nsgui_NSRadioButton_nGetGroupName(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return nullptr;
        return env->NewStringUTF(component->GetGroupName());
    }

    JNIEXPORT void JNICALL
    Java_dev_sixik_noesisgui_nsgui_NSRadioButton_nSetGroupName(JNIEnv* env, jclass clazz, jlong ptr, jstring content) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        const char *cstr = env->GetStringUTFChars(content, nullptr);
        if (cstr == nullptr) {
            return;
        }

        component->SetGroupName(cstr);
        env->ReleaseStringUTFChars(content, cstr);
    }

}
