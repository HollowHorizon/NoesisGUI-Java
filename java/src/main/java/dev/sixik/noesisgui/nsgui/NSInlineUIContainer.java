package dev.sixik.noesisgui.nsgui;

/**
 * An inline-level flow content element which enables UIElement elements (i.e. a Button) to be
 * embedded in flow content.
 *
 * <h3>XAML Example:</h3>
 * <pre>{@code
 * <TextBlock>
 *   <Run>
 *     A UIElement element may be embedded directly in flow content
 *     by enclosing it in an InlineUIContainer element
 *   </Run>
 *   <InlineUIContainer>
 *     <Image Source="Images/item.png" Stretch="None"/>
 *   </InlineUIContainer>
 * </TextBlock>
 * }</pre>
 *
 * @see <a href="https://msdn.microsoft.com/en-us/library/system.windows.documents.inlineuicontainer.aspx">
 * Microsoft Documentation: InlineUIContainer Class</a>
 */
public class NSInlineUIContainer extends NSInline {

    public NSInlineUIContainer() {
        this(nCreate());
    }

    public NSInlineUIContainer(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets the UIElement hosted by the InlineUIContainer
     */
    public final NSUIElement getChild() {
        return new NSUIElement(nGetChild(getPtr()));
    }

    /**
     * Gets or sets the UIElement hosted by the InlineUIContainer
     */
    public final void setChild(final NSUIElement element) {
        nSetChild(getPtr(), element.getPtr());
    }

    private static native long nCreate();

    private static native long nGetChild(long ptr);

    private static native void nSetChild(long ptr, long element_ptr);
}
