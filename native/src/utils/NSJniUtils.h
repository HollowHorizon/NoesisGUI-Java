//
// Created by Sixik on 03.12.2025.
//

#ifndef NOESIS_JNI_NSJNIUTILS_H
#define NOESIS_JNI_NSJNIUTILS_H
#include <jni.h>

#include "NsDrawing/Int32Rect.h"
#include "NsDrawing/Point.h"
#include "NsGui/Grid.h"
#include "NsGui/IntegrationAPI.h"
#include "NsMath/Vector.h"
#include "NsRender/RenderDevice.h"


namespace Noesis {
    struct Vector2;
}

class NSJniUtils {

public:

    static void Int32RectToCopy(JNIEnv *env, Noesis::Int32Rect &src, const jobject dst) {
        const jclass cls = env->GetObjectClass(dst);
        const jfieldID xField = env->GetFieldID(cls, "x", "I");
        const jfieldID yField = env->GetFieldID(cls, "y", "I");
        const jfieldID zField = env->GetFieldID(cls, "w", "I");
        const jfieldID wField = env->GetFieldID(cls, "h", "I");

        src.x = env->GetIntField(dst, xField);
        src.y = env->GetIntField(dst, yField);
        src.width = env->GetIntField(dst, zField);
        src.height = env->GetIntField(dst, wField);
    }

    static void Int32RectFromCopy(JNIEnv *env, const Noesis::Int32Rect &src, jobject dst) {
        const jclass cls = env->GetObjectClass(dst);
        const jfieldID xField = env->GetFieldID(cls, "x", "I");
        const jfieldID yField = env->GetFieldID(cls, "y", "I");
        const jfieldID zField = env->GetFieldID(cls, "w", "I");
        const jfieldID wField = env->GetFieldID(cls, "h", "I");

        env->SetIntField(dst, xField, src.x);
        env->SetIntField(dst, yField, src.y);
        env->SetIntField(dst, zField, src.width);
        env->SetIntField(dst, wField, src.height);
    }

    static void Vector2ToCopy(JNIEnv *env, Noesis::Vector2 &src, const jobject dst) {
        const jclass cls = env->GetObjectClass(dst);
        const jfieldID xField = env->GetFieldID(cls, "x", "F");
        const jfieldID yField = env->GetFieldID(cls, "y", "F");

        src.x = env->GetFloatField(dst, xField);
        src.y = env->GetFloatField(dst, yField);
    }

    static void Vector2FromCopy(JNIEnv *env, const Noesis::Vector2 &src, jobject dst) {
        const jclass cls = env->GetObjectClass(dst);
        const jfieldID xField = env->GetFieldID(cls, "x", "F");
        const jfieldID yField = env->GetFieldID(cls, "y", "F");

        env->SetFloatField(dst, xField, src.x);
        env->SetFloatField(dst, yField, src.y);
    }

    static void PointToCopy(JNIEnv *env, Noesis::Point &src, const jobject dst) {
        const jclass cls = env->GetObjectClass(dst);
        const jfieldID xField = env->GetFieldID(cls, "x", "F");
        const jfieldID yField = env->GetFieldID(cls, "y", "F");

        src.x = env->GetFloatField(dst, xField);
        src.y = env->GetFloatField(dst, yField);
    }

    static void PointFromCopy(JNIEnv *env, const Noesis::Point &src, jobject dst) {
        const jclass cls = env->GetObjectClass(dst);
        const jfieldID xField = env->GetFieldID(cls, "x", "F");
        const jfieldID yField = env->GetFieldID(cls, "y", "F");

        env->SetFloatField(dst, xField, src.x);
        env->SetFloatField(dst, yField, src.y);
    }

    static void PointIToCopy(JNIEnv *env, Noesis::Pointi &src, const jobject dst) {
        const jclass cls = env->GetObjectClass(dst);
        const jfieldID xField = env->GetFieldID(cls, "x", "I");
        const jfieldID yField = env->GetFieldID(cls, "y", "I");

        src.x = env->GetIntField(dst, xField);
        src.y = env->GetIntField(dst, yField);
    }

    static void PointIFromCopy(JNIEnv *env, const Noesis::Pointi &src, jobject dst) {
        const jclass cls = env->GetObjectClass(dst);
        const jfieldID xField = env->GetFieldID(cls, "x", "I");
        const jfieldID yField = env->GetFieldID(cls, "y", "I");

        env->SetIntField(dst, xField, src.x);
        env->SetIntField(dst, yField, src.y);
    }

    static void Point3DToCopy(JNIEnv *env, Noesis::Point3D &src, const jobject dst) {
        const jclass cls = env->GetObjectClass(dst);
        const jfieldID xField = env->GetFieldID(cls, "x", "F");
        const jfieldID yField = env->GetFieldID(cls, "y", "F");
        const jfieldID zField = env->GetFieldID(cls, "z", "F");

        src.x = env->GetFloatField(dst, xField);
        src.y = env->GetFloatField(dst, yField);
        src.z = env->GetFloatField(dst, zField);
    }

    static void Point3DFromCopy(JNIEnv *env, const Noesis::Point3D &src, jobject dst) {
        const jclass cls = env->GetObjectClass(dst);
        const jfieldID xField = env->GetFieldID(cls, "x", "F");
        const jfieldID yField = env->GetFieldID(cls, "y", "F");
        const jfieldID zField = env->GetFieldID(cls, "z", "F");

        env->SetFloatField(dst, xField, src.x);
        env->SetFloatField(dst, yField, src.y);
        env->SetFloatField(dst, zField, src.z);
    }

    static void Point4DToCopy(JNIEnv *env, Noesis::Point4D &src, const jobject dst) {
        const jclass cls = env->GetObjectClass(dst);
        const jfieldID xField = env->GetFieldID(cls, "x", "F");
        const jfieldID yField = env->GetFieldID(cls, "y", "F");
        const jfieldID zField = env->GetFieldID(cls, "z", "F");
        const jfieldID wField = env->GetFieldID(cls, "w", "F");

        src.x = env->GetFloatField(dst, xField);
        src.y = env->GetFloatField(dst, yField);
        src.z = env->GetFloatField(dst, zField);
        src.w = env->GetFloatField(dst, wField);
    }

    static void Point4DFromCopy(JNIEnv *env, const Noesis::Point4D &src, jobject dst) {
        const jclass cls = env->GetObjectClass(dst);
        const jfieldID xField = env->GetFieldID(cls, "x", "F");
        const jfieldID yField = env->GetFieldID(cls, "y", "F");
        const jfieldID zField = env->GetFieldID(cls, "z", "F");
        const jfieldID wField = env->GetFieldID(cls, "w", "F");

        env->SetFloatField(dst, xField, src.x);
        env->SetFloatField(dst, yField, src.y);
        env->SetFloatField(dst, zField, src.z);
        env->SetFloatField(dst, wField, src.w);
    }

    static void DeviceCapsToCopy(JNIEnv *env, Noesis::DeviceCaps &src, const jobject dst) {
        const jclass cls = env->GetObjectClass(dst);
        const jfieldID centerPixelOffset = env->GetFieldID(cls, "centerPixelOffset", "F");
        const jfieldID linearRendering = env->GetFieldID(cls, "linearRendering", "Z");
        const jfieldID subpixelRendering = env->GetFieldID(cls, "subpixelRendering", "Z");
        const jfieldID depthRangeZeroToOne = env->GetFieldID(cls, "depthRangeZeroToOne", "Z");
        const jfieldID clipSpaceYInverted = env->GetFieldID(cls, "clipSpaceYInverted", "Z");

        src.centerPixelOffset = env->GetFloatField(dst, centerPixelOffset);
        src.linearRendering = env->GetBooleanField(dst, linearRendering);
        src.subpixelRendering = env->GetBooleanField(dst, subpixelRendering);
        src.depthRangeZeroToOne = env->GetBooleanField(dst, depthRangeZeroToOne);
        src.clipSpaceYInverted = env->GetBooleanField(dst, clipSpaceYInverted);
    }

    static void DeviceCapsFromCopy(JNIEnv *env, const Noesis::DeviceCaps &src, jobject dst) {
        const jclass cls = env->GetObjectClass(dst);
        const jfieldID centerPixelOffset = env->GetFieldID(cls, "centerPixelOffset", "F");
        const jfieldID linearRendering = env->GetFieldID(cls, "linearRendering", "Z");
        const jfieldID subpixelRendering = env->GetFieldID(cls, "subpixelRendering", "Z");
        const jfieldID depthRangeZeroToOne = env->GetFieldID(cls, "depthRangeZeroToOne", "Z");
        const jfieldID clipSpaceYInverted = env->GetFieldID(cls, "clipSpaceYInverted", "Z");

        env->SetFloatField(dst, centerPixelOffset, src.centerPixelOffset);
        env->SetBooleanField(dst, linearRendering, src.linearRendering);
        env->SetBooleanField(dst, subpixelRendering, src.subpixelRendering);
        env->SetBooleanField(dst, depthRangeZeroToOne, src.depthRangeZeroToOne);
        env->SetBooleanField(dst, clipSpaceYInverted, src.clipSpaceYInverted);
    }
};


#endif //NOESIS_JNI_NSJNIUTILS_H