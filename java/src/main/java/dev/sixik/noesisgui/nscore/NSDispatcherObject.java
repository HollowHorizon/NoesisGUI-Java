package dev.sixik.noesisgui.nscore;

/**
 * Represents an object with thread affinity.
 * <p>
 * This object can be accessed only from the thread on which it was created. Subclasses of
 * DispatcherObject that need to enforce thread safety can do so by calling {@code VerifyAccess} on all
 * public methods. This guarantees the calling thread is the thread that the DispatcherObject was
 * created on.
 *
 * @see <a href="https://msdn.microsoft.com/en-us/library/system.windows.threading.dispatcherobject.aspx">
 *      Microsoft Documentation: DispatcherObject Class</a>
 */
public class NSDispatcherObject extends NSBaseComponent{

    public NSDispatcherObject(long ptr) {
        super(ptr);
    }

    /**
     * Gets the thread this DispatcherObject is associated with.
     * Returns NoThreadId when this object is not attached to any thread.
     */
    public final long getThreadId() {
        return nativeGetThreadId(getPtr());
    }

    /**
     * Determines whether the calling thread has access to this DispatcherObject
     */
    public final boolean checkAccess() {
        return nativeCheckAccess(getPtr());
    }

    /**
     * Enforces that the calling thread has access to this DispatcherObject
     */
    public final void verifyAccess() {
        nativeVerifyAccess(getPtr());
    }

    private static native boolean nativeCheckAccess(long ptr);

    private static native long nativeGetThreadId(long ptr);

    private static native void nativeVerifyAccess(long ptr);
}
