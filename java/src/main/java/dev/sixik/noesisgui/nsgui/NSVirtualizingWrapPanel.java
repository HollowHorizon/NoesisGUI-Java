package dev.sixik.noesisgui.nsgui;

/**
 * A high-performance WrapPanel that supports UI virtualization, designed for use in both
 * horizontal and vertical layouts.
 * <p>
 * This panel arranges its child elements sequentially in a wrapping fashion, either horizontally
 * or vertically, and only creates UI elements that are visible within the viewport, reducing
 * memory usage and improving rendering performance for large collections.
 *
 * <h3>XAML Example:</h3>
 * <pre>{@code
 * <Grid
 *   xmlns="http://schemas.microsoft.com/winfx/2006/xaml/presentation"
 *   xmlns:x="http://schemas.microsoft.com/winfx/2006/xaml">
 *   <ItemsControl ItemsSource="{Binding List}"
 *       ScrollViewer.CanContentScroll="True"
 *       VirtualizingPanel.IsVirtualizing="True"
 *       VirtualizingPanel.ScrollUnit="Pixel">
 *     <ItemsControl.Template>
 *       <ControlTemplate TargetType="ItemsControl">
 *         <ScrollViewer Focusable="False" Background="Silver">
 *           <ItemsPresenter/>
 *         </ScrollViewer>
 *       </ControlTemplate>
 *     </ItemsControl.Template>
 *     <ItemsControl.ItemsPanel>
 *       <ItemsPanelTemplate>
 *         <VirtualizingWrapPanel Orientation="Horizontal"/>
 *       </ItemsPanelTemplate>
 *     </ItemsControl.ItemsPanel>
 *     <ItemsControl.ItemTemplate>
 *       <DataTemplate>
 *         <Rectangle Stroke="Black" Fill="{Binding Color}"
 *             Width="{Binding SizeX}" Height="{Binding SizeY}"/>
 *       </DataTemplate>
 *     </ItemsControl.ItemTemplate>
 *   </ItemsControl>
 * </Grid>
 * }</pre>
 */
public class NSVirtualizingWrapPanel extends NSVirtualizingPanel {

    public NSVirtualizingWrapPanel() {
        this(nCreate());
    }

    public NSVirtualizingWrapPanel(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets a value that specifies the width of all items contained in the panel
     */
    public final float getItemWidth() {
        return nGetItemWidth(getPtr());
    }

    /**
     * Gets or sets a value that specifies the width of all items contained in the panel
     */
    public final void setItemWidth(final float value) {
        nSetItemWidth(getPtr(), value);
    }

    /**
     * Gets or sets a value that specifies the height of all items contained in the panel
     */
    public final float getItemHeight() {
        return nGetItemHeight(getPtr());
    }

    /**
     * Gets or sets a value that specifies the height of all items contained in the panel
     */
    public final void setItemHeight(final float value) {
        nSetItemHeight(getPtr(), value);
    }

    /**
     * Gets or sets orientation of children elements
     */
    public final NSGui_Orientation getOrientation() {
        return NSGui_Orientation.values()[nGetOrientation(getPtr())];
    }

    /**
     * Gets or sets orientation of children elements
     */
    public final void setOrientation(final NSGui_Orientation orientation) {
        nSetOrientation(getPtr(), orientation.ordinal());
    }

    private static native long nCreate();

    private static native float nGetItemWidth(long ptr);

    private static native void nSetItemWidth(long ptr, float value);

    private static native float nGetItemHeight(long ptr);

    private static native void nSetItemHeight(long ptr, float value);

    private static native int nGetOrientation(long ptr);

    private static native void nSetOrientation(long ptr, int value);
}
