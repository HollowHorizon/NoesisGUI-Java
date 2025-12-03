package dev.sixik.noesisgui.nsmath;

public final class NSMatrix4 {

    public float m00;
    public float m01;
    public float m02;
    public float m03;

    public float m10;
    public float m11;
    public float m12;
    public float m13;

    public float m20;
    public float m21;
    public float m22;
    public float m23;

    public float m30;
    public float m31;
    public float m32;
    public float m33;

    public NSMatrix4(final float value) {
        this(
                value, value, value, value,
                value, value, value, value,
                value, value, value, value,
                value, value, value, value
        );
    }

    public NSMatrix4(final NSVector4 vec1, final NSVector4 vec2, final NSVector4 vec3, final NSVector4 vec4) {
        this(
                vec1.x, vec1.y, vec1.z, vec1.w,
                vec2.x, vec2.y, vec2.z, vec2.w,
                vec3.x, vec3.y, vec3.z, vec3.w,
                vec4.x, vec4.y, vec4.z, vec4.w
        );
    }

    public NSMatrix4(final NSMatrix4 mat) {
        this(
                mat.m00, mat.m01, mat.m02, mat.m03,
                mat.m10, mat.m11, mat.m12, mat.m13,
                mat.m20, mat.m21, mat.m22, mat.m23,
                mat.m30, mat.m31, mat.m32, mat.m33
        );
    }

    public NSMatrix4(
            final float m00, final float m01, final float m02, final float m03,
            final float m10, final float m11, final float m12, final float m13,
            final float m20, final float m21, final float m22, final float m23,
            final float m30, final float m31, final float m32, final float m33
    ) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
    }
}
