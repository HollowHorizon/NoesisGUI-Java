//
// Created by Sixik on 11.12.2025.
//

#include <jni.h>

#include "NsGui/Page.h"

extern "C" {

    static Noesis::Page *getComponent(JNIEnv *env, const jlong handle) {
        if (handle == 0) {
            jclass excCls = env->FindClass("java/lang/IllegalStateException");
            if (excCls != nullptr) {
                env->ThrowNew(excCls, "Noesis.Page ptr is null");
            }
            return nullptr;
        }
        return reinterpret_cast<Noesis::Page *>(handle);
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSPage_nCreate(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(new Noesis::Page());
    }

    JNIEXPORT jstring JNICALL Java_dev_sixik_noesisgui_nsgui_NSPage_nGetTitle(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return env->NewStringUTF("");
        return env->NewStringUTF(component->GetTitle());
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSPage_nSetTitle(JNIEnv* env, jclass clazz, jlong ptr, jstring title) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;

        const char *cstr = env->GetStringUTFChars(title, nullptr);
        if (cstr == nullptr) {
            return;
        }

        component->SetTitle(cstr);
        env->ReleaseStringUTFChars(title, cstr);
    }
}
