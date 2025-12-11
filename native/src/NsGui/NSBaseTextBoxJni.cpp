//
// Created by Sixik on 11.12.2025.
//

#include <jni.h>

#include "../jni.h"
#include "../events/NsWidgetEvents.h"
#include "NsGui/BaseTextBox.h"
#include "NsGui/ScrollBar.h"

namespace NoesisJava {
    template<typename EventType, typename JavaArgsType, typename EventAdderType, typename ArgsFillerType>
    void RegisterEventHandler(JNIEnv *env, jlong elementPtr, jobject jListener,
                              const char *methodSig,
                              EventAdderType &&eventAdder,
                              ArgsFillerType &&argsFiller) {
        if (elementPtr == 0 || jListener == nullptr) return;

        auto *element = reinterpret_cast<Noesis::BaseTextBox *>(elementPtr);
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
static Noesis::BaseTextBox *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.BaseTextBox ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::BaseTextBox *>(handle);
}


JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetAcceptsReturn(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return false;
    return component->GetAcceptsReturn();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nSetAcceptsReturn(
    JNIEnv *env, jclass clazz, jlong ptr, jboolean value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetAcceptsReturn(value);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetAcceptsTab(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return false;
    return component->GetAcceptsTab();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nSetAcceptsTab(
    JNIEnv *env, jclass clazz, jlong ptr, jboolean value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetAcceptsTab(value);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetCaretBrush(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetCaretBrush());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nSetCaretBrush(
    JNIEnv *env, jclass clazz, jlong ptr, jlong brush_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetCaretBrush(reinterpret_cast<Noesis::Brush *>(brush_ptr));
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetHorizontalScrollBarVisibility(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetHorizontalScrollBarVisibility();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nSetHorizontalScrollBarVisibility(
    JNIEnv *env, jclass clazz, jlong ptr, jint ordinal) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetHorizontalScrollBarVisibility(static_cast<Noesis::ScrollBarVisibility>(ordinal));
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetIsReadOnly(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetIsReadOnly();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nSetIsReadOnly(
    JNIEnv *env, jclass clazz, jlong ptr, jboolean value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetIsReadOnly(value);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetIsSelectionActive(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetIsSelectionActive();
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetPanningMode(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetPanningMode();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nSetPanningMode(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetPanningMode(static_cast<Noesis::PanningMode>(value));
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetSelectionBrush(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return reinterpret_cast<jlong>(component->GetSelectionBrush());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nSetSelectionBrush(
    JNIEnv *env, jclass clazz, jlong ptr, jlong brush_ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetSelectionBrush(reinterpret_cast<Noesis::Brush *>(brush_ptr));
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetSelectionOpacity(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetSelectionOpacity();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nSetSelectionOpacity(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetSelectionOpacity(value);
}

JNIEXPORT jint JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetVerticalScrollBarVisibility(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetVerticalScrollBarVisibility();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nSetVerticalScrollBarVisibility(
    JNIEnv *env, jclass clazz, jlong ptr, jint value) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->SetVerticalScrollBarVisibility(static_cast<Noesis::ScrollBarVisibility>(value));
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetExtentWidth(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetExtentWidth();
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetExtentHeight(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetExtentHeight();
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetViewportWidth(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetViewportWidth();
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetViewportHeight(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetViewportHeight();
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetHorizontalOffset(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetHorizontalOffset();
}

JNIEXPORT jfloat JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nGetVerticalOffset(
    JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return 0;
    return component->GetVerticalOffset();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nLineLeft(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->LineLeft();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nLineRight(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->LineRight();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nPageLeft(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->PageLeft();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nPageRight(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->PageRight();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nLineUp(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->LineUp();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nLineDown(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->LineDown();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nPageUp(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->PageUp();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nPageDown(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->PageDown();
}

JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nScrollToHome(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->ScrollToHome();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nScrollToEnd(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->ScrollToEnd();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nScrollToVerticalOffset(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat offset) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->ScrollToVerticalOffset(offset);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nScrollToHorizontalOffset(
    JNIEnv *env, jclass clazz, jlong ptr, jfloat offset) {
    const auto component = getComponent(env, ptr);
    if (component == nullptr) return;
    component->ScrollToHorizontalOffset(offset);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nSelectionChanged(
    JNIEnv *env, jclass clazz, jlong ptr, jobject event) {
    using EventType = Noesis::RoutedEventArgs;
    using JavaArgsType = NoesisJava::JavaRoutedEventHandler::JavaNSRoutedEventArgs;
    constexpr auto sig = "(Ldev/sixik/noesisgui/nscore/NSBaseComponent;Ldev/sixik/noesisgui/nsgui/NSRoutedEventArgs;)V";

    auto eventAdder = [](Noesis::BaseTextBox *el, auto &&lambda) { el->SelectionChanged() += lambda; };
    auto argsFiller = [](JavaArgsType &jArgs, const EventType &nArgs) {
        jArgs.source_ptr = reinterpret_cast<jlong>(nArgs.source);
        jArgs.routedEvent_ptr = reinterpret_cast<jlong>(nArgs.routedEvent);
        jArgs.handled = nArgs.handled;
    };

    NoesisJava::RegisterEventHandler<EventType, JavaArgsType>(env, ptr, event, sig, eventAdder, argsFiller);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSBaseTextBox_nTextChanged(
    JNIEnv *env, jclass clazz, jlong ptr, jobject event) {
    using EventType = Noesis::RoutedEventArgs;
    using JavaArgsType = NoesisJava::JavaRoutedEventHandler::JavaNSRoutedEventArgs;
    constexpr auto sig = "(Ldev/sixik/noesisgui/nscore/NSBaseComponent;Ldev/sixik/noesisgui/nsgui/NSRoutedEventArgs;)V";

    auto eventAdder = [](Noesis::BaseTextBox *el, auto &&lambda) { el->TextChanged() += lambda; };
    auto argsFiller = [](JavaArgsType &jArgs, const EventType &nArgs) {
        jArgs.source_ptr = reinterpret_cast<jlong>(nArgs.source);
        jArgs.routedEvent_ptr = reinterpret_cast<jlong>(nArgs.routedEvent);
        jArgs.handled = nArgs.handled;
    };

    NoesisJava::RegisterEventHandler<EventType, JavaArgsType>(env, ptr, event, sig, eventAdder, argsFiller);
}
}
