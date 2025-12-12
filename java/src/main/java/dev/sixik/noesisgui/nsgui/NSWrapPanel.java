package dev.sixik.noesisgui.nsgui;

/**
 * Positions child elements in sequential position from left to right, breaking content to the
 * next line at the edge of the containing box.
 * <p>
 * Subsequent ordering happens sequentially from top to bottom or from right to left, depending on
 * the value of the Orientation property.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.wrappanel.aspx">
 * Microsoft Documentation: WrapPanel Class</a>
 */
public class NSWrapPanel extends NSPanel {

    public NSWrapPanel() {
        this(nCreate());
    }

    public NSWrapPanel(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets a value that specifies the width of all items contained in the panel
     */
    public final float getItemWidth() {
        return nGetItemWidth(getPtr());
    }

    /**
     * Gets or sets a value that specifies the width of all items contained in the panel
     */
    public final void setItemWidth(final float itemWidth) {
        nSetItemWidth(getPtr(), itemWidth);
    }

    /**
     * Gets or sets a value that specifies the height of all items contained in the panel
     */
    public final float getItemHeight() {
        return nGetItemHeight(getPtr());
    }

    /**
     * Gets or sets a value that specifies the height of all items contained in the panel
     */
    public final void setItemHeight(final float itemHeight) {
        nSetItemHeight(getPtr(), itemHeight);
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

    private static native float nGetItemWidth(long ptr);

    private static native void nSetItemWidth(long ptr, float value);

    private static native float nGetItemHeight(long ptr);

    private static native void nSetItemHeight(long ptr, float value);

    private static native int nGetOrientation(long ptr);

    private static native void nSetOrientation(long ptr, int orientation);
}
