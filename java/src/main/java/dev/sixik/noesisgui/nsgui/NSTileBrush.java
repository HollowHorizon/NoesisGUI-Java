package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSDependencyProperty;
import dev.sixik.noesisgui.nsdrawing.NSRect;

/**
 * Describes a way to paint a region by using one or more tiles.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.media.tilebrush.aspx">
 *      Microsoft Documentation: TileBrush Class</a>
 */
public class NSTileBrush extends NSBrush {

    public static final NSDependencyProperty AlignmentXProperty = new NSDependencyProperty(nAlignmentXProperty());
    public static final NSDependencyProperty AlignmentYProperty = new NSDependencyProperty(nAlignmentYProperty());
    public static final NSDependencyProperty StretchProperty = new NSDependencyProperty(nStretchProperty());
    public static final NSDependencyProperty TileModeProperty = new NSDependencyProperty(nTileModeProperty());
    public static final NSDependencyProperty ViewboxProperty = new NSDependencyProperty(nViewboxProperty());
    public static final NSDependencyProperty ViewboxUnitsProperty = new NSDependencyProperty(nViewboxUnitsProperty());
    public static final NSDependencyProperty ViewportProperty = new NSDependencyProperty(nViewportProperty());
    public static final NSDependencyProperty ViewportUnitsProperty = new NSDependencyProperty(nViewportUnitsProperty());

    public NSTileBrush(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets the horizontal alignment of content in the TileBrush base tile
     */
    public final NSGui_AlignmentX getAlignmentX() {
        return NSGui_AlignmentX.values()[nGetAlignmentX(getPtr())];
    }

    /**
     * Gets or sets the horizontal alignment of content in the TileBrush base tile
     */
    public final void setAlignmentX(final NSGui_AlignmentX alignmentX) {
        nSetAlignmentX(getPtr(), alignmentX.ordinal());
    }

    /**
     * Gets or sets the vertical alignment of content in the TileBrush base tile
     */
    public final NSGui_AlignmentY getAlignmentY() {
        return NSGui_AlignmentY.values()[nGetAlignmentY(getPtr())];
    }

    /**
     * Gets or sets the vertical alignment of content in the TileBrush base tile
     */
    public final void setAlignmentY(final NSGui_AlignmentY alignmentY) {
        nSetAlignmentY(getPtr(), alignmentY.ordinal());
    }

    /**
     * Gets or sets a value that specifies how the content of this TileBrush stretches to fit its
     * tiles
     */
    public final NSGui_Stretch getStretch() {
        return NSGui_Stretch.values()[nGetStretch(getPtr())];
    }

    /**
     * Gets or sets a value that specifies how the content of this TileBrush stretches to fit its
     * tiles
     */
    public final void setStretch(final NSGui_Stretch stretch) {
        nSetStretch(getPtr(), stretch.ordinal());
    }

    /**
     * Gets or sets a value that specifies how a TileBrush fills the area that you are painting if
     * the base tile is smaller than the output area
     */
    public final NSGui_TileMode getTileMode() {
        return NSGui_TileMode.values()[nGetTileMode(getPtr())];
    }

    /**
     * Gets or sets a value that specifies how a TileBrush fills the area that you are painting if
     * the base tile is smaller than the output area
     */
    public final void setTileMode(final NSGui_TileMode mode) {
        nSetTileMode(getPtr(), mode.ordinal());
    }

    /**
     * Gets or sets the position and dimensions of the content in a TileBrush tile
     */
    public final NSRect getViewbox() {
        final NSRect rect = new NSRect();
        getViewbox(rect);
        return rect;
    }

    /**
     * Gets or sets the position and dimensions of the content in a TileBrush tile
     */
    public final void getViewbox(final NSRect rect) {
        nGetViewbox(getPtr(), rect);
    }

    /**
     * Gets or sets the position and dimensions of the content in a TileBrush tile
     */
    public final void setViewbox(final NSRect rect) {
        nSetViewbox(getPtr(), rect);
    }

    /**
     * Gets or sets a value that specifies whether the Viewbox value is relative to the bounding
     * box of the TileBrush contents or whether the value is absolute
     */
    public final NSGui_BrushMappingMode getViewboxUnits() {
        return NSGui_BrushMappingMode.values()[nGetViewboxUnits(getPtr())];
    }

    /**
     * Gets or sets a value that specifies whether the Viewbox value is relative to the bounding
     * box of the TileBrush contents or whether the value is absolute
     */
    public final void setViewboxUnits(final NSGui_BrushMappingMode mode) {
        nSetViewboxUnits(getPtr(), mode.ordinal());
    }

    /**
     * Gets or sets the position and dimensions of the base tile for a TileBrush
     */
    public final NSRect getViewport() {
        final NSRect rect = new NSRect();
        getViewport(rect);
        return rect;
    }

    /**
     * Gets or sets the position and dimensions of the base tile for a TileBrush
     */
    public final void getViewport(final NSRect rect) {
        nGetViewport(getPtr(), rect);
    }

    /**
     * Gets or sets the position and dimensions of the base tile for a TileBrush
     */
    public final void setViewport(final NSRect rect) {
        nSetViewport(getPtr(), rect);
    }

    /**
     * Gets or sets a *BrushMappingMode* enumeration that specifies whether the value of the
     * *Viewport*, which indicates the size and position of the TileBrush base tile, is relative to
     * the size of the output area
     */
    public final NSGui_BrushMappingMode getViewportUnits() {
        return NSGui_BrushMappingMode.values()[nGetViewportUnits(getPtr())];
    }

    /**
     * Gets or sets a *BrushMappingMode* enumeration that specifies whether the value of the
     * *Viewport*, which indicates the size and position of the TileBrush base tile, is relative to
     * the size of the output area
     */
    public final void setViewportUnits(final NSGui_BrushMappingMode mode) {
        nSetViewportUnits(getPtr(), mode.ordinal());
    }

    private static native int nGetAlignmentX(long ptr);

    private static native void nSetAlignmentX(long ptr, int value);

    private static native int nGetAlignmentY(long ptr);

    private static native void nSetAlignmentY(long ptr, int value);

    private static native int nGetStretch(long ptr);

    private static native void nSetStretch(long ptr, int value);

    private static native int nGetTileMode(long ptr);

    private static native void nSetTileMode(long ptr, int value);

    private static native void nGetViewbox(long ptr, NSRect rect);

    private static native void nSetViewbox(long ptr, NSRect rect);

    private static native int nGetViewboxUnits(long ptr);

    private static native void nSetViewboxUnits(long ptr, int value);

    private static native void nGetViewport(long ptr, NSRect rect);

    private static native void nSetViewport(long ptr, NSRect rect);

    private static native int nGetViewportUnits(long ptr);

    private static native void nSetViewportUnits(long ptr, int value);

    private static native long nAlignmentXProperty();

    private static native long nAlignmentYProperty();

    private static native long nStretchProperty();

    private static native long nTileModeProperty();

    private static native long nViewboxProperty();

    private static native long nViewboxUnitsProperty();

    private static native long nViewportProperty();

    private static native long nViewportUnitsProperty();
}
