package dev.sixik.noesisgui.nsgui;

public enum NSGui_RelativeSourceMode {

    /**
     * Allows you to bind the previous data item (not that control that contains the data item)
     * in the list of data items being displayed
     */
    RelativeSourceMode_PreviousData,

    /**
     * Refers to the element to which the template (in which the data-bound element exists) is
     * applied. This is similar to setting a TemplateBindingExtension and is only applicable if
     * the Binding is within a template
     */
    RelativeSourceMode_TemplatedParent,

    /**
     * Refers to the element on which you are setting the binding and allows you to bind one
     * property of that element to another property on the same element
     */
    RelativeSourceMode_Self,

    /**
     * Refers to the ancestor in the parent chain of the data-bound element. You can use this to
     * bind to an ancestor of a specific type or its subclasses. This is the mode you use if you
     * want to specify AncestorType and/or AncestorLevel
     */
    RelativeSourceMode_FindAncestor
}
