package dev.sixik.noesisgui.nsdrawing;

import java.util.Objects;

public final class NSInt32Rect {

    public int x;
    public int y;
    public int width;
    public int height;

    public NSInt32Rect() {
        this(0, 0, 0, 0);
    }

    public NSInt32Rect(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public boolean isEmpty() {
        return x == 0 && y == 0 && width == 0 && height == 0;
    }

    public boolean hasArea() {
        return width > 0 && height > 0;
    }

    public static NSInt32Rect empty() {
        return new NSInt32Rect();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NSInt32Rect that = (NSInt32Rect) o;
        return x == that.x && y == that.y && width == that.width && height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, width, height);
    }

    @Override
    public String toString() {
        return "NSInt32Rect{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
