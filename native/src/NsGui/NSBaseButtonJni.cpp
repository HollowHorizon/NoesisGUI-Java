//
// Created by Sixik on 10.12.2025.
//

#include <jni.h>

#include "../jni.h"
#include "../events/NsWidgetEvents.h"
#include "NsGui/BaseButton.h"

extern "C" {
static Noesis::BaseButton *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.BaseButton ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::BaseButton *>(handle);
}


JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseButton_nGetClickMode(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetClickMode();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseButton_nSetClickMode(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetClickMode(static_cast<Noesis::ClickMode>(value));
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseButton_nGetCommand(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetCommand());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseButton_nSetCommand(
    JNIEnv *env, jclass clazz, jlong ptr, jlong command_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetCommand(reinterpret_cast<Noesis::ICommand *>(command_ptr));
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseButton_nSetCommandParameter(
    JNIEnv *env, jclass clazz, jlong ptr, jlong param_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetCommandParameter(reinterpret_cast<Noesis::BaseComponent *>(param_ptr));
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseButton_nSetCommandTarget(
    JNIEnv *env, jclass clazz, jlong ptr, jlong target_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetCommandTarget(reinterpret_cast<Noesis::UIElement *>(target_ptr));
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseButton_nGetIsPressed(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return false;
    return component->GetIsPressed();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseButton_nClick(
    JNIEnv *env, jclass clazz, jlong elementPtr, jobject jListener) {
    if (elementPtr == 0 || jListener == nullptr) {
        return;
    }

    const auto element = reinterpret_cast<Noesis::BaseButton* >(elementPtr);
    if (element == nullptr)
        return;

    auto *data = new NoesisJava::JavaRoutedEventHandler();
    data->handlerGlobal = env->NewGlobalRef(jListener);

    data->handlerMethod = NSJavaUtils::methodFromHandler(env,
        jListener,
        "(Ldev/sixik/noesisgui/nscore/NSBaseComponent;Ldev/sixik/noesisgui/nsgui/NSRoutedEventArgs;)V"
        );

    if (data->handlerMethod == nullptr) {

        env->DeleteGlobalRef(data->handlerGlobal);
        delete data;
        return;
    }

    element->Click() += [data](Noesis::BaseComponent* sender, const Noesis::RoutedEventArgs& args) {
        if (NoesisJava::g_vm == nullptr || data == nullptr)
            return;

        const NoesisJava::JniEnvScope envScope(NoesisJava::g_vm);
        JNIEnv* env = envScope;
        if (!env) return;

        auto& rg = data->args;
        rg.source_ptr        = reinterpret_cast<jlong>(args.source);
        rg.routedEvent_ptr   = reinterpret_cast<jlong>(args.routedEvent);
        rg.handled           = args.handled;

        jobject javaComponent = NSJavaUtils::createBaseObject(env, sender);
        jobject javaArgs      = rg.Create(env);

        env->CallVoidMethod(
            data->handlerGlobal,
            data->handlerMethod,
            javaComponent,
            javaArgs
        );

        if (env->ExceptionCheck()) {
            env->ExceptionDescribe();
            env->ExceptionClear();
        }

        env->DeleteLocalRef(javaComponent);
        env->DeleteLocalRef(javaArgs);
    };
}
}
