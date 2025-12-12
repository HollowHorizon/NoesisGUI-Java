package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSDependencyObject;

/**
 * Defines an area where you can arrange child elements either horizontally or vertically,
 * relative to each other.
 * <p>
 * A DockPanel contains a collection of UIElement objects, which are in the Children property.
 * <p>
 * The SetDock method changes the position of an element relative to other elements within the same
 * container. Alignment properties, such as HorizontalAlignment, change the position of an element
 * relative to its parent element.
 * <p>
 * If you set the LastChildFill property to true, which is the default setting, the last child
 * element of a DockPanel always fills the remaining space, regardless of any other dock value
 * that you set on the last child element. To dock a child element in another direction, you must
 * set the LastChildFill property to false and must also specify an explicit dock direction for the
 * last child element.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.dockpanel.aspx">
 * Microsoft Documentation: DockPanel Class</a>
 */
public class NSDockPanel extends NSPanel {

    public NSDockPanel() {
        this(nCreate());
    }

    public NSDockPanel(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets a value that indicates the position of a child element within a DockPanel
     */
    public static NSGui_Dock getDock(final NSDependencyObject element) {
        return NSGui_Dock.values()[nGetDockStatic(element.getPtr())];
    }

    /**
     * Gets or sets a value that indicates the position of a child element within a DockPanel
     */
    public static void setDock(final NSDependencyObject element, final NSGui_Dock dock) {
        nSetDockStatic(element.getPtr(), dock.ordinal());
    }

    /**
     * Gets or sets a value that indicates whether the last child element within a DockPanel
     * stretches to fill the remaining available space
     */
    public final boolean getLastChildFill() {
        return nGetLastChildFill(getPtr());
    }

    /**
     * Gets or sets a value that indicates whether the last child element within a DockPanel
     * stretches to fill the remaining available space
     */
    public final void setLastChildFill(final boolean value) {
        nSetLastChildFill(getPtr(), value);
    }

    private static native long nCreate();

    private static native int nGetDockStatic(long element_ptr);

    private static native void nSetDockStatic(long element_ptr, int value);

    private static native boolean nGetLastChildFill(long ptr);

    private static native void nSetLastChildFill(long ptr, boolean value);
}
