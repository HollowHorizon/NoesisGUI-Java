package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSDependencyObject;

/**
 * Defines text attached properties.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.documents.textelement.aspx">
 * Microsoft Documentation: TextElement Class</a>
 */
public class NSTextElement extends NSFrameworkElement {

    public NSTextElement(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets the Brush used to fill the background of the content area
     */
    public final NSBrush getBackground() {
        return new NSBrush(nGetBackground(getPtr()));
    }

    /**
     * Gets or sets the Brush used to fill the background of the content area
     */
    public final void setBackground(final NSBrush brush) {
        nSetBackground(getPtr(), brush.getPtr());
    }

    /**
     * Gets or sets the uniform spacing between characters, in units of 1/1000 of an em
     */
    public final int getCharacterSpacing() {
        return nGetCharacterSpacing(getPtr());
    }

    /**
     * Gets or sets the uniform spacing between characters, in units of 1/1000 of an em
     */
    public final void setCharacterSpacing(final int spacing) {
        nSetCharacterSpacing(getPtr(), spacing);
    }

    /**
     * Gets or sets the preferred top-level font family for the content of the element
     */
    public final NSFontFamily getFontFamily() {
        return new NSFontFamily(nGetFontFamily(getPtr()));
    }

    /**
     * Gets or sets the preferred top-level font family for the content of the element
     */
    public final void setFontFamily(final NSFontFamily fontFamily) {
        nSetFontFamily(getPtr(), fontFamily.getPtr());
    }

    /**
     * Gets or sets the font size for the content of the element
     */
    public final float getFontSize() {
        return nGetFontSize(getPtr());
    }

    /**
     * Gets or sets the font size for the content of the element
     */
    public final void setFontSize(final float value) {
        nSetFontSize(getPtr(), value);
    }

    /**
     * Gets or sets the font stretct for the content of the element
     */
    public final NSGui_FontStretch getFontStretch() {
        return NSGui_FontStretch.values()[nGetFontStretch(getPtr())];
    }

    /**
     * Gets or sets the font stretct for the content of the element
     */
    public final void setFontStretch(final NSGui_FontStretch stretch) {
        nSetFontStretch(getPtr(), stretch.ordinal());
    }

    /**
     * Gets or sets the font style for the content of the element
     */
    public final NSGui_FontStyle getFontStyle() {
        return NSGui_FontStyle.values()[nGetFontStyle(getPtr())];
    }

    /**
     * Gets or sets the font style for the content of the element
     */
    public final void setFontStyle(final NSGui_FontStyle style) {
        nSetFontStyle(getPtr(), style.ordinal());
    }

    /**
     * Gets or sets the top-level font weight for the content of the element
     */
    public final NSGui_FontWeight getFontWeight() {
        return NSGui_FontWeight.get(nGetFontWeight(getPtr()));
    }

    /**
     * Gets or sets the top-level font weight for the content of the element
     */
    public final void setFontWeight(final NSGui_FontWeight weight) {
        nSetFontWeight(getPtr(), weight.value);
    }

    /**
     * Gets or sets the Brush to apply to the content of the element
     */
    public final NSBrush getForeground() {
        return new NSBrush(nGetForeground(getPtr()));
    }

    /**
     * Gets or sets the Brush to apply to the content of the element
     */
    public final void setForeground(final NSBrush brush) {
        nSetForeground(getPtr(), brush.getPtr());
    }

    /**
     * Gets or sets the Brush used to stroke the text
     */
    public final NSBrush getStroke() {
        return new NSBrush(nGetStroke(getPtr()));
    }

    /**
     * Gets or sets the Brush used to stroke the text
     */
    public final void setStroke(final NSBrush brush) {
        nSetStroke(getPtr(), brush.getPtr());
    }

    /**
     * Gets or sets the width (in pixels) of the text stroke
     */
    public final float getStrokeThickness() {
        return nGetStrokeThickness(getPtr());
    }

    /**
     * Gets or sets the width (in pixels) of the text stroke
     */
    public final void setStrokeThickness(final float value) {
        nSetStrokeThickness(getPtr(), value);
    }

    /**
     * Gets the currently effective typography variations for the text contents of this TextElement
     */
    public final NSTypography getTypography() {
        final NSTypography typography = new NSTypography();
        getTypography(typography);
        return typography;
    }

    /**
     * Gets the currently effective typography variations for the text contents of this TextElement
     */
    public final void getTypography(final NSTypography typography) {
        nGetTypography(getPtr(), typography);
    }

    /**
     * Sets the currently effective typography variations for the text contents of this TextElement
     */
    public final void setTypography(final NSTypography typography) {
        nSetTypography(getPtr(), typography);
    }

    /**
     * Gets or sets the preferred top-level font family for the content of the element
     */
    public static NSFontFamily getFontFamily(final NSDependencyObject element) {
        return new NSFontFamily(nGetFontFamilyStatic(element.getPtr()));
    }

    /**
     * Gets or sets the preferred top-level font family for the content of the element
     */
    public static void setFontFamily(final NSDependencyObject element, final NSFontFamily fontFamily) {
        nSetFontFamilyStatic(element.getPtr(), fontFamily.getPtr());
    }

    /**
     * Gets or sets the font size for the content of the element
     */
    public static float getFontSize(final NSDependencyObject element) {
        return nGetFontSizeStatic(element.getPtr());
    }

    /**
     * Gets or sets the font size for the content of the element
     */
    public static void setFontSize(final NSDependencyObject element, final float size) {
        nSetFontSizeStatic(element.getPtr(), size);
    }

    /**
     * Gets or sets the font stretch for the content of the element
     */
    public static NSGui_FontStretch getFontStretch(final NSDependencyObject element) {
        return NSGui_FontStretch.values()[nGetFontStretchStatic(element.getPtr())];
    }

    /**
     * Gets or sets the font stretch for the content of the element
     */
    public static void setFontStretch(final NSDependencyObject element, final NSGui_FontStretch stretch) {
        nSetFontStretchStatic(element.getPtr(), stretch.ordinal());
    }

    /**
     * Gets or sets the font style for the content of the element
     */
    public static NSGui_FontStyle getFontStyle(final NSDependencyObject element) {
        return NSGui_FontStyle.values()[nGetFontStyleStatic(element.getPtr())];
    }

    /**
     * Gets or sets the font style for the content of the element
     */
    public static void setFontStyle(final NSDependencyObject element, final NSGui_FontStyle style) {
        nSetFontStyleStatic(element.getPtr(), style.ordinal());
    }

    /**
     * Gets or sets the top-level font weight for the content of the element
     */
    public static NSGui_FontWeight getFontWeight(final NSDependencyObject element) {
        return NSGui_FontWeight.get(nGetFontWeightStatic(element.getPtr()));
    }

    /**
     * Gets or sets the top-level font weight for the content of the element
     */
    public static void setFontWeight(final NSDependencyObject element, final NSGui_FontWeight weight) {
        nSetFontWeightStatic(element.getPtr(), weight.value);
    }

    /**
     * Gets or sets the Brush to apply to the content of the element
     */
    public static NSBrush getForeground(final NSDependencyObject element) {
        return new NSBrush(nGetForegroundStatic(element.getPtr()));
    }

    /**
     * Gets or sets the Brush to apply to the content of the element
     */
    public static void setForeground(final NSDependencyObject element, final NSBrush brush) {
        nSetForegroundStatic(element.getPtr(), brush.getPtr());
    }

    /**
     * Gets or sets the Brush used to stroke the text
     */
    public static NSBrush getStroke(final NSDependencyObject element) {
        return new NSBrush(nGetStrokeStatic(element.getPtr()));
    }

    /**
     * Gets or sets the Brush used to stroke the text
     */
    public static void setStroke(final NSDependencyObject element, final NSBrush brush) {
        nSetStrokeStatic(element.getPtr(), brush.getPtr());
    }

    /**
     * Gets or sets the width (in pixels) of the text stroke
     */
    public static float getStrokeThickness(final NSDependencyObject element) {
        return nGetStrokeThicknessStatic(element.getPtr());
    }

    /**
     * Gets or sets the width (in pixels) of the text stroke
     */
    public static void setStrokeThickness(final NSDependencyObject element, final float strokeThickness) {
        nSetStrokeThicknessStatic(element.getPtr(), strokeThickness);
    }

    private static native long nGetBackground(long ptr);

    private static native void nSetBackground(long ptr, long brush_ptr);

    private static native int nGetCharacterSpacing(long ptr);

    private static native void nSetCharacterSpacing(long ptr, int value);

    private static native long nGetFontFamily(long ptr);

    private static native void nSetFontFamily(long ptr, long fontFamily_ptr);

    private static native float nGetFontSize(long ptr);

    private static native void nSetFontSize(long ptr, float value);

    private static native int nGetFontStretch(long ptr);

    private static native void nSetFontStretch(long ptr, int value);

    private static native int nGetFontStyle(long ptr);

    private static native void nSetFontStyle(long ptr, int value);

    private static native int nGetFontWeight(long ptr);

    private static native void nSetFontWeight(long ptr, int value);

    private static native long nGetForeground(long ptr);

    private static native void nSetForeground(long ptr, long brush_ptr);

    private static native long nGetStroke(long ptr);

    private static native void nSetStroke(long ptr, long brush_ptr);

    private static native float nGetStrokeThickness(long ptr);

    private static native void nSetStrokeThickness(long ptr, float value);

    private static native void nGetTypography(long ptr, NSTypography typography);

    private static native void nSetTypography(long ptr, NSTypography typography);

    private static native long nGetFontFamilyStatic(long element_ptr);

    private static native void nSetFontFamilyStatic(long element_ptr, long fontFamily_ptr);

    private static native float nGetFontSizeStatic(long element_ptr);

    private static native void nSetFontSizeStatic(long element_ptr, float size);

    private static native int nGetFontStretchStatic(long element_ptr);

    private static native void nSetFontStretchStatic(long element_ptr, int value);

    private static native int nGetFontStyleStatic(long element_ptr);

    private static native void nSetFontStyleStatic(long element_ptr, int value);

    private static native int nGetFontWeightStatic(long element_ptr);

    private static native void nSetFontWeightStatic(long element_ptr, int value);

    private static native long nGetForegroundStatic(long element_ptr);

    private static native void nSetForegroundStatic(long element_ptr, long brush_ptr);

    private static native long nGetStrokeStatic(long element_ptr);

    private static native void nSetStrokeStatic(long element_ptr, long brush_ptr);

    private static native float nGetStrokeThicknessStatic(long element_ptr);

    private static native void nSetStrokeThicknessStatic(long element_ptr, float value);
}
