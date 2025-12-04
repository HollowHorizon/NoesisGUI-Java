//
// Created by Sixik on 04.12.2025.
//

#include <jni.h>
#include <jni_md.h>

#include "../utils/NSJniUtils.h"
#include "NsGui/InputEnums.h"
#include "NsGui/IView.h"
#include "NsGui/Mouse.h"

namespace Noesis {
    struct IRenderer;
}

extern "C" {
static Noesis::IView *getComponent(JNIEnv *env, const jlong handle) {
    if (handle == 0) {
        jclass excCls = env->FindClass("java/lang/IllegalStateException");
        if (excCls != nullptr) {
            env->ThrowNew(excCls, "Noesis.IView ptr is null");
        }
        return nullptr;
    }
    return reinterpret_cast<Noesis::IView *>(handle);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeGetRenderer
(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return reinterpret_cast<jlong>(view->GetRenderer());
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeGetContent
(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return reinterpret_cast<jlong>(view->GetContent());
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeSetScale
(JNIEnv *env, jclass clazz, jlong ptr, jfloat scale) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    view->SetScale(scale);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeSetSize
(JNIEnv *env, jclass clazz, jlong ptr, jlong w, jlong h) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    view->SetSize(w, h);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeSetTessellationMaxPixelError
(JNIEnv *env, jclass clazz, jlong ptr, jobject error) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    auto _error = Noesis::TessellationMaxPixelError(0);
    NSJniUtils::TessellationMaxPixelErrorToCopy(env, _error, error);
    view->SetTessellationMaxPixelError(_error);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeGetTessellationMaxPixelError
(JNIEnv *env, jclass clazz, jlong ptr, jobject error) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    NSJniUtils::TessellationMaxPixelErrorFromCopy(env, view->GetTessellationMaxPixelError(), error);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeSetFlags
(JNIEnv *env, jclass clazz, jlong ptr, jint flags) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    view->SetFlags(flags);
}

JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeGetFlags
(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->GetFlags();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeSetHoldingTimeThreshold
(JNIEnv *env, jclass clazz, jlong ptr, jlong milliseconds) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    view->SetHoldingTimeThreshold(milliseconds);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeSetHoldingDistanceThreshold
(JNIEnv *env, jclass clazz, jlong ptr, jlong pixels) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    view->SetHoldingDistanceThreshold(pixels);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeSetManipulationDistanceThreshold
(JNIEnv *env, jclass clazz, jlong ptr, jlong pixels) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    view->SetManipulationDistanceThreshold(pixels);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeSetDoubleTapTimeThreshold
(JNIEnv *env, jclass clazz, jlong ptr, jlong milliseconds) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    view->SetDoubleTapTimeThreshold(milliseconds);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeSetDoubleTapDistanceThreshold
(JNIEnv *env, jclass clazz, jlong ptr, jlong pixels) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    view->SetDoubleTapDistanceThreshold(pixels);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeSetProjectionMatrix
(JNIEnv *env, jclass clazz, jlong ptr, jobject mtx) {
    const auto view = getComponent(env, ptr);
    if (!view) return;

    Noesis::Matrix4 mat = Noesis::Matrix4();
    NSJniUtils::Matrix4ToCopy(env, mat, mtx);
    view->SetProjectionMatrix(mat);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeSetStereoOffscreenScaleFactor
(JNIEnv *env, jclass clazz, jlong ptr, jfloat factor) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    view->SetStereoOffscreenScaleFactor(factor);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeActivate
(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    view->Activate();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeDeactivate
(JNIEnv *env, jclass clazz, jlong ptr) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    view->Deactivate();
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeSetEmulateTouch
(JNIEnv *env, jclass clazz, jlong ptr, jboolean emulate) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    view->SetEmulateTouch(emulate);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeMouseButtonDown
(JNIEnv *env, jclass clazz, jlong ptr, jint x, jint y, jint button) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->MouseButtonDown(x, y, static_cast<Noesis::MouseButton>(button));
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeMouseButtonUp
(JNIEnv *env, jclass clazz, jlong ptr, jint x, jint y, jint button) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->MouseButtonUp(x, y, static_cast<Noesis::MouseButton>(button));
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeMouseDoubleClick
(JNIEnv *env, jclass clazz, jlong ptr, jint x, jint y, jint button) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->MouseDoubleClick(x, y, static_cast<Noesis::MouseButton>(button));
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeMouseMove
(JNIEnv *env, jclass clazz, jlong ptr, jint x, jint y) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->MouseMove(x, y);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeMouseWheel
(JNIEnv *env, jclass clazz, jlong ptr, jint x, jint y, jint wheel) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->MouseWheel(x, y, wheel);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeMouseHWheel
(JNIEnv *env, jclass clazz, jlong ptr, jint x, jint y, jint wheel) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->MouseHWheel(x, y, wheel);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeScroll
(JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->Scroll(value);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeScrollPos
(JNIEnv *env, jclass clazz, jlong ptr, jint x, jint y, jfloat value) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->Scroll(x, y, value);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeHScroll
(JNIEnv *env, jclass clazz, jlong ptr, jfloat value) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->HScroll(value);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeHScrollPos
(JNIEnv *env, jclass clazz, jlong ptr, jint x, jint y, jfloat value) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->HScroll(x, y, value);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeTouchDown
(JNIEnv *env, jclass clazz, jlong ptr, jint x, jint y, jlong id) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->TouchDown(x, y, id);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeTouchMove
(JNIEnv *env, jclass clazz, jlong ptr, jint x, jint y, jlong id) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->TouchMove(x, y, id);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeTouchUp
(JNIEnv *env, jclass clazz, jlong ptr, jint x, jint y, jlong id) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->TouchUp(x, y, id);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeKeyDown
(JNIEnv *env, jclass clazz, jlong ptr, jint key_code) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->KeyDown(static_cast<Noesis::Key>(key_code));
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeKeyUp
(JNIEnv *env, jclass clazz, jlong ptr, jint key_code) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->KeyUp(static_cast<Noesis::Key>(key_code));
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeChar
(JNIEnv *env, jclass clazz, jlong ptr, jlong ch) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->Char(ch);
}

JNIEXPORT jboolean JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeUpdate
(JNIEnv *env, jclass clazz, jlong ptr, jdouble value) {
    const auto view = getComponent(env, ptr);
    if (!view) return 0;
    return view->Update(value);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeRestartTimer
(JNIEnv *env, jclass clazz, jlong ptr, jlong id, jlong value) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    view->RestartTimer(id, value);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeCancelTimer
(JNIEnv *env, jclass clazz, jlong ptr, jlong id) {
    const auto view = getComponent(env, ptr);
    if (!view) return;
    view->CancelTimer(id);
}

JNIEXPORT void JNICALL Java_dev_sixik_noesisgui_nsgui_NSIView_nativeGetStats
(JNIEnv *env, jclass clazz, jlong ptr, jobject stats) {
    const auto view = getComponent(env, ptr);
    if (!view) return;

    const auto stat = view->GetStats();
    NSJniUtils::ViewStatsFromCopy(env, stat, stats);
}
}
