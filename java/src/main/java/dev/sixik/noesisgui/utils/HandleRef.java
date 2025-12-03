package dev.sixik.noesisgui.utils;

public class HandleRef {

    private Object _wrapper;
    private long ptr;

    public HandleRef(Object _wrapper, long ptr) {
        this._wrapper = _wrapper;
        this.ptr = ptr;
    }

    public long getPtr() {
        return ptr;
    }

    public Object getWrapper() {
        return _wrapper;
    }
}
