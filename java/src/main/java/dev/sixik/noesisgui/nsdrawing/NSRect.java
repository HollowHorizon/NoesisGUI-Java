package dev.sixik.noesisgui.nsdrawing;

import dev.sixik.noesisgui.nsmath.*;
import dev.sixik.noesisgui.utils.NSMath;

import java.util.Objects;

public final class NSRect {

    public float x;
    public float y;
    public float width;
    public float height;

    public NSRect() {
        this(0, 0, 0, 0);
    }

    public NSRect(final NSSize size) {
        this(0, 0, size.width, size.height);
    }

    public NSRect(final NSRect react) {
        this(react.x, react.y, react.width, react.height);
    }

    public NSRect(final NSVector2 vector2, final NSSize size) {
        this(vector2.x, vector2.y, size.width, size.height);
    }

    public NSRect(final float left, final float top, final float right, final float bottom) {
        this.x = left;
        this.y = top;
        this.width = right;
        this.height = bottom;
    }

    public NSPoint getLocation() {
        return new NSPoint(x, y);
    }

    public NSRect setLocation(final NSPoint point) {
        this.x = point.x;
        this.y = point.y;
        return this;
    }

    public NSSize getSize() {
        return new NSSize(width, height);
    }

    public NSRect setSize(final NSSize size) {
        this.width = size.width;
        this.height = size.height;
        return this;
    }

    public float getLeft() {
        return x;
    }

    public float getRight() {
        return x + width;
    }

    public float getTop() {
        return y;
    }

    public float getBottom() {
        return y + height;
    }

    public NSPoint getTopLeft() {
        return new NSPoint(x, y);
    }

    public NSPoint getTopRight() {
        return new NSPoint(getRight(), y);
    }

    public NSPoint getBottomLeft() {
        return new NSPoint(x, getBottom());
    }

    public NSPoint getBottomRight() {
        return new NSPoint(getRight(), getBottom());
    }

    public boolean isEmpty() {
        return width <= 0 || height <= 0;
    }

    public boolean contains(final float x_, final float y_) {
        return !isEmpty() &&
                x_ >= getLeft() && x_ <= getRight() &&
                y_ >= getTop() && y_ <= getBottom();
    }

    public boolean contains(final NSPoint point) {
        return contains(point.x, point.y);
    }

    public boolean contains(final NSRect rect) {
        return !isEmpty() && !rect.isEmpty() &&
                rect.getLeft() >= getLeft() && rect.getRight() <= getRight() &&
                rect.getTop() >= getTop() && rect.getBottom() <= getBottom();
    }

    public NSRect inflate(final float width_, final float height_) {
        x -= width_;
        y -= height_;
        width += 2.0f * width_;
        height += 2.0f * height_;

        if (width <= 0.0f || height <= 0.0f) {
            x = 0.0f;
            y = 0.0f;
            width = 0.0f;
            height = 0.0f;
        }
        return this;
    }

    public NSRect inflate(final NSSize size) {
        inflate(size.width, size.height);
        return this;
    }

    public NSRect intersect(final NSRect rect) {
        float x1 = Math.max(getLeft(), rect.getLeft());
        float x2 = Math.min(getRight(), rect.getRight());
        if (x2 >= x1) {
            float y1 = Math.max(getTop(), rect.getTop());
            float y2 = Math.min(getBottom(), rect.getBottom());
            if (y2 >= y1) {
                return new NSRect(x1, y1, x2, y2);
            }
        }

        return NSRect.empty();
    }

    public boolean intersectsWith(final NSRect rect) {
        final NSSize s = intersect(rect).getSize();
        return s.width > NSMath.FLT_EPSILON && s.height > NSMath.FLT_EPSILON;
    }

    public NSRect offset(final NSPoint point) {
        x += point.x;
        y += point.y;
        return this;
    }

    public NSRect scale(final float scaleX, final float scaleY) {
        width *= scaleX;
        height *= scaleY;
        return this;
    }

    public NSRect expand(final NSPoint point) {
        float x0 = Math.min(x, point.x);
        float y0 = Math.min(y, point.y);
        float x1 = Math.max(getRight(), point.x);
        float y1 = Math.max(getBottom(), point.y);

        x = x0;
        y = y0;
        width = x1 - x0;
        height = y1 - y0;
        return this;
    }

    public NSRect expand(final NSRect rect) {
        float x0 = Math.min(x, rect.x);
        float y0 = Math.min(y, rect.y);
        float x1 = Math.max(getRight(), rect.getRight());
        float y1 = Math.max(getBottom(), rect.getBottom());

        x = x0;
        y = y0;
        width = x1 - x0;
        height = y1 - y0;
        return this;
    }

    public NSRect transform(final NSTransform2 mtx) {
        if (!NSMath.isInfinity(width) && !NSMath.isInfinity(height)) {
            final NSAABBox box = new NSAABBox(x, y, x + width, y + height);
            final NSVector2 boxMin = box.min();

            x = boxMin.x;
            y = boxMin.y;

            final NSVector2 boxDiagonal = box.diagonal();
            width = boxDiagonal.x;
            height = boxDiagonal.y;
        }

        return this;
    }

    public NSRect transform(final NSMatrix4 mtx) {
        if (NSMath.isZero(mtx.m02) && NSMath.isZero(mtx.m12) && NSMath.isOne(mtx.m22) && NSMath.isZero(mtx.m32)) {
            transform(new NSTransform2(mtx.m00, mtx.m01, mtx.m10, mtx.m11, mtx.m20, mtx.m21));
        } else if (!NSMath.isInfinity(width) && !NSMath.isInfinity(height)) {
            final float l = getLeft();
            final float r = getRight();
            final float t = getTop();
            final float b = getBottom();

            final NSVector4 tlp = new NSVector4(l, t, 0.0f, 1.0f).mul(mtx);
            final NSVector4 trp = new NSVector4(r, t, 0.0f, 1.0f).mul(mtx);
            final NSVector4 blp = new NSVector4(r, b, 0.0f, 1.0f).mul(mtx);
            final NSVector4 brp = new NSVector4(l, b, 0.0f, 1.0f).mul(mtx);

            final NSPoint tlpw = new NSPoint(tlp.x / tlp.w, tlp.y / tlp.w);
            final NSPoint trpw = new NSPoint(trp.x / trp.w, trp.y / trp.w);
            final NSPoint blpw = new NSPoint(blp.x / blp.w, blp.y / blp.w);
            final NSPoint brpw = new NSPoint(brp.x / brp.w, brp.y / brp.w);

            width = 0.0f;
            height = 0.0f;

            x = tlpw.x;
            y = tlpw.y;

            expand(trpw);
            expand(blpw);
            expand(brpw);
        }

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NSRect nsReact = (NSRect) o;
        return Float.compare(x, nsReact.x) == 0 && Float.compare(y, nsReact.y) == 0 && Float.compare(width, nsReact.width) == 0 && Float.compare(height, nsReact.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, width, height);
    }

    @Override
    public String toString() {
        return "NSReact{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public static NSRect empty() {
        return new NSRect();
    }


}
