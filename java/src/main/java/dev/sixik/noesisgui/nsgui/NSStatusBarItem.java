package dev.sixik.noesisgui.nsgui;

/**
 * Represents an item of a StatusBar control.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.primitives.statusbaritem.aspx">
 *      Microsoft Documentation: StatusBarItem Class</a>
 */
public class NSStatusBarItem extends NSContentControl{

    public NSStatusBarItem() {
        this(nCreate());
    }

    public NSStatusBarItem(long ptr) {
        super(ptr);
    }

    private static native long nCreate();
}
