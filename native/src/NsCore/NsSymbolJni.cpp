//
// Created by Sixik on 03.12.2025.
//

#include "jni.h"
#include "NoesisPCH.h"

extern "C" {

    static Noesis::Symbol *getSymbol(JNIEnv *env, const jlong handle) {
        if (handle == 0) {
            jclass excCls = env->FindClass("java/lang/IllegalStateException");
            if (excCls != nullptr) {
                env->ThrowNew(excCls, "Noesis.Symbol ptr is null");
            }
            return nullptr;
        }
        return reinterpret_cast<Noesis::Symbol *>(handle);
    }

    JNIEXPORT jlong JNICALL
    Java_dev_sixik_noesisgui_nscore_NSSymbol_nativeCreate(JNIEnv *env, jclass) {
        const auto symbol = new Noesis::Symbol();
        return reinterpret_cast<jlong>(symbol);
    }

    JNIEXPORT jlong JNICALL
    Java_dev_sixik_noesisgui_nscore_NSSymbol_nativeCreateByIndex(JNIEnv *env, jclass, const jint index) {
        const auto symbol = new Noesis::Symbol(index);
        return reinterpret_cast<jlong>(symbol);
    }

    JNIEXPORT jlong JNICALL
    Java_dev_sixik_noesisgui_nscore_NSSymbol_nativeCreateByName(JNIEnv *env, jclass, const jstring str) {
        const auto symbol = new Noesis::Symbol(env->GetStringUTFChars(str, 0));
        return reinterpret_cast<jlong>(symbol);
    }

    JNIEXPORT void JNICALL
    Java_dev_sixik_noesisgui_nscore_NSSymbol_nativeFree(JNIEnv *env, jclass, const jlong ptr) {
        delete getSymbol(env, ptr);
    }

    JNIEXPORT jboolean JNICALL
    Java_dev_sixik_noesisgui_nscore_NSSymbol_nativeIsNull(JNIEnv *env, jclass, const jlong ptr) {
        return getSymbol(env, ptr)->IsNull();
    }
}