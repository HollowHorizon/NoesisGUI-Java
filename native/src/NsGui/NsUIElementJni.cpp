//
// Created by Sixik on 04.12.2025.
//

#include <jni.h>
#include <jni_md.h>

#include "../utils/NSJniUtils.h"
#include "NsGui/Transform.h"
#include "NsGui/UIElement.h"
#include "NsGui/Transform.h"

namespace Noesis {
    class FrameworkElement;
}

extern "C" {

static Noesis::UIElement *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.UIElement ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::UIElement *>(handle);
}

// boolean nativeGetAllowDrop(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetAllowDrop(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return false;
    return obj->GetAllowDrop();
}

// void nativeSetAllowDrop(long ptr, boolean value);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetAllowDrop(
        JNIEnv* env, jclass, jlong ptr, jboolean value) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetAllowDrop(value);
}

// long nativeGetClip(long ptr);
JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetClip(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return 0;
    return reinterpret_cast<jlong>(obj->GetClip());
}

// void nativeSetClip(long ptr, long geometryPtr);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetClip(
        JNIEnv* env, jclass, jlong ptr, jlong geometryPtr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetClip(reinterpret_cast<Noesis::Geometry *>(geometryPtr));
}

// boolean nativeGetClipToBounds(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetClipToBounds(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetClipToBounds();
}

// void nativeSetClipToBounds(long ptr, boolean value);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetClipToBounds(
        JNIEnv* env, jclass, jlong ptr, jboolean value) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetClipToBounds(value);
}

// long nativeGetEffect(long ptr);
JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetEffect(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return 0;
    return reinterpret_cast<jlong>(obj->GetEffect());
}

// void nativeSetEffect(long ptr, long effectPtr);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetEffect(
        JNIEnv* env, jclass, jlong ptr, jlong effectPtr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetEffect(reinterpret_cast<Noesis::Effect *>(effectPtr));
}

// boolean nativeGetFocusable(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetFocusable(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetFocusable();
}

// void nativeSetFocusable(long ptr, boolean value);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetFocusable(
        JNIEnv* env, jclass, jlong ptr, jboolean value) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetFocusable(value);
}

// boolean nativeGetIsEnabled(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetIsEnabled(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetIsEnabled();
}

// void nativeSetIsEnabled(long ptr, boolean value);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetIsEnabled(
        JNIEnv* env, jclass, jlong ptr, jboolean value) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetIsEnabled(value);
}

// boolean nativeGetIsFocused(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetIsFocused(
        JNIEnv* env, jclass, jlong ptr) {
    (void)env; (void)ptr;
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetIsFocused();
}

// boolean nativeGetIsHitTestVisible(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetIsHitTestVisible(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetIsHitTestVisible();
}

// void nativeSetIsHitTestVisible(long ptr, boolean value);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetIsHitTestVisible(
        JNIEnv* env, jclass, jlong ptr, jboolean value) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetIsHitTestVisible(value);
}

// boolean nativeGetIsKeyboardFocused(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetIsKeyboardFocused(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetIsKeyboardFocused();
}

// boolean nativeGetIsKeyboardFocusWithin(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetIsKeyboardFocusWithin(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetIsKeyboardFocusWithin();
}

// boolean nativeGetIsMouseCaptured(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetIsMouseCaptured(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetIsMouseCaptured();
}

// boolean nativeGetIsMouseCaptureWithin(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetIsMouseCaptureWithin(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetIsMouseCaptureWithin();
}

// boolean nativeGetIsMouseDirectlyOver(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetIsMouseDirectlyOver(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetIsMouseDirectlyOver();
}

// boolean nativeGetIsMouseOver(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetIsMouseOver(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetIsMouseOver();
}

// boolean nativeGetIsVisible(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetIsVisible(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetIsVisible();
}

// long nativeGetOpacityMask(long ptr);
JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetOpacityMask(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return 0;
    return reinterpret_cast<jlong>(obj->GetOpacityMask());
}

// void nativeSetOpacityMask(long ptr, long brushPtr);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetOpacityMask(
        JNIEnv* env, jclass, jlong ptr, jlong brushPtr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetOpacityMask(reinterpret_cast<Noesis::Brush *>(brushPtr));
}

// float nativeGetOpacity(long ptr);
JNIEXPORT jfloat JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetOpacity(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return 0;
    return obj->GetOpacity();
}

// void nativeSetOpacity(long ptr, float value);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetOpacity(
        JNIEnv* env, jclass, jlong ptr, jfloat value) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetOpacity(value);
}

// void nativeGetRenderTransformOrigin(long ptr, NSPoint point);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetRenderTransformOrigin(
        JNIEnv* env, jclass, jlong ptr, jobject point) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    NSJniUtils::PointFromCopy(env, obj->GetRenderTransformOrigin(), point);
}

// void nativeSetRenderTransformOrigin(long ptr, NSPoint point);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetRenderTransformOrigin(
        JNIEnv* env, jclass, jlong ptr, jobject point) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;

    Noesis::Point _point = Noesis::Point();
    NSJniUtils::PointToCopy(env, _point, point);
    obj->SetRenderTransformOrigin(_point);
}

// long nativeGetRenderTransform(long ptr);
JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetRenderTransform(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return 0;
    return reinterpret_cast<jlong>(obj->GetRenderTransform());
}

// void nativeSetRenderTransform(long ptr, long transformPtr);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetRenderTransform(
        JNIEnv* env, jclass, jlong ptr, jlong transformPtr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetRenderTransform(reinterpret_cast<Noesis::Transform *>(transformPtr));
}

// long nativeGetTransform3D(long ptr);
JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetTransform3D(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return 0;
    return reinterpret_cast<jlong>(obj->GetTransform3D());
}

// void nativeSetTransform3D(long ptr, long transformPtr);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetTransform3D(
        JNIEnv* env, jclass, jlong ptr, jlong transformPtr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetTransform3D(reinterpret_cast<Noesis::Transform3D *>(transformPtr));
}

// int nativeGetVisibility(long ptr);
JNIEXPORT jint JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetVisibility(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return 0;
    return obj->GetVisibility();
}

// void nativeSetVisibility(long ptr, int value);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetVisibility(
        JNIEnv* env, jclass, jlong ptr, jint value) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetVisibility(static_cast<Noesis::Visibility>(value));
}

// long nativeGetUIView(long ptr);
JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetUIView(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return 0;
    return reinterpret_cast<jlong>(obj->GetUIView());
}

// long nativeGetUIParent(long ptr);
JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetUIParent(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return 0;
    return reinterpret_cast<jlong>(obj->GetUIParent());
}

// long nativeGetCommandBindings(long ptr);
JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetCommandBindings(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return 0;
    return reinterpret_cast<jlong>(obj->GetCommandBindings());
}

// long nativeGetInputBindings(long ptr);
JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetInputBindings(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return 0;
    return reinterpret_cast<jlong>(obj->GetInputBindings());
}

// long nativeGetMouse(long ptr);
JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetMouse(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return 0;
    return reinterpret_cast<jlong>(obj->GetMouse());
}

// boolean nativeCaptureMouse(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeCaptureMouse(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->CaptureMouse();
}

// void nativeReleaseMouseCapture(long ptr);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeReleaseMouseCapture(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->ReleaseMouseCapture();
}

// void nativeTranslatePoint(long ptr, NSPoint input, NSPoint out, NSUIElement element);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeTranslatePoint(
        JNIEnv* env, jclass, jlong ptr, jobject input, jobject outPoint, jlong element) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;

    auto in_point = Noesis::Point();
    NSJniUtils::PointToCopy(env, in_point, input);
    const auto out_point = obj->TranslatePoint(in_point, reinterpret_cast<Noesis::UIElement *>(element));
    NSJniUtils::PointFromCopy(env, out_point, outPoint);
}

// boolean nativeGetIsTapEnabled(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetIsTapEnabled(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetIsTapEnabled();
}

// void nativeSetIsTapEnabled(long ptr, boolean value);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetIsTapEnabled(
        JNIEnv* env, jclass, jlong ptr, jboolean value) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetIsTapEnabled(value);
}

// boolean nativeGetIsManipulationEnabled(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetIsManipulationEnabled(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetIsManipulationEnabled();
}

// void nativeSetIsManipulationEnabled(long ptr, boolean value);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetIsManipulationEnabled(
        JNIEnv* env, jclass, jlong ptr, jboolean value) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetIsManipulationEnabled(value);
}

// boolean nativeGetIsDoubleTapEnabled(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetIsDoubleTapEnabled(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetIsDoubleTapEnabled();
}

// void nativeSetIsDoubleTapEnabled(long ptr, boolean value);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetIsDoubleTapEnabled(
        JNIEnv* env, jclass, jlong ptr, jboolean value) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetIsDoubleTapEnabled(value);
}

// boolean nativeGetIsHoldingEnabled(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetIsHoldingEnabled(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetIsHoldingEnabled();
}

// void nativeSetIsHoldingEnabled(long ptr, boolean value);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetIsHoldingEnabled(
        JNIEnv* env, jclass, jlong ptr, jboolean value) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetIsHoldingEnabled(value);
}

// boolean nativeGetIsRightTapEnabled(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetIsRightTapEnabled(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->GetIsRightTapEnabled();
}

// void nativeSetIsRightTapEnabled(long ptr, boolean value);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeSetIsRightTapEnabled(
        JNIEnv* env, jclass, jlong ptr, jboolean value) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->SetIsRightTapEnabled(value);
}

// boolean nativeCaptureTouch(long ptr, long touchDevice);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeCaptureTouch(
        JNIEnv* env, jclass, jlong ptr, jlong touchDevice) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->CaptureTouch(touchDevice);
}

// boolean nativeReleaseTouchCapture(long ptr, long touchDevice);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeReleaseTouchCapture(
        JNIEnv* env, jclass, jlong ptr, jlong touchDevice) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->ReleaseTouchCapture(touchDevice);
}

// void nativeReleaseAllTouchCaptures(long ptr);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeReleaseAllTouchCaptures(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->ReleaseAllTouchCaptures();
}

// long nativeGetTouchCaptured(long ptr, long touchDevice);
JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetTouchCaptured(
        JNIEnv* env, jclass, jlong ptr, jlong touchDevice) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return 0;
    return reinterpret_cast<jlong>(obj->GetTouchCaptured(touchDevice));
}

// long nativeGetKeyboard(long ptr);
JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetKeyboard(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return 0;
    return reinterpret_cast<jlong>(obj->GetKeyboard());
}

// boolean nativeFocus(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeFocus(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->Focus();
}

// boolean nativeFocusEnguage(long ptr, boolean engage);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeFocusEnguage(
        JNIEnv* env, jclass, jlong ptr, jboolean engage) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->Focus(engage);
}

// void nativeGetDesiredSize(long ptr, NSSize size);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetDesiredSize(
        JNIEnv* env, jclass, jlong ptr, jobject size) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    NSJniUtils::SizeFromCopy(env, obj->GetDesiredSize(), size);
}

// void nativeGetRenderSize(long ptr, NSSize size);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetRenderSize(
        JNIEnv* env, jclass, jlong ptr, jobject size) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    NSJniUtils::SizeFromCopy(env, obj->GetRenderSize(), size);
}

// void nativeInvalidateMeasure(long ptr);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeInvalidateMeasure(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->InvalidateMeasure();
}

// boolean nativeIsMeasureValid(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeIsMeasureValid(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->IsMeasureValid();
}

// void nativeMeasure(long ptr, NSSize availableSize);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeMeasure(
        JNIEnv* env, jclass, jlong ptr, jobject availableSize) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    Noesis::Size size = Noesis::Size();
    NSJniUtils::SizeToCopy(env, size, availableSize);
    obj->Measure(size);
}

// void nativeInvalidateArrange(long ptr);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeInvalidateArrange(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->InvalidateArrange();
}

// boolean nativeIsArrangeValid(long ptr);
JNIEXPORT jboolean JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeIsArrangeValid(
        JNIEnv* env, jclass, jlong ptr) {
    (void)env; (void)ptr;
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return JNI_FALSE;
    return obj->IsArrangeValid();
}

// void nativeArrange(long ptr, NSRect rect);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeArrange(
        JNIEnv* env, jclass, jlong ptr, jobject rect) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    Noesis::Rect _rect = Noesis::Rect();
    NSJniUtils::RectToCopy(env, _rect, rect);
    obj->Arrange(_rect);
}

// void nativeInvalidateVisual(long ptr);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeInvalidateVisual(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->InvalidateVisual();
}

// void nativeUpdateLayout(long ptr);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeUpdateLayout(
        JNIEnv* env, jclass, jlong ptr) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    obj->UpdateLayout();
}

// // boolean nativeMoveFocus(long ptr, NSTraversalRequest request);
// JNIEXPORT jboolean JNICALL
// Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeMoveFocus(
//         JNIEnv* env, jclass, jlong ptr, jobject request) {
//     const auto obj = getComponent(env, ptr);
//     if (obj == nullptr) return JNI_FALSE;
//     Noesis::TraversalRequest _request = Noesis::TraversalRequest();
//     NSJniUtils::
// }
//
// // long nativePredictFocus(long ptr, int direction);
// JNIEXPORT jlong JNICALL
// Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativePredictFocus(
//         JNIEnv* env, jclass, jlong ptr, jint direction) {
//     (void)env; (void)ptr; (void)direction;
//     return 0;
// }

// void nativeGetMeasureConstraint(long ptr, NSSize size);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetMeasureConstraint(
        JNIEnv* env, jclass, jlong ptr, jobject size) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    NSJniUtils::SizeFromCopy(env, obj->GetMeasureConstraint(), size);
}

// void nativeGetArrangeConstraint(long ptr, NSRect rect);
JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSUIElement_nativeGetArrangeConstraint(
        JNIEnv* env, jclass, jlong ptr, jobject rect) {
    const auto obj = getComponent(env, ptr);
    if (obj == nullptr) return;
    NSJniUtils::RectFromCopy(env, obj->GetArrangeConstraint(), rect);
}
}
