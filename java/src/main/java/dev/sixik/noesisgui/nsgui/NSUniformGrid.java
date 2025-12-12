package dev.sixik.noesisgui.nsgui;

/**
 * Provides a way to arrange content in a grid where all the cells in the grid have the same size.
 *
 * <h3>XAML Example:</h3>
 * <pre>{@code
 * <Grid xmlns="http://schemas.microsoft.com/winfx/2006/xaml/presentation"
 *     Height="200" Width="250">
 *   <UniformGrid>
 *     <Button Content="Button 1"/>
 *     <Button Content="Button 2"/>
 *     <Button Content="Button 3"/>
 *     <Button Content="Button 4"/>
 *   </UniformGrid>
 * </Grid>
 * }</pre>
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.primitives.uniformgrid.aspx">
 *      Microsoft Documentation: UniformGrid Class</a>
 */
public class NSUniformGrid extends NSPanel {

    public NSUniformGrid() {
        this(nCreate());
    }

    public NSUniformGrid(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets the number of leading blank cells in the first row of the grid
     */
    public final long getFirstColumn() {
        return nGetFirstColumn(getPtr());
    }

    /**
     * Gets or sets the number of leading blank cells in the first row of the grid
     */
    public final void setFirstColumn(final long firstColumn) {
        nSetFirstColumn(getPtr(), firstColumn);
    }

    /**
     * Gets or set the number of columns that are in the grid
     */
    public final long getColumns() {
        return nGetColumns(getPtr());
    }

    /**
     * Gets or set the number of columns that are in the grid
     */
    public final void setColumns(final long columns) {
        nSetColumns(getPtr(), columns);
    }

    /**
     * Gets or sets the number of rows that are in the grid
     */
    public final long getRows() {
        return nGetRows(getPtr());
    }

    /**
     * Gets or sets the number of rows that are in the grid
     */
    public final void setRows(final long rows) {
        nSetRows(getPtr(), rows);
    }

    private static native long nCreate();

    private static native long nGetFirstColumn(long ptr);

    private static native void nSetFirstColumn(long ptr, long value);

    private static native long nGetColumns(long ptr);

    private static native void nSetColumns(long ptr, long value);

    private static native long nGetRows(long ptr);

    private static native void nSetRows(long ptr, long value);
}
