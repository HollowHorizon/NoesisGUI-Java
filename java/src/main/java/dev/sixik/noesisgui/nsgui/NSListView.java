package dev.sixik.noesisgui.nsgui;

/**
 * Represents a control that displays a list of data items.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.listview.aspx">
 * Microsoft Documentation: ListView Class</a>
 */
public class NSListView extends NSListBox {

    public NSListView() {
        this(nCreate());
    }

    public NSListView(long ptr) {
        super(ptr);
    }

    private static native long nCreate();
}
