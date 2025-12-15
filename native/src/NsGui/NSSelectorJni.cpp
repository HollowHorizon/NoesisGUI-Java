//
// Created by Sixik on 15.12.2025.
//

#include <jni.h>

#include "../jni.h"
#include "../events/NsWidgetEvents.h"
#include "../NsApp/JavaNotifyPropertyChangedBase.h"
#include "NsCore/Nullable.h"
#include "NsGui/Selector.h"

namespace NoesisJava {
    template<typename EventType, typename JavaArgsType, typename EventAdderType, typename ArgsFillerType>
    void RegisterEventHandler(JNIEnv *env, jlong elementPtr, jobject jListener,
                              const char *methodSig,
                              EventAdderType &&eventAdder,
                              ArgsFillerType &&argsFiller) {
        if (elementPtr == 0 || jListener == nullptr) return;

        auto *element = reinterpret_cast<Noesis::Selector *>(elementPtr);
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
static Noesis::Selector *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.Selector ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::Selector *>(handle);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSSelector_nGetIsSelectedStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr) {
    return Noesis::Selector::GetIsSelected(reinterpret_cast<Noesis::Selector *>(element_ptr));
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSSelector_nSetIsSelectedStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr, jboolean value) {
    Noesis::Selector::SetIsSelected(reinterpret_cast<Noesis::Selector *>(element_ptr), value);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSSelector_nGetIsSelectionActiveStatic(
    JNIEnv *env, jclass clazz, jlong element_ptr) {
    return Noesis::Selector::GetIsSelected(reinterpret_cast<Noesis::Selector *>(element_ptr));
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSSelector_nGetIsSynchronizedWithCurrentItem(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetIsSynchronizedWithCurrentItem().GetValueOrDefault();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSSelector_nSetIsSynchronizedWithCurrentItem(
    JNIEnv *env, jclass clazz, jlong ptr, jboolean value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetIsSynchronizedWithCurrentItem(value);
}

JNIEXPORT jint JNICALL
Java_dev_sixik_noesisgui_nsgui_NSSelector_nGetSelectedIndex(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetSelectedIndex();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSSelector_nSetSelectedIndex(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetSelectedIndex(value);
}

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSSelector_nGetSelectedItem(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetSelectedItem());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSSelector_nSetSelectedItem(
    JNIEnv *env, jclass clazz, jlong ptr, jlong element_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetSelectedItem(reinterpret_cast<Noesis::BaseComponent *>(element_ptr));
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSSelector_nGetSelectedValue(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetSelectedValue());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSSelector_nSetSelectedValue(
    JNIEnv *env, jclass clazz, jlong ptr, jlong element_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetSelectedValue(reinterpret_cast<Noesis::BaseComponent *>(element_ptr));
}

JNIEXPORT jstring JNICALL Java_dev_sixik_noesisgui_nsgui_NSSelector_nGetSelectedValuePath(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return env->NewStringUTF("");
    return env->NewStringUTF(component->GetSelectedValuePath());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSSelector_nSetSelectedValuePath(
    JNIEnv *env, jclass clazz, jlong ptr, jstring value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;

    const char *cstr = env->GetStringUTFChars(value, nullptr);
    if (cstr == nullptr) {
        return;
    }

    component->SetSelectedValuePath(cstr);
    env->ReleaseStringUTFChars(value, cstr);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSSelector_nSelectionChanged(
    JNIEnv *env, jclass clazz, jlong ptr, jobject event) {
    using EventType = Noesis::SelectionChangedEventArgs;
    using JavaArgsType = NoesisJava::JavaNSSelectionChangedEventHandler::JavaNSSelectionChangedEventArgs;
    constexpr auto sig = "(Ldev/sixik/noesisgui/nscore/NSBaseComponent;Ldev/sixik/noesisgui/nsgui/NSRoutedEventArgs;)V";

    auto eventAdder = [](Noesis::Selector *el, auto &&lambda) { el->SelectionChanged() += lambda; };
    auto argsFiller = [](JavaArgsType &jArgs, const EventType &nArgs) {
        jArgs.source_ptr = reinterpret_cast<jlong>(nArgs.source);
        jArgs.routedEvent_ptr = reinterpret_cast<jlong>(nArgs.routedEvent);
        jArgs.handled = nArgs.handled;
        jArgs.args = nArgs;
    };

    NoesisJava::RegisterEventHandler<EventType, JavaArgsType>(env, ptr, event, sig, eventAdder, argsFiller);

}
}
