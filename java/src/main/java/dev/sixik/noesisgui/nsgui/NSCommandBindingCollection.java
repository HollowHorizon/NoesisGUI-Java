package dev.sixik.noesisgui.nsgui;

public class NSCommandBindingCollection extends NSUICollection{

    public NSCommandBindingCollection(long ptr) {
        super(ptr);
    }

    /**
     * Gets the element at the specified index
     */
    public final NSCommandBinding get(final int index) {
        return new NSCommandBinding(nGet(getPtr(), index));
    }

    /**
     * Sets the element at the specified index
     */
    public final void set(final int index, final NSCommandBinding item) {
        nSet(getPtr(), index, item.getPtr());
    }

    /**
     * Adds an item to the collection. Returns The position into which the new element was
     * inserted, or -1 to indicate that the item was not inserted into the collection
     */
    public final void add(final NSCommandBinding item) {
        nAdd(getPtr(), item.getPtr());
    }

    /**
     * Inserts an item to the collection at the specified index
     */
    public final void insert(final int index, final NSCommandBinding item) {
        nInsert(getPtr(), index, item.getPtr());
    }

    /**
     * Determines whether the collection contains a specific value
     */
    public final boolean contains(final NSCommandBinding item) {
        return nContains(getPtr(), item.getPtr());
    }

    /**
     * Determines the index of a specific item in the collection. Returns -1 if not found
     */
    public final int indexOf(final NSCommandBinding item) {
        return nIndexOf(getPtr(), item.getPtr());
    }

    /**
     * Removes the first occurrence of a specific object from the collection. Returns true if item
     * was removed, false to indicate that the item was not found in the collection
     */
    public final boolean remove(final NSCommandBinding item) {
        return nRemove(getPtr(), item.getPtr());
    }

    private static native long nGet(long ptr, int value);

    private static native void nSet(long ptr, int value, long element_ptr);

    private static native void nAdd(long ptr, long element_ptr);

    private static native void nInsert(long ptr, int index, long element_ptr);

    private static native boolean nContains(long ptr, long element_ptr);

    private static native int nIndexOf(long ptr, long element_ptr);

    private static native boolean nRemove(long ptr, long element_ptr);
}
