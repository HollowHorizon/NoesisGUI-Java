package dev.sixik.noesisgui.nsgui;

/**
 * Describes how a TileBrush paints tiles onto an output area
 */
public enum NSGui_TileMode {

    /**
     * The base tile is drawn but not repeated. The remaining area is transparent
     */
    TileMode_None,

    /**
     * The base tile is drawn and the remaining area is filled by repeating the base tile. The
     * right edge of one tile meets the left edge of the next, and similarly for the bottom and
     * top edges
     */
    TileMode_Tile,

    /**
     * The same as Tile except that alternate columns of tiles are flipped horizontally. The base
     * tile itself is not flipped
     */
    TileMode_FlipX,

    /**
     * The same as Tile except that alternate rows of tiles are flipped vertically. The base tile
     * itself is not flipped
     */
    TileMode_FlipY,

    /**
     * The combination of FlipX and FlipY. The base tile itself is not flipped
     */
    TileMode_FlipXY
}
