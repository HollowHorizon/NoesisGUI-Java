package dev.sixik.noesisgui.nsrenderer;

import dev.sixik.noesisgui.nscore.NSBaseComponent;

import java.nio.ByteBuffer;

////////////////////////////////////////////////////////////////////////////////////////////////////
/// Typical frame workflow:
///
/// - Update dynamic textures (if needed)
///   - UpdateTexture(),  UpdateTexture(), ...
///   - EndUpdatingTextures()
///
/// - Offscreen render phase (if needed)
///   - BeginOffscreenRender()
///     - MapVertices(), MapIndices()
///     - For each RenderTarget:
///       - SetRenderTarget()
///       - For each tile:
///         - BeginTile()
///           - DrawBatch(), DrawBatch(), ...
///         - EndTile()
///       - ResolveRenderTarget()
///   - EndOffscreenRender()
///
/// - Onscreen render phase
///   - BeginOnscreenRender()
///     - MapVertices(), MapIndices()
///     - DrawBatch(), DrawBatch(), ...
///   - EndOnscreenRender()
///
////////////////////////////////////////////////////////////////////////////////////////////////////
public class NSRenderDevice extends NSBaseComponent {

    /**
     * Table for getting the vertex shader corresponding to each Noesis::Shader
     * Noesis::Shader => Noesis::Shader::Vertex
     */
    public static final short[] VertexForShader = new short[]{
            0, 0, 0, 1, 2, 2, 2, 3, 4, 4, 4, 4, 5, 6, 6, 6, 7, 8, 8, 8, 8, 9, 10, 10, 10, 11, 12, 12, 12,
            12, 9, 10, 10, 10, 11, 12, 12, 12, 12, 13, 14, 14, 14, 15, 16, 16, 16, 16, 17, 18, 19, 13, 20
    };

    /**
     * Table for getting the vertex format corresponding to each vertex shader
     * Noesis::Shader::Vertex => Noesis::Shader::Vertex::Format
     */
    public static final short[] FormatForVertex = new short[]{
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 9, 10, 11, 12, 13, 10, 14, 15
    };

    /**
     * Size in bytes for each vertex format
     */
    public static final short[] SizeForFormat = new short[]{
            8, 12, 16, 24, 40, 16, 20, 28, 44, 20, 24, 32, 48, 28, 28, 44
    };

    /**
     * Table for getting the attribute bitmask corresponding to each vertex format
     */
    public static final short[] AttributesForFormat = new short[]{
            1, 3, 5, 37, 101, 19, 21, 53, 117, 11, 13, 45, 109, 15, 43, 167
    };

    /**
     * Table for getting the type corresponding to each vertex format attribute
     * Noesis::Shader::Vertex::Format::Attr => Noesis::Shader::Vertex::Format::Attr::Type
     */
    public static final short[] TypeForAttr = new short[]{
            1, 3, 1, 1, 0, 4, 2, 2
    };

    /**
     * Table for getting the size in bytes corresponding to each vertex format attribute type
     */
    public static final short[] SizeForType = new short[]{
            4, 8, 16, 4, 8
    };

    public NSRenderDevice(long ptr) {
        super(ptr);
    }

    /**
     * Retrieves device render capabilities
     *
     * @param cap The object that the information will be recorded in
     */
    public final void getCaps(NSDeviceCaps cap) {
        nativeGetCaps(getPtr(), cap);
    }

    /**
     * Creates render target surface with given dimensions, samples and optional stencil buffer
     */
    public final NSRenderTarget createRenderTarget(String label, int width, int height, int sampleCount, boolean needsStencil) {
        return new NSRenderTarget(nativeCreateRenderTarget(getPtr(), label, width, height, sampleCount, needsStencil));
    }

    /**
     * Creates render target sharing transient (stencil, colorAA) buffers with the given surface
     */
    public final NSRenderTarget cloneRenderTarget(String label, NSRenderTarget target) {
        return new NSRenderTarget(nativeCloneRenderTarget(getPtr(), label, target.getPtr()));
    }

    public final NSTexture createTexture(String label, int width, int height, int numLevels, NSTextureFormat format) {
        return createTexture(label, width, height, numLevels, format, null);
    }

    /**
     * Creates texture with given dimensions and format. For immutable textures, the content of
     * each mipmap is given in 'data'. The passed data is tightly packed (no extra pitch). When
     * 'data' is null the texture is considered dynamic and will be updated using UpdateTexture()
     */
    public final NSTexture createTexture(String label, int width, int height, int numLevels, NSTextureFormat format, ByteBuffer[] mipLevels) {
        return new NSTexture(nativeCreateTexture(getPtr(), label, width, height, numLevels, format.ordinal(), mipLevels));
    }

    /**
     * Updates a region of a texture mip level by copying the given data to the specified position.
     * The data is tightly packed (no extra pitch) and never larger than DYNAMIC_TEX_SIZE bytes.
     * The origin is at the left of the first scanline. This function may be called multiple times
     * per texture. Before entering a render pass, EndUpdatingTextures() will be invoked
     */
    public final void updateTexture(NSTexture texture, int level, int x, int y, int w, int h, ByteBuffer buffer) {
        nativeUpdateTexture(getPtr(), texture.getPtr(), level, x, y, w, h, buffer);
    }

    public final void endUpdatingTextures(NSTexture texture) {
        nativeEndUpdatingTextures(getPtr(), new long[]{texture.getPtr()}, 1);
    }

    /**
     * Called to mark the end of updates for one or more dynamic textures. It is only invoked for
     * textures that were previously modified with UpdateTexture(), and indicates that they are
     * now ready to be used in the upcoming render pass. This function is never called from within
     * a render pass. Implementations may perform the necessary synchronization or state transitions
     * (e.g., from copy/write to shader-read)
     */
    public final void endUpdatingTextures(NSTexture[] textures) {
        long[] ptrs = new long[textures.length];
        for (int i = 0; i < textures.length; i++) {
            ptrs[i] = textures[i].getPtr();
        }
        nativeEndUpdatingTextures(getPtr(), ptrs, ptrs.length);
    }

    /**
     * Begins rendering offscreen commands
     */
    public final void beginOffscreenRender() {
        nativeBeginOffscreenRender(getPtr());
    }

    /**
     * Begins rendering offscreen commands
     */
    public final void endOffscreenRender() {
        nativeEndOffscreenRender(getPtr());
    }

    /**
     * Begins rendering onscreen commands
     */
    public final void beginOnscreenRender() {
        nativeBeginOnscreenRender(getPtr());
    }

    /**
     * Ends rendering onscreen commands
     */
    public final void endOnscreenRender() {
        nativeEndOnscreenRender(getPtr());
    }

    private static native void nativeGetCaps(long ptr, NSDeviceCaps cap);

    private static native long nativeCreateRenderTarget(long ptr, String label, int width, int height, int sampleCount, boolean needsStencil);

    private static native long nativeCloneRenderTarget(long mainPtr, String label, long ptr);

    private static native long nativeCreateTexture(long mainPtr, String label, int width, int height, int numLevels, int format, ByteBuffer[] mipLevels);

    private static native void nativeUpdateTexture(long mainPtr, long ptr, int level, int x, int y, int w, int h, ByteBuffer buffer);

    private static native void nativeEndUpdatingTextures(long mainPtr, long[] ptr, int count);

    private static native void nativeBeginOffscreenRender(long ptr);

    private static native void nativeEndOffscreenRender(long ptr);

    private static native void nativeBeginOnscreenRender(long ptr);

    private static native void nativeEndOnscreenRender(long ptr);

    private static native void nativeSetRenderTarget(long mainPtr, long render_target_ptr);

    private static native void nativeBeginTile(long mainPtr, long render_target_ptr, NSTile tile);

    private static native void nativeEndTile(long mainPtr, long render_target_ptr);

    private static native void nativeResolveRenderTarget(long mainPtr, long render_target_ptr, long tile_ptr, int num_tiles);

    private static native void nativeMapVertices(long mainPtr, int bytes);

    private static native void nativeUnmapVertices(long mainPtr);

    private static native void nativeMapIndices(long mainPtr, int bytes);

    private static native void nativeUnmapIndices(long mainPtr);

    private static native void nativeDrawBatch(long mainPtr, long batch_ptr);

    private static native void nativeSetOffscreenWidth(long mainPtr, int width);

    private static native int nativeGetOffscreenWidth(long mainPtr);

    private static native void nativeSetOffscreenHeight(long mainPtr, int height);

    private static native int nativeGetOffscreenHeight(long mainPtr);

    private static native void nativeSetOffscreenSampleCount(long mainPtr, int sampleCount);

    private static native int nativeGetOffscreenSampleCount(long mainPtr);

    private static native void nativeSetOffscreenDefaultNumSurfaces(long mainPtr, int numSurfaces);

    private static native int nativeGetOffscreenDefaultNumSurfaces(long mainPtr);

    private static native void nativeSetOffscreenMaxNumSurfaces(long mainPtr, int numSurfaces);

    private static native int nativeGetOffscreenMaxNumSurfaces(long mainPtr);

    private static native void nativeSetGlyphCacheWidth(long mainPtr, int width);

    private static native int nativeGetGlyphCacheWidth(long mainPtr);

    private static native void nativeSetGlyphCacheHeight(long mainPtr, int height);

    private static native int nativeGetGlyphCacheHeight(long mainPtr);

    private static native void nativeSetVGContext(long mainPtr, long base_component_ptr);

    private static native long nativeGetVGContext(long mainPtr);

    private static native boolean nativeIsValidState(NSShader shader, NSRenderState state);

    private static native boolean nativeIsValidBlendMode(NSShader shader, int blendMode);

    private static native boolean nativeIsValidStencilMode(NSShader shader, int stenciMode);

    private static native boolean nativeIsValidColorEnable(NSShader shader, boolean colorEnable);

    private static native boolean nativeIsValidWireframe(NSShader shader, boolean wireframe);
}

