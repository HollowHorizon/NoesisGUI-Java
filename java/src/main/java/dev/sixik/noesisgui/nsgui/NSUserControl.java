package dev.sixik.noesisgui.nsgui;

/**
 * Provides a simple way to create a composition of controls.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.forms.usercontrol.aspx">
 *      Microsoft Documentation: UserControl Class</a>
 */
public class NSUserControl extends NSContentControl{

    public NSUserControl() {
        this(nCreate());
    }

    public NSUserControl(long ptr) {
        super(ptr);
    }

    private static native long nCreate();
}
