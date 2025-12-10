package dev.sixik.noesisgui.nsgui;

/**
 * Describes how content is resized to fill its allocated space
 */
public enum NSGui_Stretch {

    /**
     * The content preserves its original size
     */
    Stretch_None,

    /**
     * The content is resized to fill the destination dimensions. The aspect ratio is not preserved
     */
    Stretch_Fill,

    /**
     * The content is resized to fit in the destination dimensions while it preserves its native
     * aspect ratio
     */
    Stretch_Uniform,

    /**
     * The content is resized to fill the destination dimensions while it preserves its native
     * aspect ratio. If the aspect ratio of the destination rectangle differs from the source, the
     * source content is clipped to fit in the destination dimensions.
     */
    Stretch_UniformToFill
}
