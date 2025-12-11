package dev.sixik.noesisgui.nsgui;

/**
 * Represents a control that raises its *Click* event repeatedly from the time it is pressed until
 * it is released.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.primitives.repeatbutton.aspx">
 *      Microsoft Documentation: RepeatButton Class</a>
 */
public class NSRepeatButton extends NSBaseButton{

    public NSRepeatButton() {
        this(nCreate());
    }

    public NSRepeatButton(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets the amount of time, in milliseconds, the RepeatButton waits while it is
     * pressed before it starts repeating. The value must be non-negative
     */
    public final int getDelay() {
        return nGetDelay(getPtr());
    }

    /**
     * Gets or sets the amount of time, in milliseconds, the RepeatButton waits while it is
     * pressed before it starts repeating. The value must be non-negative
     */
    public final void setDelay(final int delay) {
        nSetDelay(getPtr(), delay);
    }

    /**
     * Gets or sets the amount of time, in milliseconds, between repeats once repeating starts.
     * The value must be non-negative
     */
    public final int getInterval() {
        return nGetInterval(getPtr());
    }

    /**
     * Gets or sets the amount of time, in milliseconds, between repeats once repeating starts.
     * The value must be non-negative
     */
    public final void setInterval(final int value) {
        nSetInterval(getPtr(), value);
    }

    private static native long nCreate();

    private static native int nGetDelay(long ptr);

    private static native void nSetDelay(long ptr, int value);

    private static native int nGetInterval(long ptr);

    private static native void nSetInterval(long ptr, int value);
}
