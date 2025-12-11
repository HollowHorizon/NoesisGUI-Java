package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSDependencyObject;

/**
 * Represents a push button which reacts to the {@code Click} event.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.button.aspx">
 * Microsoft Documentation: Button Class</a>
 */
public class NSButton extends NSBaseButton {

    public static final NSDependencyObject IsCancelProperty = new NSDependencyObject(nIsCancelProperty());
    public static final NSDependencyObject IsDefaultProperty = new NSDependencyObject(nIsDefaultProperty());
    public static final NSDependencyObject IsDefaultedProperty = new NSDependencyObject(nIsDefaultedProperty());

    public NSButton() {
        this(nCreate());
    }

    public NSButton(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets a value that indicates whether a Button is a Cancel button. A user can
     * activate the Cancel button by pressing the *ESC* key
     */
    public final boolean getIsCancel() {
        return nGetIsCancel(getPtr());
    }

    /**
     * Gets or sets a value that indicates whether a Button is a Cancel button. A user can
     * activate the Cancel button by pressing the *ESC* key
     */
    public final void setIsCancel(final boolean value) {
        nSetIsCancel(getPtr(), value);
    }

    /**
     * Gets or sets a value that indicates whether a Button is the default button. A user invokes
     * the default button by pressing the *ENTER* key
     */
    public final boolean getIsDefault() {
        return nGetIsDefault(getPtr());
    }

    /**
     * Gets or sets a value that indicates whether a Button is the default button. A user invokes
     * the default button by pressing the *ENTER* key
     */
    public final void setIsDefault(final boolean value) {
        nSetIsDefault(getPtr(), value);
    }

    /**
     * Gets a value that indicates whether a Button is the button that is activated when a user
     * presses *ENTER* key
     */
    public final boolean getIsDefaulted() {
        return nGetIsDefaulted(getPtr());
    }

    private static native long nCreate();

    private static native boolean nGetIsCancel(long ptr);

    private static native void nSetIsCancel(long ptr, boolean value);

    private static native boolean nGetIsDefault(long ptr);

    private static native void nSetIsDefault(long ptr, boolean value);

    private static native boolean nGetIsDefaulted(long ptr);

    private static native long nIsCancelProperty();

    private static native long nIsDefaultProperty();

    private static native long nIsDefaultedProperty();
}
