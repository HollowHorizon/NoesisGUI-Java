package dev.sixik.noesisgui.nsmath;


import java.util.Objects;

public final class NSVector4 {

    public float x;
    public float y;
    public float z;
    public float w;

    public NSVector4() {
        this(0);
    }

    public NSVector4(final float value) {
        this(value, value, value, value);
    }

    public NSVector4(final NSVector2 vec, final float z, final float w) {
        this(vec.x, vec.y, z, w);
    }

    public NSVector4(final NSVector2 vec1, final NSVector2 ve2) {
        this(vec1.x, vec1.y, ve2.x, ve2.y);
    }

    public NSVector4(final NSVector3 vec, final float w) {
        this(vec.x, vec.y, vec.z, w);
    }

    public NSVector4(final NSVector4 vec) {
        this(vec.x, vec.y, vec.z, vec.w);
    }

    public NSVector4(final float x, final float y, final float z, final float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public float[] toArray() {
        return new float[]{x, y, w, z};
    }

    public NSVector2 xy() {
        return new NSVector2(x, y);
    }

    public NSVector2 xz() {
        return new NSVector2(x, z);
    }

    public NSVector2 xw() {
        return new NSVector2(x, w);
    }

    public NSVector2 yz() {
        return new NSVector2(y, z);
    }

    public NSVector2 yw() {
        return new NSVector2(y, w);
    }

    public NSVector3 xyz() {
        return new NSVector3(x, y, z);
    }

    public NSVector3 xyw() {
        return new NSVector3(x, y, w);
    }

    public NSVector4 plus(final float value) {
        this.x += value;
        this.y += value;
        this.z += value;
        this.w += value;
        return this;
    }

    public NSVector4 plus(final NSVector4 vector) {
        this.x += vector.x;
        this.y += vector.y;
        this.z += vector.z;
        this.w += vector.w;
        return this;
    }

    public NSVector4 minus(final float value) {
        this.x -= value;
        this.y -= value;
        this.z -= value;
        this.w -= value;
        return this;
    }

    public NSVector4 minus(final NSVector4 vector) {
        this.x -= vector.x;
        this.y -= vector.y;
        this.z -= vector.z;
        this.w -= vector.w;
        return this;
    }

    public NSVector4 mul(final float value) {
        this.x *= value;
        this.y *= value;
        this.z *= value;
        this.w *= value;
        return this;
    }

    public NSVector4 mul(final NSVector4 vector) {
        this.x *= vector.x;
        this.y *= vector.y;
        this.z *= vector.z;
        this.w *= vector.w;
        return this;
    }

    public NSVector4 mul(final NSMatrix4 m) {
        return new NSVector4(
                x * m.m00 + y * m.m10 + z * m.m20 + w * m.m30,
                x * m.m01 + y * m.m11 + z * m.m21 + w * m.m31,
                x * m.m02 + y * m.m12 + z * m.m22 + w * m.m32,
                x * m.m03 + y * m.m13 + z * m.m23 + w * m.m33
        );
    }

    public NSVector4 div(final float value) {
        this.x /= value;
        this.y /= value;
        this.z /= value;
        this.w /= value;
        return this;
    }

    public NSVector4 div(final NSVector4 vector) {
        this.x /= vector.x;
        this.y /= vector.y;
        this.z /= vector.z;
        this.w /= vector.w;
        return this;
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z + w * w);
    }

    public float lengthSquared() {
        return x * x + y * y + z * z + w * w;
    }

    public NSVector4 normalize() {
        final float length = length();
        return new NSVector4(x / length, y / length, z / length, w / length);
    }

    public NSVector3 project() {
        return new NSVector3(x / w, y / w, z / w);
    }

    public float dot(final NSVector4 v1) {
        return x * v1.x + y * v1.y + z * v1.z + w * v1.w;
    }

    @Override
    public String toString() {
        return "NSVector4{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", w=" + w +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NSVector4 nsVector4 = (NSVector4) o;
        return Float.compare(x, nsVector4.x) == 0 && Float.compare(y, nsVector4.y) == 0 && Float.compare(z, nsVector4.z) == 0 && Float.compare(w, nsVector4.w) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
    }
}
