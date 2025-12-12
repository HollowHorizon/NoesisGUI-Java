package dev.sixik.noesisgui.nsgui;

/**
 * An abstract class that provides a base for all inline flow content elements.
 *
 * @see <a href="https://msdn.microsoft.com/en-us/library/system.windows.documents.inline.aspx">
 *      Microsoft Documentation: Inline Class</a>
 */
public class NSInline extends NSTextElement {

    public NSInline(long ptr) {
        super(ptr);
    }

    /**
     * A collection of Inlines that are siblings to this element. May return null if an element
     * is not inserted into any tree.
     */
    public final NSInlineCollection getSiblingInlines() {
        return new NSInlineCollection(nGetSiblingInlines(getPtr()));
    }

    /**
     * Returns an Inline immediately preceding this one on the same level of siblings
     */
    public final NSInline getPreviousInline() {
        return new NSInline(nGetPreviousInline(getPtr()));
    }

    /**
     * Returns an Inline immediately following this one on the same level of siblings
     */
    public final NSInline getNextInline() {
        return new NSInline(nGetNextInline(getPtr()));
    }

    /**
     * Gets or sets the text decoration to apply to the element
     */
    public final NSGui_TextDecorations getTextDecorations() {
        return NSGui_TextDecorations.values()[nGetTextDecorations(getPtr())];
    }

    /**
     * Gets or sets the text decoration to apply to the element
     */
    public final void setTextDecorations(final NSGui_TextDecorations decorations) {
        nSetTextDecorations(getPtr(), decorations.ordinal());
    }

    private static native long nGetSiblingInlines(long ptr);

    private static native long nGetPreviousInline(long ptr);

    private static native long nGetNextInline(long ptr);

    private static native int nGetTextDecorations(long ptr);

    private static native void nSetTextDecorations(long ptr, int value);
}
