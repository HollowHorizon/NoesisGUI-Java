package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSDependencyProperty;
import dev.sixik.noesisgui.nsdrawing.NSPoint;

/**
 * Paints an area with a radial gradient.
 * <p>
 * A focal point defines the beginning of the gradient, and a circle defines the end point of the
 * gradient.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.media.radialgradientbrush.aspx">
 * Microsoft Documentation: RadialGradientBrush Class</a>
 */
public class NSRadialGradientBrush extends NSGradientBrush {

    public static final NSDependencyProperty CenterProperty = new NSDependencyProperty(nCenterProperty());
    public static final NSDependencyProperty GradientOriginProperty = new NSDependencyProperty(nGradientOriginProperty());
    public static final NSDependencyProperty RadiusXProperty = new NSDependencyProperty(nRadiusXProperty());
    public static final NSDependencyProperty RadiusYProperty = new NSDependencyProperty(nRadiusYProperty());

    public NSRadialGradientBrush() {
        this(nCreate());
    }

    public NSRadialGradientBrush(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets the center of the outermost circle of the radial gradient
     */
    public final NSPoint getCenter() {
        final NSPoint point = new NSPoint();
        getCenter(point);
        return point;
    }

    /**
     * Gets or sets the center of the outermost circle of the radial gradient
     */
    public final void getCenter(final NSPoint point) {
        nGetCenter(getPtr(), point);
    }

    /**
     * Gets or sets the center of the outermost circle of the radial gradient
     */
    public final void setCenter(final NSPoint point) {
        nSetCenter(getPtr(), point);
    }

    /**
     * Gets or sets the location of the two-dimensional focal point that defines the beginning of
     * the gradient
     */
    public final NSPoint getGradientOrigin() {
        final NSPoint point = new NSPoint();
        getGradientOrigin(point);
        return point;
    }

    /**
     * Gets or sets the location of the two-dimensional focal point that defines the beginning of
     * the gradient
     */
    public final void getGradientOrigin(final NSPoint point) {
        nGetGradientOrigin(getPtr(), point);
    }

    /**
     * Gets or sets the location of the two-dimensional focal point that defines the beginning of
     * the gradient
     */
    public final void setGradientOrigin(final NSPoint point) {
        nSetGradientOrigin(getPtr(), point);
    }

    /**
     * Gets or sets the horizontal radius of the outermost circle of the radial gradient
     */
    public final float getRadiusX() {
        return nGetRadiusX(getPtr());
    }

    /**
     * Gets or sets the horizontal radius of the outermost circle of the radial gradient
     */
    public final void setRadiusX(final float value) {
        nSetRadiusX(getPtr(), value);
    }

    /**
     * Gets or sets the vertical radius of the outermost circle of a radial gradient
     */
    public final float getRadiusY() {
        return nGetRadiusY(getPtr());
    }

    /**
     * Gets or sets the vertical radius of the outermost circle of a radial gradient
     */
    public final void setRadiusY(final float value) {
        nSetRadiusY(getPtr(), value);
    }

    private static native long nCreate();

    private static native float nGetRadiusX(long ptr);

    private static native void nSetRadiusX(long ptr, float value);

    private static native float nGetRadiusY(long ptr);

    private static native void nSetRadiusY(long ptr, float value);

    private static native void nGetCenter(long ptr, NSPoint point);

    private static native void nSetCenter(long ptr, NSPoint point);

    private static native void nGetGradientOrigin(long ptr, NSPoint point);

    private static native void nSetGradientOrigin(long ptr, NSPoint point);

    private static native long nCenterProperty();

    private static native long nGradientOriginProperty();

    private static native long nRadiusXProperty();

    private static native long nRadiusYProperty();
}
