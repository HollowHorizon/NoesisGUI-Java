package dev.sixik.noesisgui.nsrenderer;

import dev.sixik.noesisgui.nscore.NSBaseComponent;

public class NSRenderTarget extends NSBaseComponent {

    public NSRenderTarget(long ptr) {
        super(ptr);
    }

    public long getTexturePtr() {
        return nativeGetTexturePtr(getPtr());
    }

    private static native long nativeGetTexturePtr(long ptr);
}
