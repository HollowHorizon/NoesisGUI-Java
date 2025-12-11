package dev.sixik.noesisgui.nsgui;

/**
 * Encapsulates a page of content.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.page.aspx">
 *      Microsoft Documentation: Page Class</a>
 */
public class NSPage extends NSUserControl {

    public NSPage() {
        this(nCreate());
    }

    public NSPage(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets page title
     */
    public final String getTitle() {
        return nGetTitle(getPtr());
    }

    /**
     * Gets or sets page title
     */
    public final void setTitle(final String title) {
        nSetTitle(getPtr(), title);
    }

    private static native long nCreate();

    private static native String nGetTitle(long ptr);

    private static native void nSetTitle(long ptr, String title);
}
