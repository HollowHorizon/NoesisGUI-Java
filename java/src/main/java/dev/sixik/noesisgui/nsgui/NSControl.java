package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nshandlers.NSMouseButtonEventHandler;

public class NSControl extends NSFrameworkElement {

    public NSControl(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets a Brush that describes the background of a control
     */
    public final NSBrush getBackground() {
        return new NSBrush(nGetBackground(getPtr()));
    }

    /**
     * Gets or sets a Brush that describes the background of a control
     */
    public final void setBackground(final NSBrush brush) {
        nSetBackground(getPtr(), brush.getPtr());
    }

    /**
     * Gets or sets a Brush that describes the border of a control
     */
    public final NSBrush getBorderBrush() {
        return new NSBrush(nGetBorderBrush(getPtr()));
    }

    /**
     * Gets or sets a Brush that describes the border of a control
     */
    public final void setBorderBrush(final NSBrush brush) {
        nSetBorderBrush(getPtr(), brush.getPtr());
    }

    /**
     * Gets or sets the border Thickness of a control
     */
    public final NSThickness getBorderThickness() {
        final NSThickness thickness = new NSThickness();
        getBorderThickness(thickness);
        return thickness;
    }

    /**
     * Gets or sets the border Thickness of a control
     */
    public final void getBorderThickness(final NSThickness out) {
        nGetBorderThickness(getPtr(), out);
    }

    /**
     * Gets or sets the border Thickness of a control
     */
    public final void setBorderThickness(final NSThickness thickness) {
        nSetBorderThickness(getPtr(), thickness);
    }

    /**
     * Gets or sets the FontFamily of the control
     */
    public final NSFontFamily getFontFamily() {
        return new NSFontFamily(nGetFontFamily(getPtr()));
    }

    /**
     * Gets or sets the FontFamily of the control
     */
    public final void setFontFamily(final NSFontFamily family) {
        nSetFontFamily(getPtr(), family.getPtr());
    }

    /**
     * Gets or sets the font size
     */
    public final float getFontSize() {
        return nGetFontSize(getPtr());
    }

    /**
     * Gets or sets the font size
     */
    public final void setFontSize(final float size) {
        nSetFontSize(getPtr(), size);
    }

    /**
     * Gets or sets the FontStretch
     */
    public final NSGui_FontStretch getFontStretch() {
        return NSGui_FontStretch.values()[nGetFontStretch(getPtr())];
    }

    /**
     * Gets or sets the FontStretch
     */
    public final void setFontStretch(final NSGui_FontStretch stretch) {
        nSetFontStretch(getPtr(), stretch.ordinal());
    }

    /**
     * Gets or sets the FontStyle
     */
    public final NSGui_FontStyle getFontStyle() {
        return NSGui_FontStyle.values()[nGetFontStyle(getPtr())];
    }

    /**
     * Gets or sets the FontStyle
     */
    public final void setFontStyle(final NSGui_FontStyle style) {
        nSetFontStyle(getPtr(), style.ordinal());
    }

    /**
     * Gets or sets the FontWeight or thickness of the specified font
     */
    public final NSGui_FontWeight getFontWeight() {
        return NSGui_FontWeight.get(nGetFontWeight(getPtr()));
    }

    /**
     * Gets or sets the FontWeight or thickness of the specified font
     */
    public final void setFontWeight(final NSGui_FontWeight weight) {
        nSetFontWeight(getPtr(), weight.value);
    }

    /**
     * Gets or sets a Brush that describes the foreground color
     */
    public final NSBrush getForeground() {
        return new NSBrush(nGetForeground(getPtr()));
    }

    /**
     * Gets or sets a Brush that describes the foreground color
     */
    public final void setForeground(final NSBrush brush) {
        nSetForeground(getPtr(), brush.getPtr());
    }

    /**
     * Gets or sets the HorizontalAlignment of a control's content
     */
    public final NSGui_HorizontalAlignment getHorizontalContentAlignment() {
        return NSGui_HorizontalAlignment.values()[nGetHorizontalContentAlignment(getPtr())];
    }

    /**
     * Gets or sets the HorizontalAlignment of a control's content
     */
    public final void setHorizontalContentAlignment(final NSGui_HorizontalAlignment alignment) {
        nSetHorizontalContentAlignment(getPtr(), alignment.ordinal());
    }

    /**
     * Gets or sets a value that indicates whether a control is included in tab navigation.
     */
    public final boolean getIsTabStop() {
        return nGetIsTabStop(getPtr());
    }

    /**
     * Gets or sets a value that indicates whether a control is included in tab navigation.
     */
    public final void setIsTabStop(final boolean value) {
        nSetIsTabStop(getPtr(), value);
    }

    /**
     * Gets or sets the padding inside a control
     */
    public final NSThickness getPadding() {
        final NSThickness thickness = new NSThickness();
        getPadding(thickness);
        return thickness;
    }

    /**
     * Gets or sets the padding inside a control
     */
    public final void getPadding(final NSThickness thickness) {
        nGetPadding(getPtr(), thickness);
    }

    /**
     * Gets or sets the padding inside a control
     */
    public final void setPadding(final NSThickness thickness) {
        nSetPadding(getPtr(), thickness);
    }

    /**
     * Gets or sets a value that determines the order in which elements receive focus when the
     * user navigates through controls by using the TAB key.
     */
    public final int getTabIndex() {
        return nGetTabIndex(getPtr());
    }

    /**
     * Gets or sets a value that determines the order in which elements receive focus when the
     * user navigates through controls by using the TAB key.
     */
    public final void setTabIndex(final int value) {
        nSetTabIndex(getPtr(), value);
    }

    /**
     * Gets or sets ControlTemplate for this element
     */
    public final NSControlTemplate getTemplate() {
        return new NSControlTemplate(nGetTemplate(getPtr()));
    }

    /**
     * Gets or sets ControlTemplate for this element
     */
    public final void setTemplate(final NSControlTemplate template) {
        nSetTemplate(getPtr(), template.getPtr());
    }

    /**
     * Gets or sets the VerticalAlignment of a control's content
     */
    public final NSGui_VerticalAlignment getVerticalContentAlignment() {
        return NSGui_VerticalAlignment.values()[nGetVerticalContentAlignment(getPtr())];
    }

    /**
     * Gets or sets the VerticalAlignment of a control's content
     */
    public final void setVerticalContentAlignment(final NSGui_VerticalAlignment alignment) {
        nSetVerticalContentAlignment(getPtr(), alignment.ordinal());
    }

    /**
     * Get or sets a value that indicates whether focus is constrained within the control
     * boundaries (for game pad/remote interaction)
     */
    public final boolean getIsFocusEngaged() {
        return nGetIsFocusEngaged(getPtr());
    }

    /**
     * Get or sets a value that indicates whether focus is constrained within the control
     * boundaries (for game pad/remote interaction)
     */
    public final void setIsFocusEngaged(final boolean value) {
        nSetIsFocusEngaged(getPtr(), value);
    }

    /**
     * Get or sets a value that indicates whether focus can be constrained within the control
     * boundaries (for game pad / remote interaction)
     */
    public final boolean getIsFocusEngagementEnabled() {
        return nGetIsFocusEngagementEnabled(getPtr());
    }

    /**
     * Get or sets a value that indicates whether focus can be constrained within the control
     * boundaries (for game pad / remote interaction)
     */
    public final void setIsFocusEngagementEnabled(final boolean value) {
        nSetIsFocusEngagementEnabled(getPtr(), value);
    }

    /**
     * Indicates if this control is using focus engagement. For internal use only.
     */
    public final boolean getUsingFocusEngagement() {
        return nGetUsingFocusEngagement(getPtr());
    }

    /**
     * Indicates if this control is using focus engagement. For internal use only.
     */
    public final void setUsingFocusEngagement(final boolean value) {
        nSetUsingFocusEngagement(getPtr(), value);
    }

    /**
     * Gets or sets the object that gets focus when a user presses Left direction on a keyboard or
     * a controller. Setting this property overrides default directional navigation behavior
     */
    public final NSUIElement getXYFocusLeft() {
        return new NSUIElement(nGetXYFocusLeft(getPtr()));
    }

    /**
     * Gets or sets the object that gets focus when a user presses Left direction on a keyboard or
     * a controller. Setting this property overrides default directional navigation behavior
     */
    public final void setXYFocusLeft(final NSUIElement element) {
        nSetXYFocusLeft(getPtr(), element.getPtr());
    }

    /**
     * Gets or sets the object that gets focus when a user presses Right direction on a keyboard or
     * a controller. Setting this property overrides default directional navigation behavior
     */
    public final NSUIElement getXYFocusRight() {
        return new NSUIElement(nGetXYFocusRight(getPtr()));
    }

    /**
     * Gets or sets the object that gets focus when a user presses Right direction on a keyboard or
     * a controller. Setting this property overrides default directional navigation behavior
     */
    public final void setXYFocusRight(final NSUIElement element) {
        nSetXYFocusRight(getPtr(), element.getPtr());
    }

    /**
     * Gets or sets the object that gets focus when a user presses Up direction on a keyboard or a
     * controller. Setting this property overrides default directional navigation behavior
     */
    public final NSUIElement getXYFocusUp() {
        return new NSUIElement(nGetXYFocusUp(getPtr()));
    }

    /**
     * Gets or sets the object that gets focus when a user presses Up direction on a keyboard or a
     * controller. Setting this property overrides default directional navigation behavior
     */
    public final void setXYFocusUp(final NSUIElement element) {
        nSetXYFocusUp(getPtr(), element.getPtr());
    }

    /**
     * Gets or sets the object that gets focus when a user presses Down direction on a keyboard or
     * a controller. Setting this property overrides default directional navigation behavior
     */
    public final NSUIElement getXYFocusDown() {
        return new NSUIElement(nGetXYFocusDown(getPtr()));
    }

    /**
     * Gets or sets the object that gets focus when a user presses Down direction on a keyboard or
     * a controller. Setting this property overrides default directional navigation behavior
     */
    public final void setXYFocusDown(final NSUIElement element) {
        nSetXYFocusDown(getPtr(), element.getPtr());
    }

    /**
     * Occurs when a mouse button is clicked two or more times
     */
    public final void mouseDoubleClickEvent(final NSMouseButtonEventHandler event) {
        nMouseDoubleClick(getPtr(), event);
    }

    /**
     * Occurs when a user clicks the mouse button two or more times
     */
    public final void previewMouseDoubleClickEvent(final NSMouseButtonEventHandler event) {
        nPreviewMouseDoubleClick(getPtr(), event);
    }

    private static native long nGetBackground(long ptr);

    private static native void nSetBackground(long ptr, long brush_ptr);

    private static native long nGetBorderBrush(long ptr);

    private static native void nSetBorderBrush(long ptr, long brush_ptr);

    private static native void nGetBorderThickness(long ptr, NSThickness thickness);

    private static native void nSetBorderThickness(long ptr, NSThickness thickness);

    private static native long nGetFontFamily(long ptr);

    private static native void nSetFontFamily(long ptr, long family_ptr);

    private static native float nGetFontSize(long ptr);

    private static native void nSetFontSize(long ptr, float size);

    private static native int nGetFontStretch(long ptr);

    private static native void nSetFontStretch(long ptr, int value);

    private static native int nGetFontStyle(long ptr);

    private static native void nSetFontStyle(long ptr, int ordinal);

    private static native int nGetFontWeight(long ptr);

    private static native void nSetFontWeight(long ptr, int value);

    private static native long nGetForeground(long ptr);

    private static native void nSetForeground(long ptr, long brush_ptr);

    private static native int nGetHorizontalContentAlignment(long ptr);

    private static native void nSetHorizontalContentAlignment(long ptr, int ordinal);

    private static native boolean nGetIsTabStop(long ptr);

    private static native void nSetIsTabStop(long ptr, boolean value);

    private static native void nGetPadding(long ptr, NSThickness thickness);

    private static native void nSetPadding(long ptr, NSThickness thickness);

    private static native int nGetTabIndex(long ptr);

    private static native void nSetTabIndex(long ptr, int value);

    private static native long nGetTemplate(long ptr);

    private static native void nSetTemplate(long ptr, long controlTemplate_ptr);

    private static native int nGetVerticalContentAlignment(long ptr);

    private static native void nSetVerticalContentAlignment(long ptr, int value);

    private static native boolean nGetIsFocusEngaged(long ptr);

    private static native void nSetIsFocusEngaged(long ptr, boolean value);

    private static native boolean nGetIsFocusEngagementEnabled(long ptr);

    private static native void nSetIsFocusEngagementEnabled(long ptr, boolean value);

    private static native boolean nGetUsingFocusEngagement(long ptr);

    private static native void nSetUsingFocusEngagement(long ptr, boolean value);

    private static native long nGetXYFocusLeft(long ptr);

    private static native void nSetXYFocusLeft(long ptr, long element_ptr);

    private static native long nGetXYFocusRight(long ptr);

    private static native void nSetXYFocusRight(long ptr, long element_ptr);

    private static native long nGetXYFocusUp(long ptr);

    private static native void nSetXYFocusUp(long ptr, long element_ptr);

    private static native long nGetXYFocusDown(long ptr);

    private static native void nSetXYFocusDown(long ptr, long element_ptr);

    private static native void nMouseDoubleClick(long ptr, NSMouseButtonEventHandler event);

    private static native void nPreviewMouseDoubleClick(long ptr, NSMouseButtonEventHandler event);
}
