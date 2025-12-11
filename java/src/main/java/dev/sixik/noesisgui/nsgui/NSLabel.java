package dev.sixik.noesisgui.nsgui;

/**
 * Represents the text label for a control.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.label.aspx">
 *      Microsoft Documentation: Label Class</a>
 */
public class NSLabel extends NSContentControl{

    public NSLabel() {
        this(nCreate());
    }

    public NSLabel(long ptr) {
        super(ptr);
    }

    private static native long nCreate();
}
