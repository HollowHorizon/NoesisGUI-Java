package dev.sixik.noesisgui.nsgui;

/**
 * Specifies whether a GridSplitter control redistributes space between rows or between columns.
 */
public enum NSGui_GridResizeDirection {

    /**
     * Space is redistributed based on the values of the HorizontalAlignment, VerticalAlignment,
     * ActualWidth, and ActualHeight properties of the GridSplitter.
     */
    GridResizeDirection_Auto,

    /**
     * Space is redistributed between columns.
     */
    GridResizeDirection_Columns,

    /**
     * Space is redistributed between rows.
     */
    GridResizeDirection_Rows
}
