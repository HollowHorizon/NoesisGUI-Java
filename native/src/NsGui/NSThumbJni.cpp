//
// Created by Sixik on 15.12.2025.
//

#include <jni.h>

#include "../jni.h"
#include "../events/NsWidgetEvents.h"
#include "NsGui/Thumb.h"

namespace NoesisJava {
    template<typename EventType, typename JavaArgsType, typename EventAdderType, typename ArgsFillerType>
    void RegisterEventHandler(JNIEnv *env, jlong elementPtr, jobject jListener,
                              const char *methodSig,
                              EventAdderType &&eventAdder,
                              ArgsFillerType &&argsFiller) {
        if (elementPtr == 0 || jListener == nullptr) return;

        auto *element = reinterpret_cast<Noesis::Thumb *>(elementPtr);
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
static Noesis::Thumb *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.Thumb ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::Thumb *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSThumb_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::Thumb());
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSThumb_nGetIsDragging(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return false;
    return component->GetIsDragging();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSThumb_nCancelDrag(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->CancelDrag();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSThumb_nDragCompleted(
    JNIEnv *env, jclass clazz, jlong ptr, jobject event) {
    using EventType = Noesis::DragCompletedEventArgs;
    using JavaArgsType = NoesisJava::JavaNSDragCompletedEventHandler::JavaNSDragCompletedEventArgs;
    constexpr auto sig = "(Ldev/sixik/noesisgui/nscore/NSBaseComponent;Ldev/sixik/noesisgui/nsgui/NSDragCompletedEventArgs;)V";

    auto eventAdder = [](Noesis::Thumb *el, auto &&lambda) { el->DragCompleted() += lambda; };
    auto argsFiller = [](JavaArgsType &jArgs, const EventType &nArgs) {
        jArgs.source_ptr = reinterpret_cast<jlong>(nArgs.source);
        jArgs.routedEvent_ptr = reinterpret_cast<jlong>(nArgs.routedEvent);
        jArgs.handled = nArgs.handled;
        jArgs.canceled = nArgs.canceled;
        jArgs.horizontalChange = nArgs.horizontalChange;
        jArgs.verticalChange = nArgs.verticalChange;
    };

    NoesisJava::RegisterEventHandler<EventType, JavaArgsType>(env, ptr, event, sig, eventAdder, argsFiller);

}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSThumb_nDragDelta(
    JNIEnv *env, jclass clazz, jlong ptr, jobject event) {
    using EventType = Noesis::DragDeltaEventArgs;
    using JavaArgsType = NoesisJava::JavaNSDragDeltaEventHandler::JavaNSDragDeltaEventArgs;
    constexpr auto sig = "(Ldev/sixik/noesisgui/nscore/NSBaseComponent;Ldev/sixik/noesisgui/nsgui/NSDragDeltaEventArgs;)V";

    auto eventAdder = [](Noesis::Thumb *el, auto &&lambda) { el->DragDelta() += lambda; };
    auto argsFiller = [](JavaArgsType &jArgs, const EventType &nArgs) {
        jArgs.source_ptr = reinterpret_cast<jlong>(nArgs.source);
        jArgs.routedEvent_ptr = reinterpret_cast<jlong>(nArgs.routedEvent);
        jArgs.handled = nArgs.handled;
        jArgs.horizontalChange = nArgs.horizontalChange;
        jArgs.verticalChange = nArgs.verticalChange;
    };

    NoesisJava::RegisterEventHandler<EventType, JavaArgsType>(env, ptr, event, sig, eventAdder, argsFiller);

}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSThumb_nDragStarted(
    JNIEnv *env, jclass clazz, jlong ptr, jobject event) {
    using EventType = Noesis::DragStartedEventArgs;
    using JavaArgsType = NoesisJava::JavaNSDragStartedEventHandler::JavaNSDragStartedEventArgs;
    constexpr auto sig = "(Ldev/sixik/noesisgui/nscore/NSBaseComponent;Ldev/sixik/noesisgui/nsgui/NSDragStartedEventArgs;)V";

    auto eventAdder = [](Noesis::Thumb *el, auto &&lambda) { el->DragStarted() += lambda; };
    auto argsFiller = [](JavaArgsType &jArgs, const EventType &nArgs) {
        jArgs.source_ptr = reinterpret_cast<jlong>(nArgs.source);
        jArgs.routedEvent_ptr = reinterpret_cast<jlong>(nArgs.routedEvent);
        jArgs.handled = nArgs.handled;
        jArgs.horizontalChange = nArgs.horizontalOffset;
        jArgs.verticalChange = nArgs.verticalOffset;
    };

    NoesisJava::RegisterEventHandler<EventType, JavaArgsType>(env, ptr, event, sig, eventAdder, argsFiller);


}
}
