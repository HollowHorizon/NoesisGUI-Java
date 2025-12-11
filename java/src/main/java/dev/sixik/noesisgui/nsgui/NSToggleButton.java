package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nshandlers.NSRoutedEventHandler;

/**
 * Base class for button controls that can switch states.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.primitives.togglebutton.aspx#inheritanceContinued">
 * Microsoft Documentation: ToggleButton Class</a>
 */
public class NSToggleButton extends NSBaseButton {

    public NSToggleButton() {
        this(nCreate());
    }

    public NSToggleButton(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets whether the ToggleButton is checked.
     */
    public final boolean getIsChecked() {
        return nGetIsChecked(getPtr());
    }

    /**
     * Gets or sets whether the ToggleButton is checked.
     */
    public final void setIsChecked(final boolean value) {
        nSetIsChecked(getPtr(), value);
    }

    /**
     * Determines whether the control supports two or three states
     */
    public final boolean getIsThreeState() {
        return nGetIsThreeState(getPtr());
    }

    /**
     * Determines whether the control supports two or three states
     */
    public final void setIsThreeState(final boolean value) {
        nSetIsThreeState(getPtr(), value);
    }

    /**
     * Occurs when a ToggleButton is checked.
     */
    public final void checkedEvent(final NSRoutedEventHandler event) {
        nChecked(getPtr(), event);
    }

    /**
     * Occurs when the state of a ToggleButton is neither on nor off.
     */
    public final void indeterminateEvent(final NSRoutedEventHandler event) {
        nIndeterminate(getPtr(), event);
    }

    /**
     * Occurs when a ToggleButton is unchecked.
     */
    public final void uncheckedEvent(final NSRoutedEventHandler event) {
        nUnchecked(getPtr(), event);
    }

    private static native long nCreate();

    private static native boolean nGetIsChecked(long ptr);

    private static native void nSetIsChecked(long ptr, boolean value);

    private static native boolean nGetIsThreeState(long ptr);

    private static native void nSetIsThreeState(long ptr, boolean value);

    private static native void nChecked(long ptr, NSRoutedEventHandler event);

    private static native void nIndeterminate(long ptr, NSRoutedEventHandler event);

    private static native void nUnchecked(long ptr, NSRoutedEventHandler event);
}
