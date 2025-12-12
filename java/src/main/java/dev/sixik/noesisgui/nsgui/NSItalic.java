package dev.sixik.noesisgui.nsgui;

/**
 * An inline-level flow content element that causes content to render with an italic font style.
 *
 * @see <a href="https://msdn.microsoft.com/en-us/library/system.windows.documents.italic.aspx">
 *      Microsoft Documentation: Italic Class</a>
 */
public class NSItalic extends NSSpan {

    public NSItalic() {
        this(nCreate());
    }

    public NSItalic(long ptr) {
        super(ptr);
    }

    private static native long nCreate();
}
