package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSBaseComponent;

/**
 * Contains a list of selectable items.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.listbox.aspx">
 * Microsoft Documentation: ListBox Class</a>
 */
public class NSListBox extends NSSelector {

    public NSListBox() {
        this(nCreate());
    }

    public NSListBox(long ptr) {
        super(ptr);
    }

    /**
     * Gets a list of the currently selected items
     */
    public final NSSelectedItemsCollection getSelectedItems() {
        return new NSSelectedItemsCollection(nGetSelectedItems(getPtr()));
    }

    /**
     * Gets or sets the selection behavior for a ListBox
     */
    public final NSGui_SelectionMode getSelectionMode() {
        return NSGui_SelectionMode.values()[nGetSelectionMode(getPtr())];
    }

    /**
     * Gets or sets the selection behavior for a ListBox
     */
    public final void setSelectionMode(final NSGui_SelectionMode mode) {
        nSetSelectionMode(getPtr(), mode.ordinal());
    }

    /**
     * Selects all the items
     */
    public final void selectAll() {
        nSelectAll(getPtr());
    }

    /**
     * Clears all of the selected items
     */
    public final void unselectAll() {
        nUnselectAll(getPtr());
    }

    /**
     * Causes the item to scroll into view. If it is not visible, it is aligned either at the
     * top or bottom of the viewport
     */
    public final void scrollIntoView(final NSBaseComponent item) {
        nScrollIntoView(getPtr(), item.getPtr());
    }

    private static native long nCreate();

    private static native long nGetSelectedItems(long ptr);

    private static native int nGetSelectionMode(long ptr);

    private static native void nSetSelectionMode(long ptr, int value);

    private static native void nSelectAll(long ptr);

    private static native void nUnselectAll(long ptr);

    private static native void nScrollIntoView(long ptr, long element_ptr);
}
