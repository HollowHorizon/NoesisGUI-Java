//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "../jni.h"
#include "../events/NsWidgetEvents.h"
#include "NsGui/Hyperlink.h"

namespace NoesisJava {
    template<typename EventType, typename JavaArgsType, typename EventAdderType, typename ArgsFillerType>
    void RegisterEventHandler(JNIEnv *env, jlong elementPtr, jobject jListener,
                              const char *methodSig,
                              EventAdderType &&eventAdder,
                              ArgsFillerType &&argsFiller) {
        if (elementPtr == 0 || jListener == nullptr) return;

        auto *element = reinterpret_cast<Noesis::Hyperlink *>(elementPtr);
        if (element == nullptr) return;

        auto *data = new GenericEventHandler<JavaArgsType>();
        data->handlerGlobal = env->NewGlobalRef(jListener);
        data->handlerMethod = NSJavaUtils::methodFromHandler(env, jListener, methodSig);

        if (data->handlerMethod == nullptr) {
            env->DeleteGlobalRef(data->handlerGlobal);
            delete data;
            return;
        }

        eventAdder(element, [data, argsFiller](Noesis::BaseComponent *sender, const EventType &noesisArgs) {
            if (g_vm == nullptr || data == nullptr) return;

            JniEnvScope envScope(g_vm);
            JNIEnv *jniEnv = envScope;
            if (!jniEnv) return;

            argsFiller(data->args, noesisArgs);

            jobject javaSender = NSJavaUtils::createBaseObject(jniEnv, sender);
            jobject javaArgs = data->args.Create(jniEnv);

            jniEnv->CallVoidMethod(data->handlerGlobal, data->handlerMethod, javaSender, javaArgs);

            if (jniEnv->ExceptionCheck()) {
                jniEnv->ExceptionDescribe();
                jniEnv->ExceptionClear();
            }

            jniEnv->DeleteLocalRef(javaSender);
            jniEnv->DeleteLocalRef(javaArgs);
        });
    }
}

extern "C" {
static Noesis::Hyperlink *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.Hyperlink ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::Hyperlink *>(handle);
}


JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSHyperlink_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::Hyperlink());
}

JNIEXPORT jstring JNICALL Java_dev_sixik_noesisgui_nsgui_NSHyperlink_nGetNavigateUri(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr)  return env->NewStringUTF("");
    return env->NewStringUTF(component->GetNavigateUri());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSHyperlink_nSetNavigateUri(
    JNIEnv *env, jclass clazz, jlong ptr, jstring value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;

    const char *cstr = env->GetStringUTFChars(value, nullptr);
    if (cstr == nullptr) {
        return;
    }

    component->SetNavigateUri(cstr);
    env->ReleaseStringUTFChars(value, cstr);
}

JNIEXPORT jstring JNICALL Java_dev_sixik_noesisgui_nsgui_NSHyperlink_nGetTargetName(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr)  return env->NewStringUTF("");
    return env->NewStringUTF(component->GetTargetName());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSHyperlink_nSetTargetName(
    JNIEnv *env, jclass clazz, jlong ptr, jstring value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;

    const char *cstr = env->GetStringUTFChars(value, nullptr);
    if (cstr == nullptr) {
        return;
    }

    component->SetTargetName(cstr);
    env->ReleaseStringUTFChars(value, cstr);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSHyperlink_nClick(
    JNIEnv *env, jclass clazz, jlong ptr, jobject event) {
    using EventType = Noesis::RoutedEventArgs;
    using JavaArgsType = NoesisJava::JavaRoutedEventHandler::JavaNSRoutedEventArgs;
    constexpr auto sig = "(Ldev/sixik/noesisgui/nscore/NSBaseComponent;Ldev/sixik/noesisgui/nsgui/NSRoutedEventArgs;)V";

    auto eventAdder = [](Noesis::Hyperlink *el, auto &&lambda) { el->Click() += lambda; };
    auto argsFiller = [](JavaArgsType &jArgs, const EventType &nArgs) {
        jArgs.source_ptr = reinterpret_cast<jlong>(nArgs.source);
        jArgs.routedEvent_ptr = reinterpret_cast<jlong>(nArgs.routedEvent);
        jArgs.handled = nArgs.handled;
    };

    NoesisJava::RegisterEventHandler<EventType, JavaArgsType>(env, ptr, event, sig, eventAdder, argsFiller);

}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSHyperlink_nRequestNavigate(
    JNIEnv *env, jclass clazz, jlong ptr, jobject event) {
    using EventType = Noesis::RequestNavigateEventArgs;
    using JavaArgsType = NoesisJava::JavaNSRequestNavigateEventHandler::JavaNSRequestNavigateEventArgs;
    constexpr auto sig = "(Ldev/sixik/noesisgui/nscore/NSBaseComponent;Ldev/sixik/noesisgui/nsgui/NSRequestNavigateEventArgs;)V";

    auto eventAdder = [](Noesis::Hyperlink *el, auto &&lambda) { el->RequestNavigate() += lambda; };
    auto argsFiller = [](JavaArgsType &jArgs, const EventType &nArgs) {
        jArgs.source_ptr = reinterpret_cast<jlong>(nArgs.source);
        jArgs.routedEvent_ptr = reinterpret_cast<jlong>(nArgs.routedEvent);
        jArgs.handled = nArgs.handled;
        jArgs.uri = nArgs.uri;
        jArgs.target = nArgs.target;
    };

    NoesisJava::RegisterEventHandler<EventType, JavaArgsType>(env, ptr, event, sig, eventAdder, argsFiller);
}
}
