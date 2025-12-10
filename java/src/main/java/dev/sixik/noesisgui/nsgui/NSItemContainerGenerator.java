package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSBaseComponent;
import dev.sixik.noesisgui.nscore.NSDependencyObject;
import dev.sixik.noesisgui.nshandlers.NSEventHandler;
import dev.sixik.noesisgui.nshandlers.NSItemsChangedEventHandler;

/**
 * Generates the user interface on behalf of its host, such as an ItemsControl.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.itemcontainergenerator.aspx">
 *      Microsoft Documentation: ItemContainerGenerator Class</a>
 */
public class NSItemContainerGenerator extends NSBaseComponent {

    public NSItemContainerGenerator(long ptr) {
        super(ptr);
    }

    /**
     * Gets the status of the generator
     */
    public final NSGui_GeneratorStatus getStatus() {
        return NSGui_GeneratorStatus.values()[nGetStatus(getPtr())];
    }

    /**
     * Returns the container corresponding to the item at the given index within the Items
     */
    public final NSDependencyObject containerFromIndex(final int index) {
        return new NSDependencyObject(nContainerFromIndex(getPtr(), index));
    }

    /**
     * Returns the container corresponding to the given item. Returns null if the item does not
     * belong to the item collection, or if no container has been generated for it
     */
    public final NSDependencyObject containerFromItem(final NSBaseComponent component) {
        return new NSDependencyObject(nContainerFromItem(getPtr(), component.getPtr()));
    }

    /**
     * Given a generated container, returns the index of the corresponding item within the Items
     */
    public final int indexFromContainer(final NSDependencyObject container) {
        return nIndexFromContainer(getPtr(), container.getPtr());
    }

    /**
     * Returns the item corresponding to the given container. If the element was not generated as
     * a container for this generator's host, the method returns DependencyProperty.UnsetValue
     */
    public final NSBaseComponent itemFromContainer(final NSDependencyObject container) {
        return new NSBaseComponent(nItemFromContainer(getPtr(), container.getPtr()));
    }

    /**
     * Starts a container generation batch
     */
    public final void startBatch() {
        nStartBatch(getPtr());
    }

    /**
     * Stops current container generation batch
     */
    public final void stopBatch() {
        nStopBatch(getPtr());
    }

    /**
     * Raised to inform controls that ItemContainerGenerator status has changed
     */
    public final void statusChangedEvent(final NSEventHandler event) {
        nStatusChanged(getPtr(), event);
    }

    /**
     * Raised by a ItemContainerGenerator to inform layouts that the items collection has changed
     */
    public final void itemsChangedEvent(final NSItemsChangedEventHandler event) {
        nItemsChanged(getPtr(), event);
    }

    private static native int nGetStatus(long ptr);

    private static native long nContainerFromIndex(long ptr, int index);

    private static native long nContainerFromItem(long ptr, long component_ptr);

    private static native int nIndexFromContainer(long ptr, long container_ptr);

    private static native long nItemFromContainer(long ptr, long container_ptr);

    private static native void nStartBatch(long ptr);

    private static native void nStopBatch(long ptr);

    private static native void nStatusChanged(long ptr, NSEventHandler event);

    private static native void nItemsChanged(long ptr, NSItemsChangedEventHandler event);
}
