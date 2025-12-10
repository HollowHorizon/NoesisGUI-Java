package dev.sixik.noesisgui.nsgui;

/**
 * Specifies when the Click event should fire
 */
public enum NSGui_ClickMode {

    /**
     * The Click event should fire when the mouse hovers over a control
     */
    ClickMode_Hover,

    /**
     * The Click event will occur as soon as a button is pressed
     */
    ClickMode_Press,

    /**
     * The Click event will occur when a button is pressed and released
     */
    ClickMode_Release
}
