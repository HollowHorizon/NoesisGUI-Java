package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nshandlers.NSRequestNavigateEventHandler;
import dev.sixik.noesisgui.nshandlers.NSRoutedEventHandler;

public class NSHyperlink extends NSSpan {

    public NSHyperlink() {
        this(nCreate());
    }

    public NSHyperlink(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets a Uri to navigate to when the Hyperlink is activated
     */
    public final String getNavigateUri() {
        return nGetNavigateUri(getPtr());
    }

    /**
     * Gets or sets a Uri to navigate to when the Hyperlink is activated
     */
    public final void setNavigateUri(final String navigateUri) {
        nSetNavigateUri(getPtr(), navigateUri);
    }

    /**
     * Gets or sets the name of a target window or frame for the Hyperlink
     */
    public final String getTargetName() {
        return nGetTargetName(getPtr());
    }

    /**
     * Gets or sets the name of a target window or frame for the Hyperlink
     */
    public final void setTargetName(final String targetName) {
        nSetTargetName(getPtr(), targetName);
    }

    /**
     * Occurs when the left mouse button is clicked on a Hyperlink
     */
    public final void clickEvent(final NSRoutedEventHandler event) {
        nClick(getPtr(), event);
    }

    /**
     * Occurs when navigation events are requested
     */
    public final void requestNavigateEvent(final NSRequestNavigateEventHandler event) {
        nRequestNavigate(getPtr(), event);
    }

    private static native long nCreate();

    private static native String nGetNavigateUri(long ptr);

    private static native void nSetNavigateUri(long ptr, String value);

    private static native String nGetTargetName(long ptr);

    private static native void nSetTargetName(long ptr, String value);

    private static native void nClick(long ptr, NSRoutedEventHandler event);

    private static native void nRequestNavigate(long ptr, NSRequestNavigateEventHandler event);
}
