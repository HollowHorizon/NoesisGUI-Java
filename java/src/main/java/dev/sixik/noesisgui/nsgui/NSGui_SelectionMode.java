package dev.sixik.noesisgui.nsgui;

public enum NSGui_SelectionMode {

    /**
     * The user can select only one item at a time. This is the default mode
     */
    SelectionMode_Single,

    /**
     * The user can select multiple items without holding down a modifier key
     */
    SelectionMode_Multiple,

    /**
     * The user can select multiple consecutive items while holding down the SHIFT key
     */
    SelectionMode_Extended
}
