package dev.sixik.noesisgui.nsrenderer;

public enum NSStencilMode {

    /**
     * Stencil disabled
     */
    Disabled,

    /**
     * Stencil enabled
     */
    Equal_Keep,

    /**
     * Stencil enabled and incremented
     */
    Equal_Incr,

    /**
     * Stencil enabled and decremented
     */
    Equal_Decr,

    /**
     * Set the stencil data to 0
     */
    Clear,

    /**
     * Stencil disabled and Depth enabled
     */
    Disabled_ZTest,

    /**
     * Stencil disabled and Depth enabled
     */
    Equal_Keep_ZTest,

    Count
}
