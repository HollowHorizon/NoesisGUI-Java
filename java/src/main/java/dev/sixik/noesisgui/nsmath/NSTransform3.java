package dev.sixik.noesisgui.nsmath;

public final class NSTransform3 {

    public float m00;
    public float m01;
    public float m02;

    public float m10;
    public float m11;
    public float m12;

    public float m20;
    public float m21;
    public float m22;

    public float m30;
    public float m31;
    public float m32;

    public NSTransform3(final float value) {
        this(value, value, value, value, value, value, value, value, value, value, value, value);
    }

    public NSTransform3(final NSVector3 vec1, final NSVector3 vec2, final NSVector3 vec3, final NSVector3 vec4) {
        this(vec1.x, vec1.y, vec1.z, vec2.x, vec2.y, vec2.z, vec3.x, vec3.y, vec3.z, vec4.x, vec4.y, vec4.z);
    }

    public NSTransform3(final NSTransform3 transform) {
        this(
                transform.m00, transform.m01, transform.m02,
                transform.m10, transform.m11, transform.m12,
                transform.m20, transform.m21, transform.m22,
                transform.m30, transform.m31, transform.m32
        );
    }

    public NSTransform3(final float m00, final float m01, final float m02,
                        final float m10, final float m11, final float m12,
                        final float m20, final float m21, final float m22,
                        final float m30, final float m31, final float m32
    ) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
    }

}
