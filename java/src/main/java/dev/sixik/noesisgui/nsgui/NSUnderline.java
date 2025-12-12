package dev.sixik.noesisgui.nsgui;

/**
 * An inline-level flow content element which causes content to render with an underlined text
 * decoration.
 *
 * @see <a href="https://msdn.microsoft.com/en-us/library/system.windows.documents.underline.aspx">
 * Microsoft Documentation: Underline Class</a>
 */
public class NSUnderline extends NSSpan {

    public NSUnderline() {
        this(nCreate());
    }

    public NSUnderline(long ptr) {
        super(ptr);
    }

    private static native long nCreate();
}
