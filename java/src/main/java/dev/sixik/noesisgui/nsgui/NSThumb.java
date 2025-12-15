package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nshandlers.NSDragCompletedEventHandler;
import dev.sixik.noesisgui.nshandlers.NSDragDeltaEventHandler;
import dev.sixik.noesisgui.nshandlers.NSDragStartedEventHandler;

/**
 * Represents a control that can be dragged by the user.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.primitives.thumb.aspx">
 * Microsoft Documentation: Thumb Class</a>
 */
public class NSThumb extends NSControl {

    public NSThumb() {
        this(nCreate());
    }

    public NSThumb(long ptr) {
        super(ptr);
    }

    /**
     * Gets whether the Thumb control has logical focus and mouse capture and the left mouse
     * button is pressed
     */
    public final boolean getIsDragging() {
        return nGetIsDragging(getPtr());
    }

    /**
     * Cancels current dragging operation
     */
    public final void cancelDrag() {
        nCancelDrag(getPtr());
    }

    /**
     * Occurs when the Thumb control loses mouse capture
     */
    public final void dragCompletedEvent(final NSDragCompletedEventHandler event) {
        nDragCompleted(getPtr(), event);
    }

    /**
     * Occurs one or more times as the mouse changes position when a Thumb control has logical
     * focus and mouse capture
     */
    public final void dragDeltaEvent(final NSDragDeltaEventHandler event) {
        nDragDelta(getPtr(), event);
    }

    /**
     * Occurs when a Thumb control receives logical focus and mouse capture
     */
    public final void dragStartedEvent(final NSDragStartedEventHandler event) {
        nDragStarted(getPtr(), event);
    }

    private static native long nCreate();

    private static native boolean nGetIsDragging(long ptr);

    private static native void nCancelDrag(long ptr);

    private static native void nDragCompleted(long ptr, NSDragCompletedEventHandler event);

    private static native void nDragDelta(long ptr, NSDragDeltaEventHandler event);

    private static native void nDragStarted(long ptr, NSDragStartedEventHandler event);
}
