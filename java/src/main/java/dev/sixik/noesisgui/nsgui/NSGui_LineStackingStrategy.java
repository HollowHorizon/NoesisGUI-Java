package dev.sixik.noesisgui.nsgui;

/**
 * Describes a mechanism by which a line box is determined for each line
 */
public enum NSGui_LineStackingStrategy {

    /**
     * The stack height is determined by the block element line-height property value
     */
    LineStackingStrategy_BlockLineHeight,

    /**
     * The stack height is the smallest value that containing all the inline elements on that line
     * when those elements are properly aligned
     */
    LineStackingStrategy_MaxHeight
}
