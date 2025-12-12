package dev.sixik.noesisgui.nsgui;

/**
 * Defines an area within which you can explicitly position child elements by using
 * coordinates that are relative to the Canvas area.
 * <p>
 * A Canvas contains a collection of UIElement objects, which are in the Children property.
 * <p>
 * Canvas is the only panel element that has no inherent layout characteristics. A Canvas has
 * default Height and Width properties of zero, unless it is the child of an element that
 * automatically sizes its child elements. Child elements of a Canvas are never resized, they are
 * just positioned at their designated coordinates. This provides flexibility for situations in
 * which inherent sizing constraints or alignment are not needed or wanted. For cases in which you
 * want child content to be automatically resized and aligned, it is usually best to use a
 * Grid element.
 * <p>
 * The ZIndex property determines the order in which child elements that share the same coordinate
 * space appear. A higher ZIndex value for one child element indicates that this element will
 * appear above another child element that has a lower value.
 * <p>
 * If you specify them, the attached properties Canvas.Top or Canvas.Left take priority over the
 * Canvas.Bottom or Canvas.Right properties.
 * <p>
 * Child elements of a Canvas are always given the full size that they desire. As a result,
 * vertical alignment and horizontal alignment have no effect inside a Canvas.
 *
 * <h3>XAML Example:</h3>
 * <pre>{@code
 * <StackPanel>
 *   <Canvas Height="400" Width="400">
 *     <Canvas Height="100" Width="100" Top="0" Left="0" Background="Red"/>
 *     <Canvas Height="100" Width="100" Top="100" Left="100" Background="Green"/>
 *     <Canvas Height="100" Width="100" Top="50" Left="50" Background="Blue"/>
 *   </Canvas>
 * </StackPanel>
 * }</pre>
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.canvas.aspx">
 *      Microsoft Documentation: Canvas Class</a>
 */
public class NSCanvas extends NSPanel {

    public NSCanvas() {
        this(nCreate());
    }

    public NSCanvas(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets a value that represents the distance between the left side of an element and
     * the left side of its parent Canvas
     */
    public static float getLeft(final NSUIElement element) {
        return nGetLeftStatic(element.getPtr());
    }

    /**
     * Gets or sets a value that represents the distance between the left side of an element and
     * the left side of its parent Canvas
     */
    public static void setLeft(final NSUIElement element, final float left) {
        nSetLeftStatic(element.getPtr(), left);
    }

    /**
     * Gets or sets a value that represents the distance between the top of an element and the top
     * of its parent Canvas
     */
    public static float getTop(final NSUIElement element) {
        return nGetTopStatic(element.getPtr());
    }

    /**
     * Gets or sets a value that represents the distance between the top of an element and the top
     * of its parent Canvas
     */
    public static void setTop(final NSUIElement element, final float top) {
        nSetTopStatic(element.getPtr(), top);
    }

    /**
     * Gets or sets a value that represents the distance between the right side of an element and
     * the right side of its parent Canvas
     */
    public static float getRight(final NSUIElement element) {
        return nGetRightStatic(element.getPtr());
    }

    /**
     * Gets or sets a value that represents the distance between the right side of an element and
     * the right side of its parent Canvas
     */
    public static void setRight(final NSUIElement element, final float right) {
        nSetRightStatic(element.getPtr(), right);
    }

    /**
     * Gets or sets a value that represents the distance between the bottom of an element and the
     * bottom of its parent Canvas
     */
    public static float getBottom(final NSUIElement element) {
        return nGetBottomStatic(element.getPtr());
    }

    /**
     * Gets or sets a value that represents the distance between the bottom of an element and the
     * bottom of its parent Canvas
     */
    public static void setBottom(final NSUIElement element, final float bottom) {
        nSetBottomStatic(element.getPtr(), bottom);
    }

    private static native long nCreate();

    private static native float nGetLeftStatic(long element_ptr);

    private static native void nSetLeftStatic(long element_ptr, float value);

    private static native float nGetTopStatic(long element_ptr);

    private static native void nSetTopStatic(long element_ptr, float value);

    private static native float nGetRightStatic(long element_ptr);

    private static native void nSetRightStatic(long element_ptr, float value);

    private static native float nGetBottomStatic(long element_ptr);

    private static native void nSetBottomStatic(long element_ptr, float value);
}
