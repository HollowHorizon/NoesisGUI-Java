package dev.sixik.noesisgui.nsgui;

/**
 * Arranges ToolBar items inside a ToolBar.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.primitives.toolbarpanel.aspx">
 * Microsoft Documentation: ToolBarPanel Class</a>
 */
public class NSToolBarPanel extends NSStackPanel {

    public NSToolBarPanel() {
        this(nCreate());
    }

    public NSToolBarPanel(long ptr) {
        super(ptr);
    }

    private static native long nCreate();
}
