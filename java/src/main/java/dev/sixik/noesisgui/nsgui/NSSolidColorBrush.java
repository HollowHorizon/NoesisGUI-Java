package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSDependencyProperty;
import dev.sixik.noesisgui.nsdrawing.NSColor;

/**
 * Paints an area with a solid color.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.media.solidcolorbrush.aspx">
 *      Microsoft Documentation: SolidColorBrush Class</a>
 */
public class NSSolidColorBrush extends NSBrush{

    public static final NSDependencyProperty ColorProperty = new NSDependencyProperty(nColorProperty());

    public NSSolidColorBrush(NSColor color) {
        super(nCreateByColor(color));
    }

    public NSSolidColorBrush(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets the color of this SolidColorBrush
     */
    public final NSColor getColor() {
        final NSColor color = new NSColor();
        getColor(color);
        return color;
    }

    /**
     * Gets or sets the color of this SolidColorBrush
     */
    public final void getColor(NSColor color) {
        nGetColor(getPtr(), color);
    }

    /**
     * Gets or sets the color of this SolidColorBrush
     */
    public final void setColor(NSColor color) {
        nSetColor(getPtr(), color);
    }

    private static native long nCreateByColor(NSColor color);

    private static native void nGetColor(long ptr, NSColor color);

    private static native void nSetColor(long ptr, NSColor color);

    private static native long nColorProperty();
}
