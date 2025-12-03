package dev.sixik.noesisgui.nsrenderer;

/**
 * Render batch information
 */
public class NSBatch {

    /**
     * Render state
     */
    public NSShader shader;
    public NSRenderState renderState;
    public short stencilRef;

    /**
     * Single Pass Stereo renders both left and right eye images at the same time
     */
    public boolean singlePassStereo;

    /**
     * Information about the list of indexed triangles to be rendered. The offset in bytes to the
     * last pointer returned by MapVertices() is stored in 'vertexOffset'. Indices are 16 bits each
     * and they start at the last pointer returned by MapIndices() plus 'startIndex' x 2 bytes
     */
    public int vertexOffset;
    public int numVertices;
    public int startIndex;
    public int numIndices;

    /**
     * Textures. Unused textures are set to null <br>
     * Pointer to {@link NSTexture}
     */
    public long texture_ptr_pattern;
    public long texture_ptr_ramps;
    public long texture_ptr_image;
    public long texture_ptr_glyphs;
    public long texture_ptr_shadow;

    /**
     * Sampler states corresponding to each texture
     */
    public NSSamplerState patternSampler;
    public NSSamplerState rampsSampler;
    public NSSamplerState imageSampler;
    public NSSamplerState glyphsSampler;
    public NSSamplerState shadowSampler;

    /**
     * Vertex and pixel shader uniform buffers
     */
    public final NSUniformData[] vertexUniforms = new NSUniformData[2];
    public final NSUniformData[] pixelUniforms = new NSUniformData[2];

    /**
     * Custom pointer set in ShaderEffect::SetPixelShader() or BrushShader::SetPixelShader()
     */
    public long pixelShader_ptr;
}
