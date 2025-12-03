package dev.sixik.noesisgui.nsrenderer;

/**
 * Types for each vertex format attribute (see tables TypeForAttr[] and SizeForType[])
 */
public enum NSShader_Format_Attr_Type_Enum {

    /**
     * One 32-bit floating-point component
     */
    Float,
    /**
     * Two 32-bit floating-point components
     */
    Float2,
    /**
     * Four 32-bit floating-point components
     */
    Float4,
    /**
     * Four 8-bit normalized unsigned integer components
     */
    UByte4Norm,
    /**
     * Four 16-bit normalized unsigned integer components
     */
    UShort4Norm,

    Count
}
