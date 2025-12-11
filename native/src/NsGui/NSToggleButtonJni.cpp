//
// Created by Sixik on 11.12.2025.
//

#include <jni.h>

#include "../jni.h"
#include "../events/NsWidgetEvents.h"
#include "NsCore/Nullable.h"
#include "NsGui/ToggleButton.h"

namespace NoesisJava {
    template<typename EventType, typename JavaArgsType, typename EventAdderType, typename ArgsFillerType>
    void RegisterEventHandler(JNIEnv *env, jlong elementPtr, jobject jListener,
                              const char *methodSig,
                              EventAdderType &&eventAdder,
                              ArgsFillerType &&argsFiller) {
        if (elementPtr == 0 || jListener == nullptr) return;

        auto *element = reinterpret_cast<Noesis::ToggleButton *>(elementPtr);
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

    static Noesis::ToggleButton *getComponent(JNIEnv *env, const jlong handle) {
        if (handle == 0) {
            jclass excCls = env->FindClass("java/lang/IllegalStateException");
            if (excCls != nullptr) {
                env->ThrowNew(excCls, "Noesis.ToggleButton ptr is null");
            }
            return nullptr;
        }
        return reinterpret_cast<Noesis::ToggleButton *>(handle);
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSToggleButton_nCreate(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(new Noesis::ToggleButton());
    }

    JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSToggleButton_nGetIsChecked(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return false;
        return component->GetIsChecked().GetValueOrDefault();
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSToggleButton_nSetIsChecked(JNIEnv* env, jclass clazz, jlong ptr, jboolean value) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->SetIsChecked(value);
    }

    JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSToggleButton_nGetIsThreeState(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return false;
        return component->GetIsThreeState();
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSToggleButton_nSetIsThreeState(JNIEnv* env, jclass clazz, jlong ptr, jboolean value) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->SetIsThreeState(value);
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSToggleButton_nChecked(JNIEnv* env, jclass clazz, jlong ptr, jobject event) {
        using EventType = Noesis::RoutedEventArgs;
        using JavaArgsType = NoesisJava::JavaRoutedEventHandler::JavaNSRoutedEventArgs;
        constexpr auto sig = "(Ldev/sixik/noesisgui/nscore/NSBaseComponent;Ldev/sixik/noesisgui/nsgui/NSRoutedEventArgs;)V";

        auto eventAdder = [](Noesis::ToggleButton *el, auto &&lambda) { el->Checked() += lambda; };
        auto argsFiller = [](JavaArgsType &jArgs, const EventType &nArgs) {
            jArgs.source_ptr = reinterpret_cast<jlong>(nArgs.source);
            jArgs.routedEvent_ptr = reinterpret_cast<jlong>(nArgs.routedEvent);
            jArgs.handled = nArgs.handled;
        };

        NoesisJava::RegisterEventHandler<EventType, JavaArgsType>(env, ptr, event, sig, eventAdder, argsFiller);

    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSToggleButton_nIndeterminate(JNIEnv* env, jclass clazz, jlong ptr, jobject event) {
        using EventType = Noesis::RoutedEventArgs;
        using JavaArgsType = NoesisJava::JavaRoutedEventHandler::JavaNSRoutedEventArgs;
        constexpr auto sig = "(Ldev/sixik/noesisgui/nscore/NSBaseComponent;Ldev/sixik/noesisgui/nsgui/NSRoutedEventArgs;)V";

        auto eventAdder = [](Noesis::ToggleButton *el, auto &&lambda) { el->Indeterminate() += lambda; };
        auto argsFiller = [](JavaArgsType &jArgs, const EventType &nArgs) {
            jArgs.source_ptr = reinterpret_cast<jlong>(nArgs.source);
            jArgs.routedEvent_ptr = reinterpret_cast<jlong>(nArgs.routedEvent);
            jArgs.handled = nArgs.handled;
        };

        NoesisJava::RegisterEventHandler<EventType, JavaArgsType>(env, ptr, event, sig, eventAdder, argsFiller);

    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSToggleButton_nUnchecked(JNIEnv* env, jclass clazz, jlong ptr, jobject event) {
        using EventType = Noesis::RoutedEventArgs;
        using JavaArgsType = NoesisJava::JavaRoutedEventHandler::JavaNSRoutedEventArgs;
        constexpr auto sig = "(Ldev/sixik/noesisgui/nscore/NSBaseComponent;Ldev/sixik/noesisgui/nsgui/NSRoutedEventArgs;)V";

        auto eventAdder = [](Noesis::ToggleButton *el, auto &&lambda) { el->Unchecked() += lambda; };
        auto argsFiller = [](JavaArgsType &jArgs, const EventType &nArgs) {
            jArgs.source_ptr = reinterpret_cast<jlong>(nArgs.source);
            jArgs.routedEvent_ptr = reinterpret_cast<jlong>(nArgs.routedEvent);
            jArgs.handled = nArgs.handled;
        };

        NoesisJava::RegisterEventHandler<EventType, JavaArgsType>(env, ptr, event, sig, eventAdder, argsFiller);

    }
}
