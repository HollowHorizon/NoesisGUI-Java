package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSDependencyProperty;

/**
 * Defines objects used to paint graphical objects. Classes that derive from Brush describe how
 * the area is painted.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.media.brush.aspx">
 *      Microsoft Documentation: Brush Class</a>
 */
public class NSBrush extends NSAnimatable{

    public static final NSDependencyProperty OpacityProperty = new NSDependencyProperty(nOpacityProperty());
    public static final NSDependencyProperty RelativeTransformProperty = new NSDependencyProperty(nRelativeTransformProperty());
    public static final NSDependencyProperty TransformProperty = new NSDependencyProperty(nTransformProperty());

    public NSBrush(long ptr) {
        super(ptr);
    }

    /**
     * Get/Set Opacity
     */
    public final float getOpacity() {
        return nGetOpacity(getPtr());
    }

    /**
     * Get/Set Opacity
     */
    public final void setOpacity(final float value) {
        nSetOpacity(getPtr(), value);
    }

    /**
     * Gets or sets the transformation that is applied to the brush using relative coordinates
     */
    public final NSTransform getRelativeTransform() {
        return new NSTransform(nGetRelativeTransform(getPtr()));
    }

    /**
     * Gets or sets the transformation that is applied to the brush using relative coordinates
     */
    public final void setRelativeTransform(final NSTransform transform) {
        nSetRelativeTransform(getPtr(), transform.getPtr());
    }

    /**
     * Gets or sets the transformation that is applied to the brush. This transformation is
     * applied after the brush's output has been mapped and positioned
     */
    public final NSTransform getTransform() {
        return new NSTransform(nGetTransform(getPtr()));
    }

    /**
     * Gets or sets the transformation that is applied to the brush. This transformation is
     * applied after the brush's output has been mapped and positioned
     */
    public final void setTransform(final NSTransform transform) {
        nSetTransform(getPtr(), transform.getPtr());
    }

    /**
     * Indicates if this brush is transparent
     */
    public final boolean isTransparent() {
        return nIsTransparent(getPtr());
    }

    private static native float nGetOpacity(long ptr);

    private static native void nSetOpacity(long ptr, float value);

    private static native long nGetRelativeTransform(long ptr);

    private static native void nSetRelativeTransform(long ptr, long transform_ptr);

    private static native long nGetTransform(long ptr);

    private static native void nSetTransform(long ptr, long transform_ptr);

    private static native boolean nIsTransparent(long ptr);

    private static native long nOpacityProperty();

    private static native long nRelativeTransformProperty();

    private static native long nTransformProperty();
}
