package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSDependencyProperty;

/**
 * Paints an area with a Visual.
 * <p>
 * Current VisualBrush implementation only works when the referred Visual is contained within
 * the logical tree.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.media.visualbrush.aspx">
 *      Microsoft Documentation: VisualBrush Class</a>
 */
public class NSVisualBrush extends NSTileBrush {

    public static final NSDependencyProperty VisualProperty = new NSDependencyProperty(nVisualProperty());

    public NSVisualBrush() {
        this(nCreate());
    }

    public NSVisualBrush(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets the brush's content. Remark that current implementation only works when
     * visual refers to an element that is part of the logical tree
     */
    public final NSVisual getVisual() {
        return new NSVisual(nGetVisual(getPtr()));
    }

    /**
     * Gets or sets the brush's content. Remark that current implementation only works when
     * visual refers to an element that is part of the logical tree
     */
    public final void setVisual(final NSVisual visual) {
        nSetVisual(getPtr(), visual.getPtr());
    }

    private static native long nCreate();

    private static native long nVisualProperty();

    private static native long nGetVisual(long ptr);

    private static native void nSetVisual(long ptr, long visual_ptr);
}
