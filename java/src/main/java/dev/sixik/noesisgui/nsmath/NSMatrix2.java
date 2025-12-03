package dev.sixik.noesisgui.nsmath;

import java.util.Objects;

public final class NSMatrix2 {

    public float m00;
    public float m01;
    public float m10;
    public float m11;

    public NSMatrix2() {
        this(0);
    }

    public NSMatrix2(final float value) {
        this(value, value, value, value);
    }

    public NSMatrix2(final NSMatrix2 matrix2) {
        this(matrix2.m00, matrix2.m01, matrix2.m10, matrix2.m11);
    }

    public NSMatrix2(final NSVector2 m0, final NSVector2 m1) {
        this(m0.x, m0.y, m1.x, m1.y);
    }

    public NSMatrix2(final float m00, final float m01, final float m10, final float m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }

    public NSMatrix2 plus(final NSMatrix2 matrix2) {
        this.m00 += matrix2.m00;
        this.m01 += matrix2.m01;
        this.m10 += matrix2.m10;
        this.m11 += matrix2.m11;
        return this;
    }

    public NSMatrix2 plus(final float value) {
        this.m00 += value;
        this.m01 += value;
        this.m10 += value;
        this.m11 += value;
        return this;
    }

    public NSMatrix2 minus(final NSMatrix2 matrix2) {
        this.m00 -= matrix2.m00;
        this.m01 -= matrix2.m01;
        this.m10 -= matrix2.m10;
        this.m11 -= matrix2.m11;
        return this;
    }

    public NSMatrix2 minus(final float value) {
        this.m00 -= value;
        this.m01 -= value;
        this.m10 -= value;
        this.m11 -= value;
        return this;
    }

    public NSMatrix2 mul(final NSMatrix2 matrix2) {
        this.m00 *= matrix2.m00;
        this.m01 *= matrix2.m01;
        this.m10 *= matrix2.m10;
        this.m11 *= matrix2.m11;
        return this;
    }

    public NSMatrix2 mul(final float value) {
        this.m00 *= value;
        this.m01 *= value;
        this.m10 *= value;
        this.m11 *= value;
        return this;
    }

    public NSMatrix2 div(final NSMatrix2 matrix2) {
        this.m00 /= matrix2.m00;
        this.m01 /= matrix2.m01;
        this.m10 /= matrix2.m10;
        this.m11 /= matrix2.m11;
        return this;
    }

    public NSMatrix2 div(final float value) {
        this.m00 /= value;
        this.m01 /= value;
        this.m10 /= value;
        this.m11 /= value;
        return this;
    }

    public NSMatrix2 transpose() {
        return new NSMatrix2(m00, m10, m01, m11);
    }

    public NSMatrix2 inverse() {
        return inverse(determinant());
    }

    public NSMatrix2 inverse(final float determinant) {
        return new NSMatrix2(m11, -m01, -m10, m00).div(determinant);
    }

    public float determinant() {
        return m00 * m11 - m01 * m10;
    }

    public NSMatrix2 preScale(final float scaleX, final float scaleY) {
        return new NSMatrix2(
                m00 * scaleX, m01 * scaleX,
                m10 * scaleY, m11 * scaleY
        );
    }

    public NSMatrix2 preRot(final float radians) {
        float cs = (float) Math.cos(radians);
        float sn = (float) Math.sin(radians);

        return new NSMatrix2(
            m00 * cs + m10 * sn, m01 * cs + m11 * sn,
            m10 * cs - m00 * sn, m11 * cs - m01 * sn
        );
    }

    public NSMatrix2 postScale(final float scaleX, final float scaleY) {
        return new NSMatrix2(
                m00 * scaleX, m01 * scaleY,
                m10 * scaleX, m11 * scaleY
        );
    }

    public NSMatrix2 postRot(final float radians) {
        float cs = (float) Math.cos(radians);
        float sn = (float) Math.sin(radians);
        return new NSMatrix2(
                m00 * cs - m01 * sn, m01 * cs + m00 * sn,
                m10 * cs - m11 * sn, m11 * cs + m10 * sn
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NSMatrix2 nsMatrix2 = (NSMatrix2) o;
        return Float.compare(m00, nsMatrix2.m00) == 0 && Float.compare(m01, nsMatrix2.m01) == 0 && Float.compare(m10, nsMatrix2.m10) == 0 && Float.compare(m11, nsMatrix2.m11) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m00, m01, m10, m11);
    }

    @Override
    public String toString() {
        return "NSMatrix2{" +
                "m00=" + m00 +
                ", m01=" + m01 +
                ", m10=" + m10 +
                ", m11=" + m11 +
                '}';
    }

    public static NSMatrix2 identity() {
        return new NSMatrix2(1, 0, 0, 1);
    }

    public static NSMatrix2 scale(final float x, final float y) {
        return new NSMatrix2(x, 0, 0, y);
    }

    public static NSMatrix2 rot(final float radians) {
        float cs = (float) Math.cos(radians);
        float sn = (float) Math.sin(radians);
        return new NSMatrix2(cs, sn, -sn, cs);
    }

    public static NSMatrix2 shearXY(final float shear) {
        return new NSMatrix2(1.0f, 0.0f, shear, 1f);
    }

    public static NSMatrix2 shearYX(final float shear) {
        return new NSMatrix2(1.0f, shear, 0.0f, 1f);
    }
}
