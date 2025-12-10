package dev.sixik.noesisgui.nsgui;

/**
 * Describes the action that caused a CollectionChanged even
 */
public enum NSGui_NotifyCollectionChangedAction {

    /**
     * An item was added to the collection
     */
    NotifyCollectionChangedAction_Add,

    /**
     * An item was removed from the collection
     */
    NotifyCollectionChangedAction_Remove,

    /**
     * An item was replaced in the collection
     */
    NotifyCollectionChangedAction_Replace,

    /**
     * An item was moved within the collection
     */
    NotifyCollectionChangedAction_Move,

    /**
     * The content of the collection was cleared
     */
    NotifyCollectionChangedAction_Reset,

    /**
     * The content of the collection is going to be cleared
     */
    NotifyCollectionChangedAction_PreReset
}
