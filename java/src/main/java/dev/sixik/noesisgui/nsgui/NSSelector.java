package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSBaseComponent;
import dev.sixik.noesisgui.nscore.NSDependencyObject;
import dev.sixik.noesisgui.nshandlers.NSSelectionChangedEventHandler;

/**
 * Represents a control that allows a user to select items from among its child elements.
 * <p>
 * Selector is an ItemsControl, which means it can contain a collection of objects of any type
 * (such as string, image, or panel). For more information, see the ItemsControl class.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.primitives.selector.aspx">
 * Microsoft Documentation: Selector Class</a>
 */
public class NSSelector extends NSItemsControl {

    public NSSelector(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets a value that indicates whether an item is selected
     */
    public static boolean getIsSelected(final NSDependencyObject element) {
        return nGetIsSelectedStatic(element.getPtr());
    }

    /**
     * Gets or sets a value that indicates whether an item is selected
     */
    public static void setIsSelected(final NSDependencyObject element, final boolean value) {
        nSetIsSelectedStatic(element.getPtr(), value);
    }

    /**
     * Gets a value that indicates whether the keyboard focus is within the Selector
     */
    public static boolean getIsSelectionActive(final NSUIElement element) {
        return nGetIsSelectionActiveStatic(element.getPtr());
    }

    /**
     * Gets or sets a value that indicates whether a Selector should keep the SelectedItem
     * synchronized with the current item in the Items property.
     * Returns true if the *SelectedItem* is always synchronized with the current item in the
     * ItemCollection;  false if the *SelectedItem* is never synchronized with the current item;
     * or null if the *SelectedItem* is synchronized with the current item only if the Selector
     * uses a CollectionView. The default value is null
     */
    public final boolean getIsSynchronizedWithCurrentItem() {
        return nGetIsSynchronizedWithCurrentItem(getPtr());
    }

    /**
     * Gets or sets a value that indicates whether a Selector should keep the SelectedItem
     * synchronized with the current item in the Items property.
     * Returns true if the *SelectedItem* is always synchronized with the current item in the
     * ItemCollection;  false if the *SelectedItem* is never synchronized with the current item;
     * or null if the *SelectedItem* is synchronized with the current item only if the Selector
     * uses a CollectionView. The default value is null
     */
    public final void setIsSynchronizedWithCurrentItem(final boolean value) {
        nSetIsSynchronizedWithCurrentItem(getPtr(), value);
    }

    /**
     * Gets or sets the index of the first item in the current selection or returns negative one
     * (-1) if the selection is empty
     */
    public final int getSelectedIndex() {
        return nGetSelectedIndex(getPtr());
    }

    /**
     * Gets or sets the index of the first item in the current selection or returns negative one
     * (-1) if the selection is empty
     */
    public final void setSelectedIndex(final int index) {
        nSetSelectedIndex(getPtr(), index);
    }

    /**
     * Gets or sets the first item in the current selection or returns null if the selection is
     * empty
     */
    public final NSBaseComponent getSelectedItem() {
        return new NSBaseComponent(nGetSelectedItem(getPtr()));
    }

    /**
     * Gets or sets the first item in the current selection or returns null if the selection is
     * empty
     */
    public final void setSelectedItem(final NSBaseComponent component) {
        nSetSelectedItem(getPtr(), component.getPtr());
    }

    /**
     * Gets or sets the value of the *SelectedItem*, obtained by using *SelectedValuePath*
     */
    public final NSBaseComponent getSelectedValue() {
        return new NSBaseComponent(nGetSelectedValue(getPtr()));
    }

    /**
     * Gets or sets the value of the *SelectedItem*, obtained by using *SelectedValuePath*
     */
    public final void setSelectedValue(final NSBaseComponent selectedValue) {
        nSetSelectedValue(getPtr(), selectedValue.getPtr());
    }

    /**
     * Gets or sets the path that is used to get the *SelectedValue* from the *SelectedItem*
     */
    public final String getSelectedValuePath() {
        return nGetSelectedValuePath(getPtr());
    }

    /**
     * Gets or sets the path that is used to get the *SelectedValue* from the *SelectedItem*
     */
    public final void setSelectedValuePath(final String path) {
        nSetSelectedValuePath(getPtr(), path);
    }

    /**
     * Occurs when the selection of a Selector changes
     */
    public final void selectionChangedEvent(final NSSelectionChangedEventHandler event) {
        nSelectionChanged(getPtr(), event);
    }

    private static native boolean nGetIsSelectedStatic(long element_ptr);

    private static native void nSetIsSelectedStatic(long element_ptr, boolean value);

    private static native boolean nGetIsSelectionActiveStatic(long element_ptr);

    private static native boolean nGetIsSynchronizedWithCurrentItem(long ptr);

    private static native void nSetIsSynchronizedWithCurrentItem(long ptr, boolean value);

    private static native int nGetSelectedIndex(long ptr);

    private static native void nSetSelectedIndex(long ptr, int value);

    private static native long nGetSelectedItem(long ptr);

    private static native void nSetSelectedItem(long ptr, long element_ptr);

    private static native long nGetSelectedValue(long ptr);

    private static native void nSetSelectedValue(long ptr, long element_ptr);

    private static native String nGetSelectedValuePath(long ptr);

    private static native void nSetSelectedValuePath(long ptr, String value);

    private static native void nSelectionChanged(long ptr, NSSelectionChangedEventHandler event);
}
