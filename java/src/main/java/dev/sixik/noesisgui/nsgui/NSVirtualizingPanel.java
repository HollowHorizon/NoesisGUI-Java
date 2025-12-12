package dev.sixik.noesisgui.nsgui;

/**
 * Base class that provides access to information that is useful for implementing virtualization.
 * <p>
 * In this context, "virtualize" refers to a technique by which a subset of user interface (UI)
 * elements are generated from a larger number of data items based on which items are visible on
 * the screen. It is intensive, both in terms of memory and processor, to generate a large number
 * of UI elements when only a few may be on the screen at a given time. A panel that inherits from
 * VirtualizingPanel, such as the VirtualizingStackPanel, calculates visible items and works with
 * the ItemContainerGenerator from an ItemsControl (such as ListBox or ListView) to only create UI
 * elements for visible items.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.virtualizingpanel.aspx">
 *      Microsoft Documentation: VirtualizingPanel Class</a>
 */
public class NSVirtualizingPanel extends NSPanel {

    //TODO

    public NSVirtualizingPanel(long ptr) {
        super(ptr);
    }
}
