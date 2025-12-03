package dev.sixik.noesisgui.nsrenderer;

/**
 * This is the high-level shader description that gets sent in each draw call.
 * Implementations must map this to corresponding low-level shaders and layouts
 */
public class NSShader_Enum {

    /**
     * Shader for debug modes
     */
    public static final int RGBA = 0;

    /**
     * Stencil-only rendering for masks
     */
    public static final int Mask = 1;

    /**
     * Shader used for clearing render target
     */
    public static final int Clear = 2;

    /**
     * Shaders for rendering geometry paths without PPAA
     */
    public static final int Path_Solid = 3;
    public static final int Path_Linear = 4;
    public static final int Path_Radial = 5;
    public static final int Path_Pattern = 6;
    public static final int Path_Pattern_Clamp = 7;
    public static final int Path_Pattern_Repeat = 8;
    public static final int Path_Pattern_MirrorU = 9;
    public static final int Path_Pattern_MirrorV = 10;
    public static final int Path_Pattern_Mirror = 11;

    /**
     * Shaders for rendering geometry paths with PPAA
     */
    public static final int Path_AA_Solid = 12;
    public static final int Path_AA_Linear = 13;
    public static final int Path_AA_Radial = 14;
    public static final int Path_AA_Pattern = 15;
    public static final int Path_AA_Pattern_Clamp = 16;
    public static final int Path_AA_Pattern_Repeat = 17;
    public static final int Path_AA_Pattern_MirrorU = 18;
    public static final int Path_AA_Pattern_MirrorV = 19;
    public static final int Path_AA_Pattern_Mirror = 20;

    /**
     * Shaders for rendering distance fields
     */
    public static final int SDF_Solid = 21;
    public static final int SDF_Linear = 22;
    public static final int SDF_Radial = 23;
    public static final int SDF_Pattern = 24;
    public static final int SDF_Pattern_Clamp = 25;
    public static final int SDF_Pattern_Repeat = 26;
    public static final int SDF_Pattern_MirrorU = 27;
    public static final int SDF_Pattern_MirrorV = 28;
    public static final int SDF_Pattern_Mirror = 29;

    /**
     * Shaders for rendering distance fields with subpixel rendering.
     * These shaders are only used when the device reports support for
     * subpixel rendering in DeviceCaps. Otherwise SDF_* shaders are used
     */
    public static final int SDF_LCD_Solid = 30;
    public static final int SDF_LCD_Linear = 31;
    public static final int SDF_LCD_Radial = 32;
    public static final int SDF_LCD_Pattern = 33;
    public static final int SDF_LCD_Pattern_Clamp = 34;
    public static final int SDF_LCD_Pattern_Repeat = 35;
    public static final int SDF_LCD_Pattern_MirrorU = 36;
    public static final int SDF_LCD_Pattern_MirrorV = 37;
    public static final int SDF_LCD_Pattern_Mirror = 38;

    /**
     * Shaders for offscreen rendering
     */
    public static final int Opacity_Solid = 39;
    public static final int Opacity_Linear = 40;
    public static final int Opacity_Radial = 41;
    public static final int Opacity_Pattern = 42;
    public static final int Opacity_Pattern_Clamp = 43;
    public static final int Opacity_Pattern_Repeat = 44;
    public static final int Opacity_Pattern_MirrorU = 45;
    public static final int Opacity_Pattern_MirrorV = 46;
    public static final int Opacity_Pattern_Mirror = 47;

    public static final int Upsample = 48;
    public static final int Downsample = 49;

    public static final int Shadow = 50;
    public static final int Blur = 51;
    public static final int Custom_Effect = 52;

    public static final int Count = 53;
}
