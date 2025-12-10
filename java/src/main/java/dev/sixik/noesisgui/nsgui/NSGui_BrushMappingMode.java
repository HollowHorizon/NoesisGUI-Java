package dev.sixik.noesisgui.nsgui;

/**
 * Specifies the coordinate system used by a Brush
 */
public enum NSGui_BrushMappingMode {

    /**
     * The coordinate system is not relative to a bounding box. Values are interpreted directly in
     * local space
     */
    BrushMappingMode_Absolute,

    /**
     * The coordinate system is relative to a bounding box: 0 indicates 0 percent of the bounding
     * box, and 1 indicates 100 percent of the bounding box. For example, (0.5, 0.5) describes a
     * point in the middle of the bounding box, and (1, 1) describes a point at the bottom right
     * of the bounding box
     */
    BrushMappingMode_RelativeToBoundingBox
}
