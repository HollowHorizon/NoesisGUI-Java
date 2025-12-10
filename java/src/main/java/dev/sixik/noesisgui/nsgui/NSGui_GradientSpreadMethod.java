package dev.sixik.noesisgui.nsgui;

/**
 * Specifies how to draw the gradient outside a gradient brush's gradient vector or space
 */
public enum NSGui_GradientSpreadMethod {

    /**
     * Fill the remaining space with boundary colors (default)
     */
    GradientSpreadMethod_Pad,

    /**
     * Gradient is repeated in the reverse direction
     */
    GradientSpreadMethod_Reflect,

    /**
     * Gradient is repeated in the original direction
     */
    GradientSpreadMethod_Repeat
}
