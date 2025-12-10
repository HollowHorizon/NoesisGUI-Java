package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSDependencyProperty;
import dev.sixik.noesisgui.nsdrawing.NSPoint;

/**
 * Paints an area with a linear gradient.
 * <p>
 * A LinearGradientBrush paints an area with a linear gradient. A linear gradient defines a
 * gradient along a line. The line's end points are defined by the {@code StartPoint} and {@code EndPoint}
 * properties of the linear gradient. A LinearGradientBrush brush paints its {@code GradientStops} along
 * this line.
 * <p>
 * The default linear gradient is diagonal. In the default, the {@code StartPoint} of a linear gradient
 * is (0,0), the upper-left corner of the area being painted, and its {@code EndPoint} is (1,1), the
 * lower-right corner of the area being painted. The colors in the resulting gradient are
 * interpolated along the diagonal path.
 * <p>
 * It is possible to specify a gradient axis that does not completely fill area being painted. When
 * this occurs, the {@code SpreadMethod} property determines how the remaining area is painted.
 *
 * <h3>XAML Example:</h3>
 * <pre>{@code
 * <Page xmlns="http://schemas.microsoft.com/winfx/2006/xaml/presentation">
 *   <Rectangle Width="200" Height="100">
 *     <Rectangle.Fill>
 *       <LinearGradientBrush StartPoint="0,0" EndPoint="1,1">
 *         <GradientStop Color="Blue" Offset="0"/>
 *         <GradientStop Color="Red" Offset="1.0"/>
 *       </LinearGradientBrush>
 *     </Rectangle.Fill>
 *   </Rectangle>
 * </Page>
 * }</pre>
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.media.lineargradientbrush.aspx">
 * Microsoft Documentation: LinearGradientBrush Class</a>
 */
public class NSLinearGradientBrush extends NSGradientBrush {

    public static final NSDependencyProperty EndPointProperty = new NSDependencyProperty(nEndPointProperty());
    public static final NSDependencyProperty StartPointProperty = new NSDependencyProperty(nStartPointProperty());

    public NSLinearGradientBrush() {
        this(nCreate());
    }

    public NSLinearGradientBrush(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets the starting coordinates of the linear gradient
     */
    public final NSPoint getStartPoint() {
        final NSPoint point = new NSPoint(0);
        getStartPoint(point);
        return point;
    }

    /**
     * Gets or sets the starting coordinates of the linear gradient
     */
    public final void getStartPoint(final NSPoint in) {
        nGetStartPoint(getPtr(), in);
    }

    /**
     * Gets or sets the starting coordinates of the linear gradient
     */
    public final void setStartPoint(final NSPoint startPoint) {
        nSetStartPoint(getPtr(), startPoint);
    }

    /**
     * Gets or sets the location of the two-dimensional focal point that defines the beginning of
     * the gradient
     */
    public final NSPoint getEndPoint() {
        final NSPoint point = new NSPoint(0);
        getEndPoint(point);
        return point;
    }

    /**
     * Gets or sets the location of the two-dimensional focal point that defines the beginning of
     * the gradient
     */
    public final void getEndPoint(final NSPoint in) {
        nGetEndPoint(getPtr(), in);
    }

    /**
     * Gets or sets the location of the two-dimensional focal point that defines the beginning of
     * the gradient
     */
    public final void setEndPoint(final NSPoint origin) {
        nSetEndPoint(getPtr(), origin);
    }

    private static native long nCreate();

    private static native void nGetStartPoint(long ptr, NSPoint point);

    private static native void nSetStartPoint(long ptr, NSPoint point);

    private static native void nGetEndPoint(long ptr, NSPoint point);

    private static native void nSetEndPoint(long ptr, NSPoint point);

    private static native long nEndPointProperty();

    private static native long nStartPointProperty();

}

