package dev.sixik.noesisgui.nsdrawing;

import dev.sixik.noesisgui.nsmath.NSVector2;

import java.util.Objects;

public final class NSPoint4D {

    public float x;
    public float y;
    public float z;
    public float w;

    public NSPoint4D(final float value) {
        this(value, value, value, value);
    }

    public NSPoint4D(final NSVector2 point) {
        this(point.x, point.y, 0, 0);
    }

    public NSPoint4D(final NSPoint3D point) {
        this(point.x, point.y, point.z, 0);
    }

    public NSPoint4D(final NSPoint4D point) {
        this(point.x, point.y, point.z, point.w);
    }

    public NSPoint4D(final float x, final float y, final float z, final float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public String toString() {
        return "NSPoint4D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", w=" + w +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NSPoint4D nsPoint4D = (NSPoint4D) o;
        return Float.compare(x, nsPoint4D.x) == 0 && Float.compare(y, nsPoint4D.y) == 0 && Float.compare(z, nsPoint4D.z) == 0 && Float.compare(w, nsPoint4D.w) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
    }
}
