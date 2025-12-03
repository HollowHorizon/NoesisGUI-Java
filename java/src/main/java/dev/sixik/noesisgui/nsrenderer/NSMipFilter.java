package dev.sixik.noesisgui.nsrenderer;

/**
 * Texture Mipmap filter
 */
public enum NSMipFilter {

    /**
     * Texture sampled from mipmap level 0
     */
    Disabled,
    // The nearest mipmap level is selected
    Nearest,
    // Both nearest levels are sampled and linearly interpolated
    Linear,

    Count
}
