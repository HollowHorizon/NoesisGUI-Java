package dev.sixik.noesisgui.nsgui;

/**
 * Groups other Inline content elements.
 * <p>
 * Span is used to group other inline flow content elements together. No inherent rendering is
 * applied to content or other elements within a Span element.
 * <p>
 * Span enforces a strong content model for child content. Child elements contained in a Span
 * element must be derived from Inline. Valid child elements include:
 * <ul>
 *   <li>Bold</li>
 *   <li>Hyperlink</li>
 *   <li>InlineUIContainer</li>
 *   <li>Italic</li>
 *   <li>LineBreak</li>
 *   <li>Run</li>
 *   <li>Span</li>
 *   <li>Underline</li>
 * </ul>
 *
 * @see <a href="https://msdn.microsoft.com/en-us/library/system.windows.documents.span.aspx">
 * Microsoft Documentation: Span Class</a>
 */
public class NSSpan extends NSInline {

    public NSSpan() {
        this(nCreate());
    }

    public NSSpan(long ptr) {
        super(ptr);
    }

    /**
     * Gets a collection containing the top-level Inline elements that comprise the Span's contents
     */
    public final NSInlineCollection getInlines() {
        return new NSInlineCollection(nGetInlines(getPtr()));
    }

    private static native long nCreate();

    private static native long nGetInlines(long ptr);
}
