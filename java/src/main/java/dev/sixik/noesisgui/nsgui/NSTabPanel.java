package dev.sixik.noesisgui.nsgui;

/**
 * Handles the layout of the TabItem objects on a TabControl.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.primitives.tabpanel.aspx">
 * Microsoft Documentation: TabPanel Class</a>
 */
public class NSTabPanel extends NSPanel {

    public NSTabPanel() {
        this(nCreate());
    }

    public NSTabPanel(long ptr) {
        super(ptr);
    }

    private static native long nCreate();
}
