package dev.sixik.noesisgui.nsmath;

public final class NSMatrix3 {
    public float m00;
    public float m01;
    public float m02;

    public float m10;
    public float m11;
    public float m12;

    public float m20;
    public float m21;
    public float m22;

    public NSMatrix3(final float value) {
        this(value, value, value, value, value, value, value, value, value);
    }

    public NSMatrix3(final NSVector3 vec1, final NSVector3 vec2, final NSVector3 vec3) {
        this(vec1.x, vec1.y, vec1.z, vec2.x, vec2.y, vec2.z, vec3.x, vec3.y, vec3.z);
    }

    public NSMatrix3(final NSMatrix3 matrix) {
        this(matrix.m00, matrix.m01, matrix.m02, matrix.m10, matrix.m11, matrix.m12, matrix.m20, matrix.m21, matrix.m22);
    }

    public NSMatrix3(final float m00, final float m01, final float m02,
                     final float m10, final float m11, final float m12,
                     final float m20, final float m21, final float m22) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
    }
}
