package dev.sixik.noesisgui.nsgui;

/**
 * Specifies how ScrollViewer reacts to touch manipulation
 */
public enum NSGui_PanningMode {

    /**
     * The ScrollViewer scrolls horizontally and vertically
     */
    PanningMode_Both,

    /**
     * The ScrollViewer scrolls when the user moves a finger horizontally first. If the user moves
     * the vertically first, the movement is treated as mouse events. After the ScrollViewer begins
     * to scroll, it will scroll horizontally and vertically
     */
    PanningMode_HorizontalFirst,

    /**
     * The ScrollViewer scrolls horizontally only
     */
    PanningMode_HorizontalOnly,

    /**
     * The ScrollViewer does not respond to touch input
     */
    PanningMode_None,

    /**
     * The ScrollViewer scrolls when the user moves a finger vertically first. If the user moves
     * the horizontally first, the movement is treated as mouse events. After the ScrollViewer begins
     * to scroll, it will scroll horizontally and vertically
     */
    PanningMode_VerticalFirst,

    /**
     * The ScrollViewer scrolls vertically only
     */
    PanningMode_VerticalOnly
}
