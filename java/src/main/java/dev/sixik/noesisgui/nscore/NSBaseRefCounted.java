package dev.sixik.noesisgui.nscore;

/**
 * Base class for types that control their lifetime with a reference counter. Instances of this
 * class are usually stored inside a {@code Ptr} smart pointer. See {@code Ptr} class for more information.
 * <p>
 * The reference counter is initialized to 1 and can be incremented or decremented by using
 * {@code AddReference()} or {@code Release()} respectively. When the reference counter reaches the value zero
 * the instance is destroyed by invoking its destructor.
 * <p>
 * As the lifetime is automatically managed, using {@code delete} on this instances is not recommended.
 * <p>
 * Note that BaseRefCounted instances can be created in the stack. In this scenario the destructor
 * will assert if there are extra references pending at destruction time.
 *
 * <h3>Example Usage (Java):</h3>
 * <pre>{@code
 * NSMesh mesh = new NSMesh();
 * mesh.release();
 * }</pre>
 *
 * <h3>Example Usage (C++):</h3>
 * <pre>{@code
 * Mesh* mesh = new Mesh();
 * mesh->Release();
 * }</pre>
 */
public class NSBaseRefCounted extends NSBaseObject {

    public NSBaseRefCounted(long ptr) {
        super(ptr);
    }

    /**
     * Increments reference count and returns the new value
     */
    public final void addReference() {
        nativeAddReference(getPtr());
    }

    /**
     * Decrements reference count and returns the new value
     * When the reference count on an object reaches zero, it is deleted
     */
    public final void release() {
        nativeRelease(getPtr());
    }

    /**
     * Gets current reference count for the object
     */
    public final long getNumReferences() {
        return nativeGetNumReferences(getPtr());
    }

    private static native long nativeAddReference(long ptr);

    private static native long nativeRelease(long ptr);

    private static native long nativeGetNumReferences(long ptr);
}
