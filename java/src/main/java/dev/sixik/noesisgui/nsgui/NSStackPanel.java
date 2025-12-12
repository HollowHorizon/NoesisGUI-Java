package dev.sixik.noesisgui.nsgui;

/**
 * Arranges child elements into a single horizontal or vertical line.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.stackpanel.aspx">
 * Microsoft Documentation: StackPanel Class</a>
 */
public class NSStackPanel extends NSPanel {

    public NSStackPanel() {
        this(nCreate());
    }

    public NSStackPanel(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets orientation of children elements
     */
    public final NSGui_Orientation getOrientation() {
        return NSGui_Orientation.values()[nGetOrientation(getPtr())];
    }

    /**
     * Gets or sets orientation of children elements
     */
    public final void setOrientation(final NSGui_Orientation orientation) {
        nSetOrientation(getPtr(), orientation.ordinal());
    }

    private static native long nCreate();

    private static native int nGetOrientation(long ptr);

    private static native void nSetOrientation(long ptr, int value);
}
