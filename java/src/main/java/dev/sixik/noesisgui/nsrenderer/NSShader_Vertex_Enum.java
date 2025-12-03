package dev.sixik.noesisgui.nsrenderer;

/**
 * Vertex shaders for each Noesis::Shader (see table VertexForShader[])
 */
public enum NSShader_Vertex_Enum {

    Pos,
    PosColor,
    PosTex0,
    PosTex0Rect,
    PosTex0RectTile,
    PosColorCoverage,
    PosTex0Coverage,
    PosTex0CoverageRect,
    PosTex0CoverageRectTile,
    PosColorTex1_SDF,
    PosTex0Tex1_SDF,
    PosTex0Tex1Rect_SDF,
    PosTex0Tex1RectTile_SDF,
    PosColorTex1,
    PosTex0Tex1,
    PosTex0Tex1Rect,
    PosTex0Tex1RectTile,
    PosColorTex0Tex1,
    PosTex0Tex1_Downsample,
    PosColorTex1Rect,
    PosColorTex0RectImagePos,

    Count
}
