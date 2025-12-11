package dev.sixik.noesisgui.nsgui;

/**
 * Represents a button that can be selected, but not cleared, by a user.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.radiobutton.aspx">
 * Microsoft Documentation: RadioButton Class</a>
 */
public class NSRadioButton extends NSToggleButton {

    public NSRadioButton() {
        this(nCreate());
    }

    public NSRadioButton(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets the name that specifies which RadioButton controls are mutually exclusive
     */
    public final String getGroupName() {
        return nGetGroupName(getPtr());
    }

    /**
     * Gets or sets the name that specifies which RadioButton controls are mutually exclusive
     */
    public final void setGroupName(final String name) {
        nSetGroupName(getPtr(), name);
    }

    private static native long nCreate();

    private static native String nGetGroupName(long ptr);

    private static native void nSetGroupName(long ptr, String value);
}
