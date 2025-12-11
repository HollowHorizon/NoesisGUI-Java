package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nshandlers.NSRoutedEventHandler;

/**
 * An abstract base class that provides functionality for text editing controls.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.primitives.textboxbase.aspx">
 * Microsoft Documentation: BaseTextBox Class</a>
 */
public class NSBaseTextBox extends NSControl {

    public NSBaseTextBox(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets a value that indicates how the text editing control responds when the user
     * presses the *ENTER* key.
     */
    public final boolean getAcceptsReturn() {
        return nGetAcceptsReturn(getPtr());
    }

    /**
     * Gets or sets a value that indicates how the text editing control responds when the user
     * presses the *ENTER* key.
     */
    public final void setAcceptsReturn(final boolean value) {
        nSetAcceptsReturn(getPtr(), value);
    }

    /**
     * Gets or sets a value that indicates how the text editing control responds when the user
     * presses the *TAB* key.
     */
    public final boolean getAcceptsTab() {
        return nGetAcceptsTab(getPtr());
    }

    /**
     * Gets or sets a value that indicates how the text editing control responds when the user
     * presses the *TAB* key.
     */
    public final void setAcceptsTab(final boolean value) {
        nSetAcceptsTab(getPtr(), value);
    }

    /**
     * Gets or sets the brush that is used to paint the caret of the text box
     */
    public final NSBrush getCaretBrush() {
        return new NSBrush(nGetCaretBrush(getPtr()));
    }

    /**
     * Gets or sets the brush that is used to paint the caret of the text box
     */
    public final void setCaretBrush(final NSBrush brush) {
        nSetCaretBrush(getPtr(), brush.getPtr());
    }

    /**
     * Gets or sets a value that indicates whether a horizontal scroll bar is shown
     */
    public final NSGui_ScrollBarVisibility getHorizontalScrollBarVisibility() {
        return NSGui_ScrollBarVisibility.values()[nGetHorizontalScrollBarVisibility(getPtr())];
    }

    /**
     * Gets or sets a value that indicates whether a horizontal scroll bar is shown
     */
    public final void setHorizontalScrollBarVisibility(final NSGui_ScrollBarVisibility visibility) {
        nSetHorizontalScrollBarVisibility(getPtr(), visibility.ordinal());
    }

    /**
     * Gets or sets a value that indicates whether the text editing control is read-only to a user
     * interacting with the control
     */
    public final boolean getIsReadOnly() {
        return nGetIsReadOnly(getPtr());
    }

    /**
     * Gets or sets a value that indicates whether the text editing control is read-only to a user
     * interacting with the control
     */
    public final void setIsReadOnly(final boolean value) {
        nSetIsReadOnly(getPtr(), value);
    }

    /**
     * Gets a value that indicates whether the text box has focus and selected text
     */
    public final boolean getIsSelectionActive() {
        return nGetIsSelectionActive(getPtr());
    }

    /**
     * Gets or sets the way TextBox reacts to touch manipulation
     */
    public final NSGui_PanningMode getPanningMode() {
        return NSGui_PanningMode.values()[nGetPanningMode(getPtr())];
    }

    /**
     * Gets or sets the way TextBox reacts to touch manipulation
     */
    public final void setPanningMode(final NSGui_PanningMode mode) {
        nSetPanningMode(getPtr(), mode.ordinal());
    }

    /**
     * Gets or sets the brush that highlights selected text
     */
    public final NSBrush getSelectionBrush() {
        return new NSBrush(nGetSelectionBrush(getPtr()));
    }

    /**
     * Gets or sets the brush that highlights selected text
     */
    public final void setSelectionBrush(final NSBrush brush) {
        nSetSelectionBrush(getPtr(), brush.getPtr());
    }

    /**
     * Gets or sets the opacity of the *SelectionBrush*. If *SelectionOpacity* is set to 0, the
     * *SelectionBrush* is transparent and is not visible. If *SelectionOpacity* is set to 1.0 or
     * greater, the *SelectionBrush* is opaque and the selected text is not visible
     */
    public final float getSelectionOpacity() {
        return nGetSelectionOpacity(getPtr());
    }

    /**
     * Gets or sets the opacity of the *SelectionBrush*. If *SelectionOpacity* is set to 0, the
     * *SelectionBrush* is transparent and is not visible. If *SelectionOpacity* is set to 1.0 or
     * greater, the *SelectionBrush* is opaque and the selected text is not visible
     */
    public final void setSelectionOpacity(final float opacity) {
        nSetSelectionOpacity(getPtr(), opacity);
    }

    /**
     * Gets or sets a value that indicates whether a vertical scroll bar is shown
     */
    public final NSGui_ScrollBarVisibility getVerticalScrollBarVisibility() {
        return NSGui_ScrollBarVisibility.values()[nGetVerticalScrollBarVisibility(getPtr())];
    }

    /**
     * Gets or sets a value that indicates whether a vertical scroll bar is shown
     */
    public final void setVerticalScrollBarVisibility(final NSGui_ScrollBarVisibility visibility) {
        nSetVerticalScrollBarVisibility(getPtr(), visibility.ordinal());
    }

    /**
     * Horizontal size of scrollable content; 0.0 if TextBox is non-scrolling
     */
    public final float getExtentWidth() {
        return nGetExtentWidth(getPtr());
    }

    /**
     * Vertical size of scrollable content; 0.0 if TextBox is non-scrolling
     */
    public final float getExtentHeight() {
        return nGetExtentHeight(getPtr());
    }

    /**
     * Horizontal size of scroll area; 0.0 if TextBox is non-scrolling
     */
    public final float getViewportWidth() {
        return nGetViewportWidth(getPtr());
    }

    /**
     * Vertical size of scroll area; 0.0 if TextBox is non-scrolling
     */
    public final float getViewportHeight() {
        return nGetViewportHeight(getPtr());
    }

    /**
     * Actual HorizontalOffset contains the ScrollViewer's current horizontal offset.
     * This is a computed value, depending on the state of ScrollViewer, its Viewport, Extent
     * and previous scrolling commands.
     */
    public final float getHorizontalOffset() {
        return nGetHorizontalOffset(getPtr());
    }

    /**
     * Actual VerticalOffset contains the ScrollViewer's current vertical offset.
     * This is a computed value, depending on the state of ScrollViewer, its Viewport, Extent
     * and previous scrolling commands.
     */
    public final float getVerticalOffset() {
        return nGetVerticalOffset(getPtr());
    }

    /**
     * Scroll content by one line to the left.
     */
    public final void lineLeft() {
        nLineLeft(getPtr());
    }

    /**
     * Scroll content by one line to the right.
     */
    public final void lineRight() {
        nLineRight(getPtr());
    }

    /**
     * Scroll content by one page to the left.
     */
    public final void pageLeft() {
        nPageLeft(getPtr());
    }

    /**
     * Scroll content by one page to the right.
     */
    public final void pageRight() {
        nPageRight(getPtr());
    }

    /**
     * Scroll content by one line to the top.
     */
    public final void lineUp() {
        nLineUp(getPtr());
    }

    /**
     * Scroll content by one line to the bottom.
     */
    public final void lineDown() {
        nLineDown(getPtr());
    }

    /**
     * Scroll content by one page to the top.
     */
    public final void pageUp() {
        nPageUp(getPtr());
    }

    /**
     * Scroll content by one page to the bottom.
     */
    public final void pageDown() {
        nPageDown(getPtr());
    }

    /**
     * Vertically scroll to the beginning of the content.
     */
    public final void scrollToHome() {
        nScrollToHome(getPtr());
    }

    /**
     * Vertically scroll to the end of the content.
     */
    public final void scrollToEnd() {
        nScrollToEnd(getPtr());
    }

    /**
     * Scroll horizontally to the specified offset.
     */
    public final void scrollToHorizontalOffset(final float offset) {
        nScrollToHorizontalOffset(getPtr(), offset);
    }

    /**
     * Scroll vertically to the specified offset.
     */
    public final void scrollToVerticalOffset(final float offset) {
        nScrollToVerticalOffset(getPtr(), offset);
    }

    /**
     * Occurs when the text selection has changed
     */
    public final void selectionChangedEvent(final NSRoutedEventHandler event) {
        nSelectionChanged(getPtr(), event);
    }

    /**
     * Occurs when content changes in the text element
     */
    public final void textChangedEvent(final NSRoutedEventHandler event) {
        nTextChanged(getPtr(), event);
    }

    private static native boolean nGetAcceptsReturn(long ptr);

    private static native void nSetAcceptsReturn(long ptr, boolean value);

    private static native boolean nGetAcceptsTab(long ptr);

    private static native void nSetAcceptsTab(long ptr, boolean value);

    private static native long nGetCaretBrush(long ptr);

    private static native void nSetCaretBrush(long ptr, long brush_ptr);

    private static native int nGetHorizontalScrollBarVisibility(long ptr);

    private static native void nSetHorizontalScrollBarVisibility(long ptr, int ordinal);

    private static native boolean nGetIsReadOnly(long ptr);

    private static native void nSetIsReadOnly(long ptr, boolean value);

    private static native boolean nGetIsSelectionActive(long ptr);

    private static native int nGetPanningMode(long ptr);

    private static native void nSetPanningMode(long ptr, int value);

    private static native long nGetSelectionBrush(long ptr);

    private static native void nSetSelectionBrush(long ptr, long brush_ptr);

    private static native float nGetSelectionOpacity(long ptr);

    private static native void nSetSelectionOpacity(long ptr, float value);

    private static native int nGetVerticalScrollBarVisibility(long ptr);

    private static native void nSetVerticalScrollBarVisibility(long ptr, int value);

    private static native float nGetExtentWidth(long ptr);

    private static native float nGetExtentHeight(long ptr);

    private static native float nGetViewportWidth(long ptr);

    private static native float nGetViewportHeight(long ptr);

    private static native float nGetHorizontalOffset(long ptr);

    private static native float nGetVerticalOffset(long ptr);

    private static native void nLineLeft(long ptr);

    private static native void nLineRight(long ptr);

    private static native void nPageLeft(long ptr);

    private static native void nPageRight(long ptr);

    private static native void nLineUp(long ptr);

    private static native void nLineDown(long ptr);

    private static native void nPageUp(long ptr);

    private static native void nPageDown(long ptr);

    private static native void nScrollToHome(long ptr);

    private static native void nScrollToEnd(long ptr);

    private static native void nScrollToVerticalOffset(long ptr, float offset);

    private static native void nScrollToHorizontalOffset(long ptr, float offset);

    private static native void nSelectionChanged(long ptr, NSRoutedEventHandler event);

    private static native void nTextChanged(long ptr, NSRoutedEventHandler event);
}
