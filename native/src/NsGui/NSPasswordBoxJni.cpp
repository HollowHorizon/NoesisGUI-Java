//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "../jni.h"
#include "../events/NsWidgetEvents.h"
#include "NsGui/PasswordBox.h"

namespace NoesisJava {
    template<typename EventType, typename JavaArgsType, typename EventAdderType, typename ArgsFillerType>
    void RegisterEventHandler(JNIEnv *env, jlong elementPtr, jobject jListener,
                              const char *methodSig,
                              EventAdderType &&eventAdder,
                              ArgsFillerType &&argsFiller) {
        if (elementPtr == 0 || jListener == nullptr) return;

        auto *element = reinterpret_cast<Noesis::PasswordBox *>(elementPtr);
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

static Noesis::PasswordBox *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.PasswordBox ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::PasswordBox *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nCreate(JNIEnv *env, jclass clazz) {
    return reinterpret_cast<jlong>(new Noesis::PasswordBox());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nSelectAll(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SelectAll();
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nGetCaretBrush(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetCaretBrush());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nSetCaretBrush(
    JNIEnv *env, jclass clazz, jlong ptr, jlong brush_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetCaretBrush(reinterpret_cast<Noesis::Brush *>(brush_ptr));
}

JNIEXPORT jint JNICALL
Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nGetMaxLength(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetMaxLength();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nSetMaxLength(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetMaxLength(value);
}

JNIEXPORT jchar JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nGetPasswordChar(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return ' ';
    return component->GetPasswordChar();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nSetPasswordChar(
    JNIEnv *env, jclass clazz, jlong ptr, jchar c) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetPasswordChar(c);
}

JNIEXPORT jstring JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nGetPassword(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return env->NewStringUTF("");
    return env->NewStringUTF(component->GetPassword());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nSetPassword(
    JNIEnv *env, jclass clazz, jlong ptr, jstring value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    const char *cstr = env->GetStringUTFChars(value, nullptr);
    if (cstr == nullptr) {
        return;
    }

    component->SetPassword(cstr);
    env->ReleaseStringUTFChars(value, cstr);
}

JNIEXPORT jstring JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nGetPlaceholder(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return env->NewStringUTF("");
    return env->NewStringUTF(component->GetPlaceholder());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nSetPlaceholder(
    JNIEnv *env, jclass clazz, jlong ptr, jstring value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    const char *cstr = env->GetStringUTFChars(value, nullptr);
    if (cstr == nullptr) {
        return;
    }

    component->SetPlaceholder(cstr);
    env->ReleaseStringUTFChars(value, cstr);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nGetSelectionBrush(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetSelectionBrush());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nSetSelectionBrush(
    JNIEnv *env, jclass clazz, jlong ptr, jlong brush_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetSelectionBrush(reinterpret_cast<Noesis::Brush *>(brush_ptr));
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nGetSelectionOpacity(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetSelectionOpacity();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nSetSelectionOpacity(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetSelectionOpacity(value);
}

JNIEXPORT jchar JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nGetShowLastCharacterDuration(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return ' ';
    return component->GetShowLastCharacterDuration();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nSetShowLastCharacterDuration(
    JNIEnv *env, jclass clazz, jlong ptr, jchar c) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetShowLastCharacterDuration(c);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nHideCaret(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->HideCaret();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSPasswordBox_nPasswordChanged(
    JNIEnv *env, jclass clazz, jlong ptr, jobject event) {
    using EventType = Noesis::RoutedEventArgs;
    using JavaArgsType = NoesisJava::JavaRoutedEventHandler::JavaNSRoutedEventArgs;
    constexpr auto sig = "(Ldev/sixik/noesisgui/nscore/NSBaseComponent;Ldev/sixik/noesisgui/nsgui/NSRoutedEventArgs;)V";

    auto eventAdder = [](Noesis::PasswordBox *el, auto &&lambda) { el->PasswordChanged() += lambda; };
    auto argsFiller = [](JavaArgsType &jArgs, const EventType &nArgs) {
        jArgs.source_ptr = reinterpret_cast<jlong>(nArgs.source);
        jArgs.routedEvent_ptr = reinterpret_cast<jlong>(nArgs.routedEvent);
        jArgs.handled = nArgs.handled;
    };

    NoesisJava::RegisterEventHandler<EventType, JavaArgsType>(env, ptr, event, sig, eventAdder, argsFiller);
}
}
