package dev.sixik.noesisgui.nsgui;

/**
 * Specifies the rows or columns that are resized by a GridSplitter control.
 */
public enum NSGui_GridResizeBehavior {

    /**
     * Space is redistributed based on the value of the HorizontalAlignment and
     * VerticalAlignment properties.
     */
    GridResizeBehavior_BasedOnAlignment,

    /**
     * For a horizontal GridSplitter, space is redistributed between the row that is specified
     * for the GridSplitter and the next row that is below it. For a vertical GridSplitter,
     * space is redistributed between the column that is specified for the GridSplitter and
     * the next column that is to the right.
     */
    GridResizeBehavior_CurrentAndNext,

    /**
     * For a horizontal GridSplitter, space is redistributed between the row that is specified
     * for the GridSplitter and the next row that is above it. For a vertical GridSplitter,
     * space is redistributed between the column that is specified for the GridSplitter and
     * the next column that is to the left.
     */
    GridResizeBehavior_PreviousAndCurrent,

    /**
     * For a horizontal GridSplitter, space is redistributed between the rows that are above
     * and below the row that is specified for the GridSplitter. For a vertical GridSplitter,
     * space is redistributed between the columns that are to the left and right of the column
     * that is specified for the GridSplitter.
     */
    GridResizeBehavior_PreviousAndNext
}
