package dev.sixik.noesisgui.nsmath;

import java.util.Objects;

public final class NSAABBox {

    public float minX;
    public float minY;
    public float maxX;
    public float maxY;

    public NSAABBox() {
        this(0, 0, 0, 0);
    }

    public NSAABBox(final float value) {
        this(value, value, value, value);
    }

    public NSAABBox(final NSAABBox box) {
        this(box.minX, box.minY, box.maxX, box.maxY);
    }

    public NSAABBox(final NSVector2 min, final NSVector2 max) {
        this(min.x, min.y, max.x, max.y);
    }

    public NSAABBox(final NSVector2 center, final float halfSide) {
        if (halfSide <= 0)
            throw new IllegalArgumentException("HalfSide can't be less or equal 0");

        final NSVector2 mMin = center.minus(halfSide);
        final NSVector2 mMax = center.plus(halfSide);
        this.minX = mMin.x;
        this.minY = mMin.y;
        this.maxX = mMax.x;
        this.maxY = mMax.y;
    }

    public NSAABBox(final float minX, final float minY, final float maxX, final float maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public NSVector2[] toVectors() {
        return new NSVector2[]{new NSVector2(minX, minY), new NSVector2(maxX, maxY)};
    }

    public NSVector2 min() {
        return new NSVector2(minX, minY);
    }

    public NSVector2 max() {
        return new NSVector2(maxX, maxY);
    }

    public NSVector2 center() {
        return min().plus(max()).mul(0.5f);
    }

    public NSVector2 diagonal() {
        return max().minus(min());
    }

    public NSAABBox plus(final NSVector2 vector2) {
        minX = Math.min(vector2.x, minX);
        minY = Math.min(vector2.y, minY);
        maxX = Math.max(vector2.x, maxX);
        maxY = Math.max(vector2.y, maxY);
        return this;
    }

    public NSAABBox plus(final NSAABBox box) {
        minX = Math.min(box.minX, minX);
        minY = Math.min(box.minY, minY);
        maxX = Math.max(box.maxX, maxX);
        maxY = Math.max(box.maxY, maxY);
        return this;
    }

    public NSAABBox scale(float s) {
        NSVector2 center = center();
        minX = (minX - center.x) * s + center.x;
        minY = (minY - center.y) * s + center.y;
        maxX = (maxX - center.x) * s + center.x;
        maxY = (maxY - center.y) * s + center.y;
        return this;
    }

    public boolean isEmpty() {
        return maxX < minX || maxY < minY;
    }

    public boolean inside(final NSVector2 p) {
        return p.x > minX && p.y > minY && p.x < maxX && p.y < maxY;
    }

    public boolean inside(final NSAABBox box) {
        return box.minX >= minX && box.minY >= minY && box.maxX <= maxX && box.maxY <= maxY;
    }

    public boolean boxesIntersect(final NSAABBox box) {
        return minX < box.maxX && minY < box.maxY && maxX > box.minX && maxY > box.minY;
    }

    public NSAABBox intersect(final NSAABBox box) {
        return new NSAABBox(
                Math.max(box.minX, minX), Math.max(box.minY, minY),
                Math.min(box.maxX, maxX), Math.min(box.maxY, maxY)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NSAABBox nsaabBox = (NSAABBox) o;
        return Float.compare(minX, nsaabBox.minX) == 0 && Float.compare(minY, nsaabBox.minY) == 0 && Float.compare(maxX, nsaabBox.maxX) == 0 && Float.compare(maxY, nsaabBox.maxY) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minX, minY, maxX, maxY);
    }

    @Override
    public String toString() {
        return "NSAABBox{" +
                "minX=" + minX +
                ", minY=" + minY +
                ", maxX=" + maxX +
                ", maxY=" + maxY +
                '}';
    }
}
