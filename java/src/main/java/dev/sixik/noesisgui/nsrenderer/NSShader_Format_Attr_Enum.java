package dev.sixik.noesisgui.nsrenderer;

/**
 * Attributes for each vertex format (see tables AttributesForFormat[] and SizeForFormat[])
 */
public enum NSShader_Format_Attr_Enum {

    //  --------------------------------------------------------------------------------
    //  Attr                  Interpolation      Semantic
    //  --------------------------------------------------------------------------------
    Pos,             //   linear             Position (xy)
    Color,           //   nointerpolation    sRGB Color (rgba)
    Tex0,            //   linear             TexCoord0 (uv)
    Tex1,            //   linear             TexCoord1 (uv)
    Coverage,        //   linear             Coverage (alpha)
    Rect,            //   nointerpolation    Rect (x0, y0, x1, y1)
    Tile,            //   nointerpolation    Rect (x, y, width, height)
    ImagePos,        //   linear             Position (xy) - Scale(zw)

    Count
}
