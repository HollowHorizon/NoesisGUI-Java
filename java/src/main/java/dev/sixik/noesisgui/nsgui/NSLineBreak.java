package dev.sixik.noesisgui.nsgui;

/**
 * An inline flow content element that causes a line break to occur in flow content.
 */
public class NSLineBreak extends NSInline {

    public NSLineBreak() {
        this(nCreate());
    }

    public NSLineBreak(long ptr) {
        super(ptr);
    }

    private static native long nCreate();
}
