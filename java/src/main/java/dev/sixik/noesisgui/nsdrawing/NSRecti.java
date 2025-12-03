package dev.sixik.noesisgui.nsdrawing;

public final class NSRecti {

    public int x;
    public int y;
    public int width;
    public int height;

    public NSRecti() {
        this(0);
    }

    public NSRecti(final int value) {
        this(value, value, value, value);
    }

    public NSRecti(final NSSizei size) {
        this(0, 0, size.width, size.height);
    }

    public NSRecti(final NSRecti recti) {
        this(recti.x, recti.y, recti.width, recti.height);
    }

    public NSRecti(final int left, final int top, final int right, final int bottom) {
        this.x = left;
        this.y = top;
        this.width = right;
        this.height = bottom;
    }
}
