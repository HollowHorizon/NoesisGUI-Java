package dev.sixik.noesisgui.nsgui;

/**
 * Specifies the visibility of a ScrollBar for scrollable content
 */
public enum NSGui_ScrollBarVisibility {

    /**
     * A ScrollBar does not appear even when the viewport cannot display all of the content. The
     * dimension of the content is set to the corresponding dimension of the ScrollViewer parent.
     * For a horizontal ScrollBar, the width of the content is set to the ViewportWidth of the
     * ScrollViewer. For a vertical ScrollBar, the height of the content is set to the
     * ViewportHeight of the ScrollViewer
     */
    ScrollBarVisibility_Disabled,

    /**
     * A ScrollBar appears and the dimension of the ScrollViewer is applied to the content when
     * the viewport cannot display all of the content. For a horizontal ScrollBar, the width of
     * the content is set to the ViewportWidth of the ScrollViewer. For a vertical ScrollBar, the
     * height of the content is set to the ViewportHeight of the ScrollViewer
     */
    ScrollBarVisibility_Auto,

    /**
     * A ScrollBar does not appear even when the viewport cannot display all of the content. The
     * dimension of the ScrollViewer is not applied to the content
     */
    ScrollBarVisibility_Hidden,

    /**
     * A ScrollBar always appears. The dimension of the ScrollViewer is applied to the content.
     * For a horizontal ScrollBar, the width of the content is set to the ViewportWidth of the
     * ScrollViewer. For a vertical ScrollBar, the height of the content is set to the
     * ViewportHeight of the ScrollViewer
     */
    ScrollBarVisibility_Visible
}
