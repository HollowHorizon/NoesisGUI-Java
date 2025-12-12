package dev.sixik.noesisgui.nsgui;

/**
 * Used to arrange overflow ToolBar items.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.primitives.toolbaroverflowpanel.aspx">
 * Microsoft Documentation: ToolBarOverflowPanel Class</a>
 */
public class NSToolBarOverflowPanel extends NSPanel {

    public NSToolBarOverflowPanel() {
        this(nCreate());
    }

    public NSToolBarOverflowPanel(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets the recommended width for this panel before items flow to the next line
     */
    public final float getWrapWidth() {
        return nGetWrapWidth(getPtr());
    }

    /**
     * Gets or sets the recommended width for this panel before items flow to the next line
     */
    public final void setWrapWidth(final float value) {
        nSetWrapWidth(getPtr(), value);
    }

    private static native long nCreate();

    private static native float nGetWrapWidth(long ptr);

    private static native void nSetWrapWidth(long ptr, float value);
}
