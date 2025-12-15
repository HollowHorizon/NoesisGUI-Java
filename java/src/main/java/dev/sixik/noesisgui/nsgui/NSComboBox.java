package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSBaseComponent;

/**
 * Represents a selection control with a drop-down list that can be shown or hidden by clicking
 * the arrow on the control.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.combobox.aspx">
 * Microsoft Documentation: ComboBox Class</a>
 */
public class NSComboBox extends NSSelector {

    public NSComboBox() {
        this(nCreate());
    }

    public NSComboBox(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets a value that indicates whether the drop-down for a combo box is currently open
     */
    public final boolean getIsDropDownOpen() {
        return nGetIsDropDownOpen(getPtr());
    }

    /**
     * Gets or sets a value that indicates whether the drop-down for a combo box is currently open
     */
    public final void setIsDropDownOpen(final boolean value) {
        nSetIsDropDownOpen(getPtr(), value);
    }

    /**
     * Gets or sets a value that indicates whether the drop-down for a combo box is currently open
     */
    public final boolean getIsEditable() {
        return nGetIsEditable(getPtr());
    }

    /**
     * Gets or sets a value that enables or disables editing of text in text box of the ComboBox
     */
    public final void setIsEditable(final boolean value) {
        nSetIsEditable(getPtr(), value);
    }

    /**
     * Gets or sets a value that enables selection-only mode, in which the contents of the combo
     * box are selectable but not editable
     */
    public final boolean getIsReadOnly() {
        return nGetIsReadOnly(getPtr());
    }

    /**
     * Gets or sets a value that enables selection-only mode, in which the contents of the combo
     * box are selectable but not editable
     */
    public final void setIsReadOnly(final boolean value) {
        nSetIsReadOnly(getPtr(), value);
    }

    /**
     * Gets or sets the maximum height for a combo box drop-down
     */
    public final float getMaxDropDownHeight() {
        return nGetMaxDropDownHeight(getPtr());
    }

    /**
     * Gets or sets the maximum height for a combo box drop-down
     */
    public final void setMaxDropDownHeight(final float value) {
        nSetMaxDropDownHeight(getPtr(), value);
    }

    /**
     * Gets or sets the placeholder text
     */
    public final String getPlaceholder() {
        return nGetPlaceholder(getPtr());
    }

    /**
     * Gets or sets the placeholder text
     */
    public final void setPlaceholder(final String text) {
        nSetPlaceholder(getPtr(), text);
    }

    /**
     * Gets the item that is displayed in the selection box
     */
    public final NSBaseComponent getSelectionBoxItem() {
        return new NSBaseComponent(nGetSelectionBoxItem(getPtr()));
    }

    /**
     * Gets the item template of the selection box content
     */
    public final NSDataTemplate getSelectionBoxItemTemplate() {
        return new NSDataTemplate(nGetSelectionBoxItemTemplate(getPtr()));
    }

    /**
     * Gets or sets whether a ComboBox that is open and displays a drop-down control will remain
     * open when a user clicks the TextBox.
     */
    public final boolean getStaysOpenOnEdit() {
        return nGetStaysOpenOnEdit(getPtr());
    }

    /**
     * Gets or sets whether a ComboBox that is open and displays a drop-down control will remain
     * open when a user clicks the TextBox.
     */
    public final void setStaysOpenOnEdit(final boolean value) {
        nSetStaysOpenOnEdit(getPtr(), value);
    }

    /**
     * Gets or sets the text of the currently selected item
     */
    public final String getText() {
        return nGetText(getPtr());
    }

    /**
     * Gets or sets the text of the currently selected item
     */
    public final void setText(final String text) {
        nSetText(getPtr(), text);
    }

    /**
     * Causes the item to scroll into view. If it is not visible, it is aligned either at the
     * top or bottom of the viewport. Note this will only work if drop down is open.
     */
    public final void scrollIntoView(final NSBaseComponent component) {
        nScrollIntoView(getPtr(), component.getPtr());
    }

    private static native long nCreate();

    private static native boolean nGetIsDropDownOpen(long ptr);

    private static native void nSetIsDropDownOpen(long ptr, boolean value);

    private static native boolean nGetIsEditable(long ptr);

    private static native void nSetIsEditable(long ptr, boolean value);

    private static native boolean nGetIsReadOnly(long ptr);

    private static native void nSetIsReadOnly(long ptr, boolean value);

    private static native float nGetMaxDropDownHeight(long ptr);

    private static native void nSetMaxDropDownHeight(long ptr, float value);

    private static native String nGetPlaceholder(long ptr);

    private static native void nSetPlaceholder(long ptr, String value);

    private static native long nGetSelectionBoxItem(long ptr);

    private static native long nGetSelectionBoxItemTemplate(long ptr);

    private static native boolean nGetStaysOpenOnEdit(long ptr);

    private static native void nSetStaysOpenOnEdit(long ptr, boolean value);

    private static native String nGetText(long ptr);

    private static native void nSetText(long ptr, String value);

    private static native void nScrollIntoView(long ptr, long element_ptr);
}
