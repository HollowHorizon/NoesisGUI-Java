package dev.sixik.noesisgui.nsrenderer;

/**
 * Vertex Formats for each vertex shader (see table FormatForVertex[])
 */
public enum NSShader_Format_Enum {

    Pos,
    PosColor,
    PosTex0,
    PosTex0Rect,
    PosTex0RectTile,
    PosColorCoverage,
    PosTex0Coverage,
    PosTex0CoverageRect,
    PosTex0CoverageRectTile,
    PosColorTex1,
    PosTex0Tex1,
    PosTex0Tex1Rect,
    PosTex0Tex1RectTile,
    PosColorTex0Tex1,
    PosColorTex1Rect,
    PosColorTex0RectImagePos,

    Count
}
