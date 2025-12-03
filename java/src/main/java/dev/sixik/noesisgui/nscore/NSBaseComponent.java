package dev.sixik.noesisgui.nscore;

import dev.sixik.noesisgui.utils.PtrObject;

public abstract class NSBaseComponent extends PtrObject implements AutoCloseable{

    public NSBaseComponent(long ptr) {
        super(ptr);
    }

    @Override
    public void close() {
        final var ptr = getPtr();
        if(ptr != 0) {
            nativeFree(ptr);
            ptrClear();
        }
    }

    private static native void nativeFree(long ptr);
}
