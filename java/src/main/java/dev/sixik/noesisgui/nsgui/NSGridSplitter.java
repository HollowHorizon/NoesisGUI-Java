package dev.sixik.noesisgui.nsgui;

/**
 * Represents the control that redistributes space between columns or rows of a Grid control.
 *
 * <h3>XAML Examples:</h3>
 * <h4>Column Splitter:</h4>
 * <pre>{@code
 * <Grid>
 *   <Grid.ColumnDefinitions>
 *     <ColumnDefinition Width="1*"/>
 *     <ColumnDefinition Width="4*"/>
 *   </Grid.ColumnDefinitions>
 *
 *   <GridSplitter Width="5" HorizontalAlignment="Right" VerticalAlignment="Stretch"/>
 * </Grid>
 * }</pre>
 *
 * <h4>Row Splitter:</h4>
 * <pre>{@code
 * <Grid>
 *   <Grid.RowDefinitions>
 *     <RowDefinition Height="5*"/>
 *     <RowDefinition Height="2*"/>
 *   </Grid.RowDefinitions>
 *
 *   <GridSplitter Height="5" HorizontalAlignment="Stretch" VerticalAlignment="Bottom"
 *     ShowsPreview="True"/>
 * </Grid>
 * }</pre>
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.gridsplitter.aspx">
 *      Microsoft Documentation: GridSplitter Class</a>
 */
public class NSGridSplitter extends NSThumb {

    public NSGridSplitter() {
        this(nCreate());
    }

    public NSGridSplitter(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets the distance that user must drag the GridSplitter control to resize
     * columns or rows.
     */
    public final float getDragIncrement() {
        return nGetDragIncrement(getPtr());
    }

    /**
     * Gets or sets the distance that user must drag the GridSplitter control to resize
     * columns or rows.
     */
    public final void setDragIncrement(final float value) {
        nSetDragIncrement(getPtr(), value);
    }

    /**
     * Gets or sets GridSplitter's step size when moving it with arrow keys.
     */
    public final float getKeyboardIncrement() {
        return nGetKeyboardIncrement(getPtr());
    }

    /**
     * Gets or sets GridSplitter's step size when moving it with arrow keys.
     */
    public final void setKeyboardIncrement(final float value) {
        nSetKeyboardIncrement(getPtr(), value);
    }

    /**
     * Gets or sets whether to resize columns or rows.
     */
    public final NSGui_GridResizeDirection getResizeDirection() {
        return NSGui_GridResizeDirection.values()[nGetResizeDirection(getPtr())];
    }

    /**
     * Gets or sets whether to resize columns or rows.
     */
    public final void setResizeDirection(final NSGui_GridResizeDirection direction) {
        nSetResizeDirection(getPtr(), direction.ordinal());
    }

    /**
     * Gets or sets whichs columns or rows to resize relative to the column or row in which
     * the GridSplitter control is definied.
     */
    public final NSGui_GridResizeBehavior getResizeBehavior() {
        return NSGui_GridResizeBehavior.values()[nGetResizeBehavior(getPtr())];
    }

    /**
     * Gets or sets whichs columns or rows to resize relative to the column or row in which
     * the GridSplitter control is definied.
     */
    public final void setResizeBehavior(final NSGui_GridResizeBehavior behavior) {
        nSetResizeBehavior(getPtr(), behavior.ordinal());
    }

    /**
     * Gets or sets whether column or row size should be updated as the GridSplitter
     * is being dragged.
     */
    public final boolean getShowsPreview() {
        return nGetShowsPreview(getPtr());
    }

    /**
     * Gets or sets whether column or row size should be updated as the GridSplitter
     * is being dragged.
     */
    public final void setShowsPreview(final boolean value) {
        nSetShowsPreview(getPtr(), value);
    }

    /**
     * Gets or sets the Style of the GridSplitter control preview which is displayed
     * when the ShowsPreview property is set to true.
     */
    public final NSStyle getPreviewStyle() {
        return new NSStyle(nGetPreviewStyle(getPtr()));
    }

    /**
     * Gets or sets the Style of the GridSplitter control preview which is displayed
     * when the ShowsPreview property is set to true.
     */
    public final void setPreviewStyle(final NSStyle style) {
        nSetPreviewStyle(getPtr(), style.getPtr());
    }

    private static native long nCreate();

    private static native float nGetDragIncrement(long ptr);

    private static native void nSetDragIncrement(long ptr, float value);

    private static native float nGetKeyboardIncrement(long ptr);

    private static native void nSetKeyboardIncrement(long ptr, float value);

    private static native int nGetResizeDirection(long ptr);

    private static native void nSetResizeDirection(long ptr, int value);

    private static native int nGetResizeBehavior(long ptr);

    private static native void nSetResizeBehavior(long ptr, int value);

    private static native boolean nGetShowsPreview(long ptr);

    private static native void nSetShowsPreview(long ptr, boolean value);

    private static native long nGetPreviewStyle(long ptr);

    private static native void nSetPreviewStyle(long ptr, long style_ptr);
}
