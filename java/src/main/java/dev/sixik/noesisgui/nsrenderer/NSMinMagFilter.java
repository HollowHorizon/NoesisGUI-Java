package dev.sixik.noesisgui.nsrenderer;

/**
 * Texture minification and magnification filter
 */
public enum NSMinMagFilter {

    /**
     * Select the single pixel nearest to the sample point
     */
    Nearest,

    /**
     * Select two pixels in each dimension and interpolate linearly between them
     */
    Linear,

    Count
}
