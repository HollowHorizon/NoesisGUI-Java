package dev.sixik.noesisgui.nsdrawing;

public final class NSCornerRadius implements AutoCloseable {

    private long ptr;

    private float tl;
    private float tr;
    private float br;
    private float bl;

    public NSCornerRadius() {
        this(0, 0, 0, 0, nativeCreate());
    }

    public NSCornerRadius(float radius) {
        this(radius, radius, radius, radius, nativeCreateRadius(radius));
    }

    public NSCornerRadius(float tl, float tr, float br, float bl) {
        this(tl, tr, br, bl, nativeCreateCorner(tl, tr, br, bl));
    }

    private NSCornerRadius(float tl, float tr, float br, float bl, long ptr) {
        this.ptr = ptr;
        this.tl = tl;
        this.tr = tr;
        this.br = br;
        this.bl = bl;
    }

    public void setBottomLeft(float value) {
        this.bl = value;
        nativeSetBottomLeft(ptr, value);
    }

    public void setBottomRight(float value) {
        this.br = value;
        nativeSetBottomRight(ptr, value);
    }

    public void setTopRight(float value) {
        this.tr = value;
        nativeSetTopRight(ptr, value);
    }

    public void setTopLeft(float value) {
        this.tl = value;
        nativeSetTopLeft(ptr, value);
    }

    public float getBottomLeft() {
        return getBottomLeftNative();
    }

    public float getBottomRight() {
        return getBottomRightNative();
    }

    public float getTopLeft() {
        return getTopLeftNative();
    }

    public float getTopRight() {
        return getTopRightNative();
    }

    public float getBottomLeftNative() {
        return nativeGetBottomLeft(ptr);
    }

    public float getBottomRightNative() {
        return nativeGetBottomRight(ptr);
    }

    public float getTopLeftNative() {
        return nativeGetTopLeft(ptr);
    }

    public float getTopRightNative() {
        return nativeGetTopRight(ptr);
    }

    @Override
    public void close() {
        if (ptr != 0) {
            nativeDestroy(ptr);
            ptr = 0;
        }
    }

    @Override
    public String toString() {
        return "NSCornerRadius{" +
                "tl=" + tl +
                ", tr=" + tr +
                ", br=" + br +
                ", bl=" + bl +
                '}';
    }

    private static native long nativeCreate();
    private static native long nativeCreateRadius(float radius);
    private static native long nativeCreateCorner(float tl, float tr, float br, float bl);
    private static native void nativeDestroy(long handle);

    private static native float nativeGetTopLeft(long ptr);
    private static native float nativeGetTopRight(long ptr);
    private static native float nativeGetBottomLeft(long ptr);
    private static native float nativeGetBottomRight(long ptr);

    private static native void nativeSetTopLeft(long ptr, float value);
    private static native void nativeSetTopRight(long ptr, float value);
    private static native void nativeSetBottomLeft(long ptr, float value);
    private static native void nativeSetBottomRight(long ptr, float value);
}
