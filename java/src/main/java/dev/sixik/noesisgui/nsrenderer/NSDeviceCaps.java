package dev.sixik.noesisgui.nsrenderer;

/**
 * Render device capabilities
 */
public class NSDeviceCaps {

    /**
     * Offset in pixel units from top-left corner to center of pixel
     */
    public float centerPixelOffset = 0.0f;

    /**
     * When this flag is enabled the device works in 'Linear' mode. All internal textures and
     * offscreens are created in 'sRGB' format. In this mode, the device also expects colors
     * (like the ones in the vertex buffer) in 'sRGB' format. It also indicates that the device
     * writes to the render target in linear space
     */
    public boolean linearRendering = false;

    /**
     * This flag is enabled to indicate that the device supports LCD subpixel rendering. Extra
     * shaders and dual source blending are needed for this feature
     */
    public boolean subpixelRendering = false;

    /**
     * Indicates whether the device clip space depth values range from 0 to 1
     */
    public boolean depthRangeZeroToOne = true;

    /**
     * Whether the device clip space Y values are inverted (increase from top (-1) to bottom (1))
     */
    public boolean clipSpaceYInverted = false;
}
