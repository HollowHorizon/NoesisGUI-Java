package dev.sixik.noesisgui.nsgui;

/**
 * Arranges and virtualizes content on a single line that is oriented either horizontally or
 * vertically.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.virtualizingstackpanel.aspx">
 * Microsoft Documentation: VirtualizingStackPanel Class</a>
 */
public class NSVirtualizingStackPanel extends NSVirtualizingPanel {

    public NSVirtualizingStackPanel() {
        this(nCreate());
    }

    public NSVirtualizingStackPanel(long ptr) {
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
