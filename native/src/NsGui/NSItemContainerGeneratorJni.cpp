//
// Created by Sixik on 10.12.2025.
//

#include <jni.h>

#include "../jni.h"
#include "../events/NsWidgetEvents.h"
#include "NsGui/ItemContainerGenerator.h"

struct JniEnvScope {
    JNIEnv* env = nullptr;
    bool attached = false;

    JniEnvScope(JavaVM* vm) {
        const jint res = vm->GetEnv((void**)&env, JNI_VERSION_1_8);
        if (res == JNI_EDETACHED) {
            if (vm->AttachCurrentThread((void**)&env, nullptr) == 0) {
                attached = true;
            }
        }
    }

    ~JniEnvScope() {
        if (attached) NoesisJava::g_vm->DetachCurrentThread();
    }

    operator JNIEnv*() const { return env; }
};

namespace NoesisJava {
    template<typename EventType, typename JavaArgsType, typename EventAdderType, typename ArgsFillerType>
    void RegisterEventHandler(JNIEnv *env, jlong elementPtr, jobject jListener,
                              const char *methodSig,
                              EventAdderType &&eventAdder,
                              ArgsFillerType &&argsFiller) {
        if (elementPtr == 0 || jListener == nullptr) return;

        auto *element = reinterpret_cast<Noesis::ItemContainerGenerator *>(elementPtr);
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

            if (javaArgs != nullptr)
                jniEnv->CallVoidMethod(data->handlerGlobal, data->handlerMethod, javaSender, javaArgs);
            else
                jniEnv->CallVoidMethod(data->handlerGlobal, data->handlerMethod, javaSender);

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

    static Noesis::ItemContainerGenerator *getComponent(JNIEnv *env, const jlong handle) {
        if (handle == 0) {
            jclass excCls = env->FindClass("java/lang/IllegalStateException");
            if (excCls != nullptr) {
                env->ThrowNew(excCls, "Noesis.ItemContainerGenerator ptr is null");
            }
            return nullptr;
        }
        return reinterpret_cast<Noesis::ItemContainerGenerator *>(handle);
    }

    JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSItemContainerGenerator_nGetStatus(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return 0;
        return component->GetStatus();
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSItemContainerGenerator_nContainerFromIndex(JNIEnv* env, jclass clazz, jlong ptr, jint index) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return 0;
        return reinterpret_cast<jlong>(component->ContainerFromIndex(index));
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSItemContainerGenerator_nContainerFromItem(JNIEnv* env, jclass clazz, jlong ptr, jlong component_ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return 0;
        return reinterpret_cast<jlong>(component->ContainerFromItem(reinterpret_cast<Noesis::BaseComponent *>(component_ptr)));
    }

    JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSItemContainerGenerator_nIndexFromContainer(JNIEnv* env, jclass clazz, jlong ptr, jlong container_ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return 0;
        return component->IndexFromContainer(reinterpret_cast<Noesis::DependencyObject *>(container_ptr));
    }

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSItemContainerGenerator_nItemFromContainer(JNIEnv* env, jclass clazz, jlong ptr, jlong container_ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return 0;
        return reinterpret_cast<jlong>(component->ItemFromContainer(reinterpret_cast<Noesis::DependencyObject *>(container_ptr)));
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSItemContainerGenerator_nStartBatch(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->StartBatch();
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSItemContainerGenerator_nStopBatch(JNIEnv* env, jclass clazz, jlong ptr) {
        const auto component = getComponent(env, ptr);
        if (component == nullptr) return;
        component->StopBatch();
    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSItemContainerGenerator_nStatusChanged(JNIEnv* env, jclass clazz, jlong ptr, jobject event) {
        using EventType = Noesis::EventArgs;
        using JavaArgsType = NoesisJava::JavaNSEventHandler::JavaNSEventHandlerArgs;
        constexpr auto sig = "(Ldev/sixik/noesisgui/nscore/NSBaseComponent;)V";

        auto eventAdder = [](Noesis::ItemContainerGenerator *el, auto &&lambda) { el->StatusChanged() += lambda; };
        auto argsFiller = [](JavaArgsType &jArgs, const EventType &nArgs) { };

        NoesisJava::RegisterEventHandler<EventType, JavaArgsType>(env, ptr, event, sig, eventAdder, argsFiller);

    }

    JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSItemContainerGenerator_nItemsChanged(JNIEnv* env, jclass clazz, jlong ptr, jobject event) {
        using EventType = Noesis::ItemsChangedEventArgs;
        using JavaArgsType = NoesisJava::JavaNSItemsChangedEventHandler::JavaNSItemsChangedEventArgs;
        constexpr auto sig = "(Ldev/sixik/noesisgui/nscore/NSBaseComponent;Ldev/sixik/noesisgui/nsgui/NSItemsChangedEventArgs;)V";

        auto eventAdder = [](Noesis::ItemContainerGenerator *el, auto &&lambda) { el->ItemsChanged() += lambda; };
        auto argsFiller = [](JavaArgsType &jArgs, const EventType &nArgs) {
            jArgs.args = nArgs;
        };

        NoesisJava::RegisterEventHandler<EventType, JavaArgsType>(env, ptr, event, sig, eventAdder, argsFiller);
    }
}
