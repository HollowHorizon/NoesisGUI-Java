package dev.sixik.noesisgui.nsrenderer;

/**
 * Texture wrapping mode
 */
public enum NSWrapMode {

    /**
     * Clamp between 0.0 and 1.0
     */
    ClampToEdge,

    /**
     * Out of range texture coordinates return transparent zero (0,0,0,0)
     */
    ClampToZero,

    /**
     * Wrap to the other side of the texture
     */
    Repeat,

    /**
     * The same as repeat but flipping horizontally
     */
    MirrorU,

    /**
     * The same as repeat but flipping vertically
     */
    MirrorV,

    /**
     * The combination of MirrorU and MirrorV
     */
    Mirror,

    Count
}
