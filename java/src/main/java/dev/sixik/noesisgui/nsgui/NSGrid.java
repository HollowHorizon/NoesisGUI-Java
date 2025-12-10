package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.NoesisGui;
import dev.sixik.noesisgui.nscore.NSDependencyObject;

/**
 * Defines a flexible grid area that consists of columns and rows.
 * <p>
 * A Grid contains a collection of UIElement objects, which are in the Children property.
 * <p>
 * Columns and rows that are defined within a Grid can take advantage of Star sizing to distribute
 * remaining space proportionally. When Star is selected as the height or width of a row or column,
 * that column or row receives a weighted proportion of the remaining available space. This is in
 * contrast to Auto, which distributes space evenly based on the size of the content that is within
 * a column or row. This value is expressed as * or 2* when you use Extensible Application
 * Markup Language (XAML). In the first case, the row or column would receive one times the
 * available space, while in the second case, the row or column would receive two times the
 * available space, and so on. By combining this technique to proportionally distribute space with
 * a HorizontalAlignment and VerticalAlignment value of Stretch, it is possible to partition layout
 * space by percentage of screen space. Grid is the only layout panel that can distribute space in
 * this manner.
 * <p>
 * By default, rows and columns take up the least amount of space necessary to accommodate the
 * largest content within any cell contained in a given row or column. For example, if a column has
 * one cell with a long word like "hippopotamus" contained within it but all the other cells in the
 * column have smaller words like "dog", the width of the column will be the width of the largest
 * word (hippopotamus).
 * <p>
 * You can precisely position child elements of a Grid by using a combination of the Margin
 * property and alignment properties.
 * <p>
 * Child elements of a Grid are drawn in the order in which they appear in markup or code. As a
 * consequence, layered order (also known as z-order) can be achieved when elements share the same
 * coordinates.
 * <p>
 * Grid uses the GridLength object to define the sizing characteristics of a RowDefinition or
 * ColumnDefinition. For a definition of each unit type, see GridUnitType.
 * <p>
 * If a child element is added to a column within a Grid, and the column has its Width property set
 * to Auto, the child will be measured without restrictions. This behavior can prevent horizontal
 * scroll bars from displaying if a ScrollViewer is being used, as the child element is measured as
 * unbounded. For purposes of display, the child is clipped rather than scrolled.
 *
 * <h3>XAML Example:</h3>
 * <pre>{@code
 * <Grid Width="400" Height="400">
 *   <Grid.ColumnDefinitions>
 *     <ColumnDefinition Width="100" />
 *     <ColumnDefinition Width="*" />
 *   </Grid.ColumnDefinitions>
 *   <Grid.RowDefinitions>
 *     <RowDefinition Height="50" />
 *     <RowDefinition Height="*" />
 *     <RowDefinition Height="50" />
 *   </Grid.RowDefinitions>
 *   <Rectangle Grid.Row="0" Grid.Column="0" Grid.ColumnSpan="2" Fill="YellowGreen" />
 *   <Rectangle Grid.Row="1" Grid.Column="0" Fill="Gray" />
 *   <Rectangle Grid.Row="1" Grid.Column="1" Fill="Silver" />
 *   <Rectangle Grid.Row="2" Grid.Column="0" Grid.ColumnSpan="2" Fill="Orange" />
 * </Grid>
 * }</pre>
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.grid.aspx">
 *      Microsoft Documentation: Grid Class</a>
 */
public class NSGrid extends NSPanel {

    public NSGrid() {
        this(nCreate());
    }

    public NSGrid(long ptr) {
        super(ptr);
    }

    /**
     * Gets a ColumnDefinitionCollection defined on this instance of Grid
     */
    public final NSColumnDefinitionCollection getColumnDefinitions() {
        return new NSColumnDefinitionCollection(nGetColumnDefinitions(getPtr()));
    }

    /**
     * Gets a RowDefinitionCollection defined on this instance of Grid
     */
    public final NSRowDefinitionCollection getRowDefinitions() {
        return new NSRowDefinitionCollection(nGetRowDefinitions(getPtr()));
    }

    /**
     * Gets or sets a value that indicates which column child within a Grid should appear in
     */
    public static int getColumn(final NSDependencyObject element) {
        return NoesisGui.toSignedInt(nGetColumn(element.getPtr()));
    }

    /**
     * Gets or sets a value that indicates which column child within a Grid should appear in
     */
    public static void setColumn(final NSDependencyObject element, int column){
        nSetColumn(element.getPtr(), column);
    }

    /**
     * Gets or sets a value that indicates the number of columns that child spans within a Grid
     */
    public static int getColumnSpan(final NSDependencyObject element) {
        return NoesisGui.toSignedInt(nGetColumnSpan(element.getPtr()));
    }

    /**
     * Gets or sets a value that indicates the number of columns that child spans within a Grid
     */
    public static void setColumnSpan(final NSDependencyObject element, int column_span) {
        nSetColumnSpan(element.getPtr(), column_span);
    }

    /**
     * Gets or sets a value that indicates that multiple Grid elements are sharing size information
     */
    public static boolean getIsSharedSizeScope(final NSDependencyObject element) {
        return nGetIsSharedSizeScope(element.getPtr());
    }

    /**
     * Gets or sets a value that indicates that multiple Grid elements are sharing size information
     */
    public static void setIsSharedSizeScope(final NSDependencyObject element, final boolean value) {
        nSetIsSharedSizeScope(element.getPtr(), value);
    }

    /**
     * Gets or sets a value that indicates which row child within a Grid should appear in
     */
    public static int getRow(final NSDependencyObject element) {
        return NoesisGui.toSignedInt(nGetRow(element.getPtr()));
    }

    /**
     * Gets or sets a value that indicates which row child within a Grid should appear in
     */
    public static void setRow(final NSDependencyObject element, final int row) {
        nSetRow(element.getPtr(), row);
    }

    /**
     * Gets or sets a value that indicates the number of rows that child spans within a Grid
     */
    public static int getRowSpan(final NSDependencyObject element) {
        return NoesisGui.toSignedInt(nGetRowSpan(element.getPtr()));
    }

    /**
     * Gets or sets a value that indicates the number of rows that child spans within a Grid
     */
    public static void setRowSpan(final NSDependencyObject element, final int rowSpan) {
        nSetRowSpan(element.getPtr(), rowSpan);
    }

    private static native long nCreate();

    private static native long nGetColumnDefinitions(long ptr);

    private static native long nGetRowDefinitions(long ptr);

    private static native long nGetColumn(long element_ptr);

    private static native void nSetColumn(long element_ptr, int column);

    private static native long nGetColumnSpan(long element_ptr);

    private static native void nSetColumnSpan(long element_ptr, int column_span);

    private static native boolean nGetIsSharedSizeScope(long element_ptr);

    private static native void nSetIsSharedSizeScope(long element_ptr, boolean value);

    private static native long nGetRow(long element_ptr);

    private static native void nSetRow(long element_ptr, int row);

    private static native long nGetRowSpan(long element_ptr);

    private static native void nSetRowSpan(long element_ptr, int rowSpan);
}
