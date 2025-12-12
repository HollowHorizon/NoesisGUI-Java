package dev.sixik.noesisgui.nsgui;

/**
 * An inline-level flow content element which causes content to render with a {@code bold} font weight.
 *
 * @see <a href="https://msdn.microsoft.com/en-us/library/system.windows.documents.bold.aspx">
 * Microsoft Documentation: Bold Class</a>
 */
public class NSBold extends NSSpan {

    public NSBold() {
        this(nCreate());
    }

    public NSBold(long ptr) {
        super(ptr);
    }

    private static native long nCreate();
}
