package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nsdrawing.NSPoint;
import dev.sixik.noesisgui.nsdrawing.NSRect;

/**
 * Represents a control that can be used to display or edit unformatted text.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.textbox.aspx">
 * Microsoft Documentation: TextBox Class</a>
 */
public class NSTextBox extends NSBaseTextBox {

    public NSTextBox() {
        this(nCreate());
    }

    public NSTextBox(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets the insertion position index of the caret
     */
    public final int getCaretIndex() {
        return nGetCaretIndex(getPtr());
    }

    /**
     * Gets or sets the insertion position index of the caret
     */
    public final void setCaretIndex(final int value) {
        nSetCaretIndex(getPtr(), value);
    }

    /**
     * Gets or sets the maximum number of characters that can be manually entered into the text box
     */
    public final int getMaxLength() {
        return nGetMaxLength(getPtr());
    }

    /**
     * Gets or sets the maximum number of characters that can be manually entered into the text box
     */
    public final void setMaxLength(final int value) {
        nSetMaxLength(getPtr(), value);
    }

    /**
     * Gets or sets the maximum number of visible lines
     */
    public final int getMaxLines() {
        return nGetMaxLines(getPtr());
    }

    /**
     * Gets or sets the maximum number of visible lines
     */
    public final void setMaxLines(final int value) {
        nSetMaxLines(getPtr(), value);
    }

    /**
     * Gets or sets the minimum number of visible lines
     */
    public final int getMinLines() {
        return nGetMinLines(getPtr());
    }

    /**
     * Gets or sets the minimum number of visible lines
     */
    public final void setMinLines(final int lines) {
        nSetMinLines(getPtr(), lines);
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
     * Gets or sets the content of the current selection in the text box.
     * <p>
     * <b>Note:</b> Returned string must be copied because it will be invalidated next time you
     * interact with the text box.
     */
    public final String getSelectedText() {
        return nGetSelectedText(getPtr());
    }

    /**
     * Gets or sets the content of the current selection in the text box.
     * <p>
     * <b>Note:</b> Returned string must be copied because it will be invalidated next time you
     * interact with the text box.
     */
    public final void setSelectedText(final String text) {
        nSetSelectedText(getPtr(), text);
    }

    /**
     * Gets or sets a value indicating the number of characters in the current selection in the
     * text box
     */
    public final int getSelectionLength() {
        return nGetSelectionLength(getPtr());
    }

    /**
     * Gets or sets a value indicating the number of characters in the current selection in the
     * text box
     */
    public final void setSelectionLength(final int length) {
        nSetSelectionLength(getPtr(), length);
    }

    /**
     * Gets or sets a character index for the beginning of the current selection
     */
    public final int getSelectionStart() {
        return nGetSelectionStart(getPtr());
    }

    /**
     * Gets or sets a character index for the beginning of the current selection
     */
    public final void setSelectionStart(final int pos) {
        nSetSelectionStart(getPtr(), pos);
    }

    /**
     * Selects all text
     */
    public final void selectAll() {
        nSelectAll(getPtr());
    }

    /**
     * Select the text in the given position and length
     */
    public final void select(final int start, final int length) {
        nSelect(getPtr(), start, length);
    }

    /**
     * Clear all the content in the TextBox control
     */
    public final void clear() {
        nClear(getPtr());
    }

    /**
     * Return the 0-based character index of the given point.  If there is no character
     * at that point and snapToText is false, return -1. Point is specified in TextBox coordinates
     */
    public final int getCharacterIndexFromPoint(final NSPoint point, final boolean snapToText) {
        return nGetCharacterIndexFromPoint(getPtr(), point, snapToText);
    }

    /**
     * Return the 0-based character index of the first character of lineIndex, or -1 if no layout
     * information is available
     */
    public final int getCharacterIndexFromLineIndex(final int lineIndex) {
        return nGetCharacterIndexFromLineIndex(getPtr(), lineIndex);
    }

    /**
     * Return the 0-based index of the line containing the given character index, or -1 if no
     * layout information is available
     */
    public final int getLineIndexFromCharacterIndex(final int charIndex) {
        return nGetLineIndexFromCharacterIndex(getPtr(), charIndex);
    }

    /**
     * Return the number of characters in the given line, or -1 if no
     * layout information is available
     */
    public final int getLineLength(final int lineIndex) {
        return nGetLineLength(getPtr(), lineIndex);
    }

    /**
     * Return the index of the first line that is currently visible in the TextBox, or -1 if no
     * layout information is available
     */
    public final int getFirstVisibleLineIndex() {
        return nGetFirstVisibleLineIndex(getPtr());
    }

    /**
     * Return the index of the last line that is currently visible in the TextBox, or -1 if no
     * layout information is available
     */
    public final int getLastVisibleLineIndex() {
        return nGetLastVisibleLineIndex(getPtr());
    }

    /**
     * Scroll the minimal amount necessary to bring the given line into full view.
     */
    public final void scrollToLine(final int lineIndex) {
        nScrollToLine(getPtr(), lineIndex);
    }

    /**
     * Gets or sets the horizontal alignment of the contents of the text box
     */
    public final NSGui_TextAlignment getTextAlignment() {
        return NSGui_TextAlignment.values()[nGetTextAlignment(getPtr())];
    }

    /**
     * Gets or sets the horizontal alignment of the contents of the text box
     */
    public final void setTextAlignment(final NSGui_TextAlignment alignment) {
        nSetTextAlignment(getPtr(), alignment.ordinal());
    }

    /**
     * Gets or sets the text contents of the text box
     */
    public final String getText() {
        return nGetText(getPtr());
    }

    /**
     * Gets or sets the text contents of the text box
     */
    public final void setText(final String text) {
        nSetText(getPtr(), text);
    }

    /**
     * Gets or sets how the text box should wrap text
     */
    public final NSGui_TextWrapping getTextWrapping() {
        return NSGui_TextWrapping.values()[nGetTextWrapping(getPtr())];
    }

    /**
     * Gets or sets how the text box should wrap text
     */
    public final void setTextWrapping(final NSGui_TextWrapping wrapping) {
        nSetTextWrapping(getPtr(), wrapping.ordinal());
    }

    /**
     * Gets the visual that renders the text of the TextBox
     */
    public final NSVisual getTextView() {
        return new NSVisual(nGetTextView(getPtr()));
    }

    /**
     * Calculates the bounding box of a range of text
     */
    public final NSRect getRangeBounds(final int start, final int end) {
        final NSRect rect = new NSRect();
        getRangeBounds(rect, start, end);
        return rect;
    }

    /**
     * Calculates the bounding box of a range of text
     */
    public final void getRangeBounds(final NSRect rect, final int start, final int end) {
        nGetRangeBounds(getPtr(), rect, start, end);
    }

    /**
     * Removes the caret until control gets focused again
     */
    public final void hideCaret() {
        nHideCaret(getPtr());
    }

    /**
     * Returns the number of IME composition underlines
     */
    public final long getNumCompositionUnderlines() {
        return nGetNumCompositionUnderlines(getPtr());
    }

    /**
     * Gets the specified IME composition underline
     */
    public final NSCompositionUnderline getCompositionUnderline(final long index) {
        final NSCompositionUnderline compositionUnderline = new NSCompositionUnderline();
        getCompositionUnderline(compositionUnderline, index);
        return compositionUnderline;
    }

    /**
     * Gets the specified IME composition underline
     */
    public final void getCompositionUnderline(final NSCompositionUnderline line, final long index) {
        nGetCompositionUnderline(getPtr(), line, index);
    }

    /**
     * Adds a new IME composition underline
     */
    public final void addCompositionUnderline(final NSCompositionUnderline line) {
        nAddCompositionUnderline(getPtr(), line);
    }

    /**
     * Removes all IME composition underlines
     */
    public final void clearCompositionUnderlines() {
        nClearCompositionUnderlines(getPtr());
    }

    /**
     * Gets the currently effective typography variations for the text contents of this TextBox
     */
    public final NSTypography getTypography() {
        final NSTypography typography = new NSTypography();
        getTypography(typography);
        return typography;
    }

    /**
     * Gets the currently effective typography variations for the text contents of this TextBox
     */
    public final void getTypography(final NSTypography typography) {
        nGetTypography(getPtr(), typography);
    }

    public final void setTypography(final NSTypography typography) {
        nSetTypography(getPtr(), typography);
    }

    private static native long nCreate();

    private static native int nGetCaretIndex(long ptr);

    private static native void nSetCaretIndex(long ptr, int value);

    private static native int nGetMaxLength(long ptr);

    private static native void nSetMaxLength(long ptr, int value);

    private static native int nGetMaxLines(long ptr);

    private static native void nSetMaxLines(long ptr, int value);

    private static native int nGetMinLines(long ptr);

    private static native void nSetMinLines(long ptr, int value);

    private static native String nGetPlaceholder(long ptr);

    private static native void nSetPlaceholder(long ptr, String text);

    private static native String nGetSelectedText(long ptr);

    private static native void nSetSelectedText(long ptr, String text);

    private static native int nGetSelectionLength(long ptr);

    private static native void nSetSelectionLength(long ptr, int length);

    private static native int nGetSelectionStart(long ptr);

    private static native void nSetSelectionStart(long ptr, int pos);

    private static native void nSelectAll(long ptr);

    private static native void nSelect(long ptr, int start, int length);

    private static native void nClear(long ptr);

    private static native int nGetCharacterIndexFromPoint(long ptr, NSPoint point, boolean snapToText);

    private static native int nGetCharacterIndexFromLineIndex(long ptr, int lineIndex);

    private static native int nGetLineIndexFromCharacterIndex(long ptr, int charIndex);

    private static native int nGetLineLength(long ptr, int lineIndex);

    private static native int nGetFirstVisibleLineIndex(long ptr);

    private static native int nGetLastVisibleLineIndex(long ptr);

    private static native void nScrollToLine(long ptr, int lineIndex);

    private static native int nGetTextAlignment(long ptr);

    private static native void nSetTextAlignment(long ptr, int value);

    private static native String nGetText(long ptr);

    private static native void nSetText(long ptr, String text);

    private static native int nGetTextWrapping(long ptr);

    private static native void nSetTextWrapping(long ptr, int value);

    private static native long nGetTextView(long ptr);

    private static native void nGetRangeBounds(long ptr, NSRect rect, int start, int end);

    private static native void nHideCaret(long ptr);

    private static native long nGetNumCompositionUnderlines(long ptr);

    private static native void nGetCompositionUnderline(long ptr, NSCompositionUnderline line, long index);

    private static native void nAddCompositionUnderline(long ptr, NSCompositionUnderline line);

    private static native void nClearCompositionUnderlines(long ptr);

    private static native void nGetTypography(long ptr, NSTypography typography);

    private static native void nSetTypography(long ptr, NSTypography typography);
}
