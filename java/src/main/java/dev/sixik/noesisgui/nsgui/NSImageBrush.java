package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSDependencyProperty;

/**
 * Paints an area with an image.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.media.imagebrush.aspx">
 *      Microsoft Documentation: ImageBrush Class</a>
 */
public class NSImageBrush extends NSTileBrush {

    public static final NSDependencyProperty ImageSourceProperty = new NSDependencyProperty(nImageSourceProperty());
    public static final NSDependencyProperty ShaderProperty = new NSDependencyProperty(nShaderProperty());

    public NSImageBrush() {
        this(nCreate());
    }

    public NSImageBrush(final NSImageSource image) {
        this(nCreateImage(image.getPtr()));
    }

    public NSImageBrush(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets image source file
     */
    public final NSImageSource getImageSource() {
        return new NSImageSource(nGetImageSource(getPtr()));
    }

    /**
     * Gets or sets image source file
     */
    public final void setImageSource(final NSImageSource source) {
        nSetImageSource(getPtr(), source.getPtr());
    }

    /**
     * Gets or sets brush shader
     */
    public final NSBrushShader getShader() {
        return new NSBrushShader(nGetShader(getPtr()));
    }

    /**
     * Gets or sets brush shader
     */
    public final void setShader(final NSBrushShader shader) {
        nSetShader(getPtr(), shader.getPtr());
    }

    private static native long nCreate();

    private static native long nCreateImage(long image_ptr);

    private static native long nGetImageSource(long ptr);

    private static native void nSetImageSource(long ptr, long source_ptr);

    private static native long nGetShader(long ptr);

    private static native void nSetShader(long ptr, long shader_ptr);

    private static native long nImageSourceProperty();

    private static native long nShaderProperty();
}
