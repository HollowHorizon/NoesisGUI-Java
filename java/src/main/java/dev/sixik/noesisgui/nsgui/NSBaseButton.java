package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSBaseComponent;
import dev.sixik.noesisgui.nscore.NSICommand;
import dev.sixik.noesisgui.nshandlers.NSRoutedEventHandler;

/**
 * Represents the base class for all button controls.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.primitives.buttonbase.aspx">
 *      Microsoft Documentation: ButtonBase Class</a>
 */
public class NSBaseButton extends NSContentControl{

    public NSBaseButton(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets when the Click event occurs
     */
    public final NSGui_ClickMode getClickMode() {
        return NSGui_ClickMode.values()[nGetClickMode(getPtr())];
    }

    /**
     * Gets or sets when the Click event occurs
     */
    public final void setClickMode(final NSGui_ClickMode mode) {
        nSetClickMode(getPtr(), mode.ordinal());
    }

    /**
     * Gets or sets the command to invoke when this button is pressed
     */
    public final NSICommand getCommand() {
        return new NSICommand(nGetCommand(getPtr()));
    }

    /**
     * Gets or sets the command to invoke when this button is pressed
     */
    public final void setCommand(final NSICommand command) {
        nSetCommand(getPtr(), command.getPtr());
    }

    /**
     * Gets or sets the parameter to pass to the Command property
     */
    public final void setCommandParameter(final NSBaseComponent param) {
        nSetCommandParameter(getPtr(), param.getPtr());
    }

    /**
     * Gets or sets the element on which to raise the specified command
     */
    public final void setCommandTarget(final NSUIElement target) {
        nSetCommandTarget(getPtr(), target.getPtr());
    }

    /**
     * Gets a value that indicates whether a button is currently activated
     */
    public final boolean getIsPressed() {
        return nGetIsPressed(getPtr());
    }

    /**
     * Occurs when a Button is clicked
     */
    public final void clickEvent(final NSRoutedEventHandler event) {
        nClick(getPtr(), event);
    }

    private static native int nGetClickMode(long ptr);

    private static native void nSetClickMode(long ptr, int value);

    private static native long nGetCommand(long ptr);

    private static native void nSetCommand(long ptr, long command_ptr);

    private static native void nSetCommandParameter(long ptr, long param_ptr);

    private static native void nSetCommandTarget(long ptr, long target_ptr);

    private static native boolean nGetIsPressed(long ptr);

    private static native void nClick(long ptr, NSRoutedEventHandler event);
}
