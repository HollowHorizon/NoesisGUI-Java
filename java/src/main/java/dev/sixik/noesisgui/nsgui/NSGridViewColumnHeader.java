package dev.sixik.noesisgui.nsgui;

/**
 * Represents a column header for a GridViewColumn.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.gridviewcolumnheader.aspx">
 *      Microsoft Documentation: GridViewColumnHeader Class</a>
 */
public class NSGridViewColumnHeader extends NSBaseButton{

    public NSGridViewColumnHeader() {
        this(nCreate());
    }

    public NSGridViewColumnHeader(long ptr) {
        super(ptr);
    }

    /**
     * Gets the GridViewColumn that is associated with the GridViewColumnHeader
     */
    public final NSGridViewColumn getColumn() {
        return new NSGridViewColumn(nGetColumn(getPtr()));
    }

    /**
     * Gets the role of a GridViewColumnHeader
     */
    public final NSGui_GridViewColumnHeaderRole getRole() {
        return NSGui_GridViewColumnHeaderRole.values()[nGetRole(getPtr())];
    }

    private static native long nCreate();

    private static native long nGetColumn(long ptr);

    private static native int nGetRole(long ptr);
}
