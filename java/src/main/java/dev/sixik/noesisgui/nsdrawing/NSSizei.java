package dev.sixik.noesisgui.nsdrawing;

public final class NSSizei {

    public int width;
    public int height;

    public NSSizei() {
        this(0);
    }

    public NSSizei(final int value) {
        this(value, value);
    }

    public NSSizei(final int width, final int height) {
        this.width = width;
        this.height = height;
    }
}
