package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSDependencyProperty;

/**
 * Defines an abstract class that describes a gradient, composed of gradient stops. Classes that
 * inherit from GradientBrush describe different ways of interpreting gradient stops.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.media.gradientbrush.aspx">
 *      Microsoft Documentation: GradientBrush Class</a>
 */
public class NSGradientBrush extends NSBrush{

    public static final NSDependencyProperty ColorInterpolationModeProperty = new NSDependencyProperty(nColorInterpolationModeProperty());
    public static final NSDependencyProperty GradientStopsProperty = new NSDependencyProperty(nGradientStopsProperty());
    public static final NSDependencyProperty MappingModeProperty = new NSDependencyProperty(nMappingModeProperty());
    public static final NSDependencyProperty SpreadMethodProperty = new NSDependencyProperty(nSpreadMethodProperty());

    public NSGradientBrush(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets a ColorInterpolationMode enumeration that specifies how the gradient's colors
     * are interpolated.
     */
    public final NSGui_ColorInterpolationMode getColorInterpolationMode() {
        return NSGui_ColorInterpolationMode.values()[nGetColorInterpolationMode(getPtr())];
    }

    /**
     * Gets or sets a ColorInterpolationMode enumeration that specifies how the gradient's colors
     * are interpolated.
     */
    public final void setColorInterpolationMode(final NSGui_ColorInterpolationMode mode) {
        nSetColorInterpolationMode(getPtr(), mode.ordinal());
    }

    /**
     * Gets or sets the brush's gradient stops
     */
    public final NSGradientStopCollection getGradientStops() {
        return new NSGradientStopCollection(nGetGradientStops(getPtr()));
    }

    /**
     * Gets or sets the brush's gradient stops
     */
    public final void setGradientStops(final NSGradientStopCollection stops) {
        nSetGradientStops(getPtr(), stops.getPtr());
    }

    /**
     * Gets or sets a BrushMappingMode enumeration that specifies whether the gradient brush's
     * positioning coordinates are absolute or relative to the output area.
     */
    public final NSGui_BrushMappingMode getMappingMode() {
        return NSGui_BrushMappingMode.values()[nGetMappingMode(getPtr())];
    }

    /**
     * Gets or sets a BrushMappingMode enumeration that specifies whether the gradient brush's
     * positioning coordinates are absolute or relative to the output area.
     */
    public final void setMappingMode(final NSGui_BrushMappingMode mode) {
        nSetMappingMode(getPtr(), mode.ordinal());
    }

    /**
     * Gets or sets the type of spread method that specifies how to draw a gradient that starts or
     * ends inside the bounds of the object to be painted.
     */
    public final NSGui_GradientSpreadMethod getSpreadMethod() {
        return NSGui_GradientSpreadMethod.values()[nGetSpreadMethod(getPtr())];
    }

    /**
     * Gets or sets the type of spread method that specifies how to draw a gradient that starts or
     * ends inside the bounds of the object to be painted.
     */
    public final void setSpreadMethod(final NSGui_GradientSpreadMethod method) {
        nSetSpreadMethod(getPtr(), method.ordinal());
    }

    private static native int nGetColorInterpolationMode(long ptr);

    private static native void nSetColorInterpolationMode(long ptr, int ordinal);

    private static native long nGetGradientStops(long ptr);

    private static native void nSetGradientStops(long ptr, long collection_ptr);

    private static native int nGetMappingMode(long ptr);

    private static native void nSetMappingMode(long ptr, int value);

    private static native int nGetSpreadMethod(long ptr);

    private static native void nSetSpreadMethod(long ptr, int value);

    private static native long nColorInterpolationModeProperty();

    private static native long nGradientStopsProperty();

    private static native long nMappingModeProperty();

    private static native long nSpreadMethodProperty();
}
