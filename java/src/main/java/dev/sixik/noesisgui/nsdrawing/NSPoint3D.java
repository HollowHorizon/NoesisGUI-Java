package dev.sixik.noesisgui.nsdrawing;

import dev.sixik.noesisgui.nsmath.NSVector2;

import java.util.Objects;

public final class NSPoint3D {

    public float x;
    public float y;
    public float z;

    public NSPoint3D() {
        this(0);
    }

    public NSPoint3D(final float value) {
        this(value, value, value);
    }

    public NSPoint3D(final NSVector2 vector2) {
        this(vector2.x, vector2.y, 0);
    }

    public NSPoint3D(final NSPointi pointi) {
        this(pointi.x, pointi.y, 0);
    }

    public NSPoint3D(final NSPoint3D point) {
        this(point.x, point.y, point.z);
    }

    public NSPoint3D(final float x, final float y, final float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NSPoint3D nsPoint3D = (NSPoint3D) o;
        return Float.compare(x, nsPoint3D.x) == 0 && Float.compare(y, nsPoint3D.y) == 0 && Float.compare(z, nsPoint3D.z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "NSPoint3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
