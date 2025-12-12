package dev.sixik.noesisgui.nsgui;

/**
 * An inline-level flow content element intended to contain a run of formatted or unformatted text.
 *
 * @see <a href="https://msdn.microsoft.com/en-us/library/system.windows.documents.run.aspx">
 * Microsoft Documentation: Run Class</a>
 */
public class NSRun extends NSInline {

    public NSRun() {
        this(nCreate());
    }

    public NSRun(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets the unformatted text contents of this text Run
     */
    public final String getText() {
        return nGetText(getPtr());
    }

    /**
     * Gets or sets the unformatted text contents of this text Run
     */
    public final void setText(final String text) {
        nSetText(getPtr(), text);
    }

    /**
     * Gets typography features applied to this Run
     */
    public final long getFontFeatures() {
        return nGetFontFeatures(getPtr());
    }

    private static native long nCreate();

    private static native String nGetText(long ptr);

    private static native void nSetText(long ptr, String text);

    private static native long nGetFontFeatures(long ptr);
}
