package dev.sixik.noesisgui.nsdrawing;

import dev.sixik.noesisgui.nsmath.NSVector2;

import java.util.Objects;

public final class NSPointi {

    public int x;
    public int y;

    public NSPointi(final int value) {
        this(value, value);
    }

    public NSPointi(final NSVector2 vector2) {
        this(Math.round(vector2.x), Math.round(vector2.y));
    }

    public NSPointi(final NSPointi point) {
        this(point.x, point.y);
    }

    public NSPointi(final int xx, final int yy) {
        this.x = xx;
        this.y = yy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NSPointi nsPointi = (NSPointi) o;
        return x == nsPointi.x && y == nsPointi.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "NSPointi{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
