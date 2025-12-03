package dev.sixik.noesisgui.nsdrawing;

public final class NSColor implements AutoCloseable {

    private long ptr;

    private NSColor(long ptr) {
        this.ptr = ptr;
    }

    public NSColor() {
        this.ptr = nativeCreate();
    }

    public NSColor(float r, float g, float b, float a) {
        this.ptr = nativeCreateRGBA(r, g, b, a);
    }

    @Override
    public void close() {
        if (ptr != 0) {
            nativeDestroy(ptr);
            ptr = 0;
        }
    }

    public boolean isValid() {
        return ptr != 0;
    }

    public float getScR() {
        return nativeGetScR(ptr);
    }

    public void setScR(float v) {
        nativeSetScR(ptr, v);
    }

    public float getScG() {
        return nativeGetScG(ptr);
    }

    public void setScG(float v) {
        nativeSetScG(ptr, v);
    }

    public float getScB() {
        return nativeGetScB(ptr);
    }

    public void setScB(float v) {
        nativeSetScB(ptr, v);
    }

    public float getScA() {
        return nativeGetScA(ptr);
    }

    public void setScA(float v) {
        nativeSetScA(ptr, v);
    }

    public int getPackedRGBA() {
        return nativeGetPackedRGBA(ptr);
    }

    public int getPackedBGRA() {
        return nativeGetPackedBGRA(ptr);
    }

    public static NSColor fromPackedRGBA(int packed) {
        long ptr = nativeFromPackedRGBA(packed);
        return new NSColor(ptr);
    }

    public static NSColor fromPackedBGRA(int packed) {
        long ptr = nativeFromPackedBGRA(packed);
        return new NSColor(ptr);
    }

    public static NSColor black() {
        long ptr = nativeBlack();
        return new NSColor(ptr);
    }

    public static NSColor white() {
        long ptr = nativeWhite();
        return new NSColor(ptr);
    }

    public static NSColor red() {
        long ptr = nativeRed();
        return new NSColor(ptr);
    }

    public static NSColor green() {
        long ptr = nativeGreen();
        return new NSColor(ptr);
    }

    public static NSColor blue() {
        long ptr = nativeBlue();
        return new NSColor(ptr);
    }

    @Override
    public String toString() {
        return nativeToString(ptr);
    }

    private static native long nativeCreate();
    private static native long nativeCreateRGBA(float r, float g, float b, float a);
    private static native void nativeDestroy(long handle);

    private static native void nativeSetScR(long handle, float v);
    private static native float nativeGetScR(long handle);

    private static native void nativeSetScG(long handle, float v);
    private static native float nativeGetScG(long handle);

    private static native void nativeSetScB(long handle, float v);
    private static native float nativeGetScB(long handle);

    private static native void nativeSetScA(long handle, float v);
    private static native float nativeGetScA(long handle);

    private static native int nativeGetPackedRGBA(long handle);
    private static native int nativeGetPackedBGRA(long handle);

    private static native long nativeFromPackedRGBA(int packed);
    private static native long nativeFromPackedBGRA(int packed);

    private static native long nativeBlack();
    private static native long nativeWhite();
    private static native long nativeRed();
    private static native long nativeGreen();
    private static native long nativeBlue();

    private static native String nativeToString(long handle);
}
