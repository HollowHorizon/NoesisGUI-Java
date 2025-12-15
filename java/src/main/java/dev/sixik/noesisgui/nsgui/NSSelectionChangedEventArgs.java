package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSBaseComponent;

public class NSSelectionChangedEventArgs extends NSRoutedEventArgs {

    public final NSBaseComponent[] addedItems;
    public final NSBaseComponent[] removedItems;

    public NSSelectionChangedEventArgs(long source_ptr, long routedEvent_ptr, boolean handled,
                                       long[] addedItems, long[] removedItems) {
        super(source_ptr, routedEvent_ptr, handled);

        final NSBaseComponent[] _addedItems = new NSBaseComponent[addedItems.length];
        for (int i = 0; i < addedItems.length; i++) {
            _addedItems[i] = new NSBaseComponent(addedItems[i]);
        }

        final NSBaseComponent[] _removedItems = new NSBaseComponent[removedItems.length];
        for (int i = 0; i < removedItems.length; i++) {
            _removedItems[i] = new NSBaseComponent(removedItems[i]);
        }

        this.addedItems = _addedItems;
        this.removedItems = _removedItems;
    }
}
