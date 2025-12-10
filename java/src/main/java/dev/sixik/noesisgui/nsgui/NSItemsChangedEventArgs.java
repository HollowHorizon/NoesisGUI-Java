package dev.sixik.noesisgui.nsgui;

/**
 * The ItemsChanged event is raised by an ItemContainerGenerator to inform layouts that the items
 * collection has changed.
 */
public class NSItemsChangedEventArgs extends NSEventArgs {

    public NSGui_NotifyCollectionChangedAction action;
    public NSGeneratorPosition position;
    public NSGeneratorPosition oldPosition;
    public int itemCount;
    public int itemUICount;

    public NSItemsChangedEventArgs(int action,
                                   int position_index, int position_offset,
                                   int oldPosition_index, int oldPosition_offset,
                                   int itemCount, int itemUICount
                                   ) {
        this(
                NSGui_NotifyCollectionChangedAction.values()[action],
                new NSGeneratorPosition(position_index, position_offset),
                new NSGeneratorPosition(oldPosition_index, oldPosition_offset),
                itemCount, itemUICount
        );

    }

    public NSItemsChangedEventArgs(NSGui_NotifyCollectionChangedAction action,
                                   NSGeneratorPosition position,
                                   NSGeneratorPosition oldPosition,
                                   int itemCount, int itemUICount) {
        this.action = action;
        this.position = position;
        this.oldPosition = oldPosition;
        this.itemCount = itemCount;
        this.itemUICount = itemUICount;
    }
}
