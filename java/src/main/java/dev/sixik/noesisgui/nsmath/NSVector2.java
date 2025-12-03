package dev.sixik.noesisgui.nsmath;

import java.util.Objects;

public class NSVector2 {

    public float x;
    public float y;

    public NSVector2(final float values) {
        this(values, values);
    }

    public NSVector2(final NSVector2 vector2) {
        this(vector2.x, vector2.y);
    }

    public NSVector2(float xx, float yy) {
        this.x = xx;
        this.y = yy;
    }

    public float[] toArray() {
        return new float[] { x, y };
    }

    public float getData() {
        return x;
    }

    public NSVector2 plus(final float value) {
        this.x += value;
        this.y += value;
        return this;
    }

    public NSVector2 plus(final float x, final float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public NSVector2 plus(final NSVector2 vector2) {
        this.x += vector2.x;
        this.y += vector2.y;
        return this;
    }

    public NSVector2 minus(final float value) {
        this.x -= value;
        this.y -= value;
        return this;
    }

    public NSVector2 minus(final float x, final float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public NSVector2 minus(final NSVector2 vector2) {
        this.x -= vector2.x;
        this.y -= vector2.y;
        return this;
    }

    public NSVector2 mul(final float value) {
        this.x *= value;
        this.y *= value;
        return this;
    }

    public NSVector2 mul(final float x, final  float y) {
        this.x *= x;
        this.y *= y;
        return this;
    }

    public NSVector2 mul(final NSVector2 vector2) {
        this.x *= vector2.x;
        this.y *= vector2.y;
        return this;
    }

    public NSVector2 div(final float value) {
        this.x /= value;
        this.y /= value;
        return this;
    }

    public NSVector2 div(final float x, final  float y) {
        this.x /= x;
        this.y /= y;
        return this;
    }

    public NSVector2 div(final NSVector2 vector2) {
        this.x /= vector2.x;
        this.y /= vector2.y;
        return this;
    }

    public static float length(final NSVector2 v) {
        return (float) Math.sqrt(v.x * v.x + v.y * v.y);
    }

    public static float lengthSquared(final NSVector2 v) {
        return v.x * v.x + v.y * v.y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final NSVector2 nsVector2 = (NSVector2) o;
        return Float.compare(x, nsVector2.x) == 0 && Float.compare(y, nsVector2.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "NSVector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static NSVector2 zero() {
        return new NSVector2(0);
    }

    public static NSVector2 xAxis() {
        return new NSVector2(1, 0);
    }

    public static NSVector2 yAxis() {
        return new NSVector2(0, 1);
    }
}
