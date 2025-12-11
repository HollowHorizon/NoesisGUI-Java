package dev.sixik.noesisgui.nsgui;

/**
 * Specifies whether text wraps when it reaches the edge of the containing box
 */
public enum NSGui_TextWrapping {

    /**
     * No line wrapping is performed
     */
    TextWrapping_NoWrap,

    /**
     * Line-breaking occurs if the line overflows beyond the available block width, even if the
     * standard line breaking algorithm cannot determine any line break opportunity, as in the
     * case of a very long word constrained in a fixed-width container with no scrolling allowed
     */
    TextWrapping_Wrap,

    /**
     * Line-breaking occurs if the line overflows beyond the available block width. However, a line
     * may overflow beyond the block width if the line breaking algorithm cannot determine a line
     * break opportunity, as in the case of a very long word constrained in a fixed-width container
     * with no scrolling allowed
     */
    TextWrapping_WrapWithOverflow
}
