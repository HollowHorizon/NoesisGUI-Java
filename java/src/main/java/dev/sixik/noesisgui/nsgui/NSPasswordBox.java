package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nshandlers.NSRoutedEventHandler;

/**
 * Represents a control designed for entering and handling passwords.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.passwordbox.aspx">
 * Microsoft Documentation: PasswordBox Class</a>
 * @since 1.0
 */
public class NSPasswordBox extends NSControl {

    public NSPasswordBox() {
        this(nCreate());
    }

    public NSPasswordBox(long ptr) {
        super(ptr);
    }

    /**
     * Selects the entire contents of the PasswordBox
     */
    public final void selectAll() {
        nSelectAll(getPtr());
    }

    /**
     * Gets or sets the brush that is used to paint the caret of the PasswordBox
     */
    public final NSBrush getCaretBrush() {
        return new NSBrush(nGetCaretBrush(getPtr()));
    }

    /**
     * Gets or sets the brush that is used to paint the caret of the PasswordBox
     */
    public final void setCaretBrush(final NSBrush brush) {
        nSetCaretBrush(getPtr(), brush.getPtr());
    }

    /**
     * Gets or sets the maximum length for passwords to be handled by this PasswordBox
     */
    public final int getMaxLength() {
        return nGetMaxLength(getPtr());
    }

    /**
     * Gets or sets the maximum length for passwords to be handled by this PasswordBox
     */
    public final void setMaxLength(final int value) {
        nSetMaxLength(getPtr(), value);
    }

    /**
     * Gets or sets the masking character for the PasswordBox
     */
    public final char getPasswordChar() {
        return nGetPasswordChar(getPtr());
    }

    /**
     * Gets or sets the masking character for the PasswordBox
     */
    public final void setPasswordChar(final char c) {
        nSetPasswordChar(getPtr(), c);
    }

    /**
     * Gets or sets the password currently held by the PasswordBox.
     */
    public final String getPassword() {
        return nGetPassword(getPtr());
    }

    /**
     * Gets or sets the password currently held by the PasswordBox.
     */
    public final void setPassword(final String password) {
        nSetPassword(getPtr(), password);
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
    public final void setPlaceholder(final String password) {
        nSetPlaceholder(getPtr(), password);
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
     * Gets or sets the opacity of the *SelectionBrush*.
     * If *SelectionOpacity* is set to 0, the *SelectionBrush* is transparent and is not visible.
     * If *SelectionOpacity* is set to 1.0 or greater, the *SelectionBrush* is opaque and the
     * selected text is not visible.
     */
    public final float getSelectionOpacity() {
        return nGetSelectionOpacity(getPtr());
    }

    /**
     * Gets or sets the opacity of the *SelectionBrush*.
     * If *SelectionOpacity* is set to 0, the *SelectionBrush* is transparent and is not visible.
     * If *SelectionOpacity* is set to 1.0 or greater, the *SelectionBrush* is opaque and the
     * selected text is not visible.
     */
    public final void setSelectionOpacity(final float selectionOpacity) {
        nSetSelectionOpacity(getPtr(), selectionOpacity);
    }

    /**
     * Gets or sets the duration in milliseconds that the last character typed in the PasswordBox
     * remains visible before it is converted into the corresponding *PasswordChar*
     */
    public final char getShowLastCharacterDuration() {
        return nGetShowLastCharacterDuration(getPtr());
    }

    /**
     * Gets or sets the duration in milliseconds that the last character typed in the PasswordBox
     * remains visible before it is converted into the corresponding *PasswordChar*
     */
    public final void setShowLastCharacterDuration(final char c) {
        nSetShowLastCharacterDuration(getPtr(), c);
    }

    /**
     * Removes the caret until control gets focused again
     */
    public final void hideCaret() {
        nHideCaret(getPtr());
    }

    /**
     * Occurs when password changes
     */
    public final void passwordChangedEvent(final NSRoutedEventHandler event) {
        nPasswordChanged(getPtr(), event);
    }

    private static native long nCreate();

    private static native void nSelectAll(long ptr);

    private static native long nGetCaretBrush(long ptr);

    private static native void nSetCaretBrush(long ptr, long brush_ptr);

    private static native int nGetMaxLength(long ptr);

    private static native void nSetMaxLength(long ptr, int value);

    private static native char nGetPasswordChar(long ptr);

    private static native void nSetPasswordChar(long ptr, char c);

    private static native String nGetPassword(long ptr);

    private static native void nSetPassword(long ptr, String value);

    private static native String nGetPlaceholder(long ptr);

    private static native void nSetPlaceholder(long ptr, String value);

    private static native long nGetSelectionBrush(long ptr);

    private static native void nSetSelectionBrush(long ptr, long brush_ptr);

    private static native float nGetSelectionOpacity(long ptr);

    private static native void nSetSelectionOpacity(long ptr, float value);

    private static native char nGetShowLastCharacterDuration(long ptr);

    private static native void nSetShowLastCharacterDuration(long ptr, char c);

    private static native void nHideCaret(long ptr);

    private static native void nPasswordChanged(long ptr, NSRoutedEventHandler event);
}
