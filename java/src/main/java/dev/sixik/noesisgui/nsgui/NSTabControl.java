package dev.sixik.noesisgui.nsgui;

import dev.sixik.noesisgui.nscore.NSBaseComponent;

/**
 * Represents a control that contains multiple items that share the same space on the screen.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.tabcontrol.aspx">
 * Microsoft Documentation: TabControl Class</a>
 */
public class NSTabControl extends NSSelector {

    public NSTabControl() {
        this(nCreate());
    }

    public NSTabControl(long ptr) {
        super(ptr);
    }

    /**
     * Gets or sets the DataTemplate to apply to any TabItem that does not have a ContentTemplate
     * or ContentTemplateSelector property defined
     */
    public final NSDataTemplate getContentTemplate() {
        return new NSDataTemplate(nGetContentTemplate(getPtr()));
    }

    /**
     * Gets or sets the DataTemplate to apply to any TabItem that does not have a ContentTemplate
     * or ContentTemplateSelector property defined
     */
    public final void setContentTemplate(final NSDataTemplate template) {
        nSetContentTemplate(getPtr(), template.getPtr());
    }

    /**
     * Gets or sets a DataTemplateSelector that provides custom logic for choosing the template
     * that is used to display the content of the control
     */
    public final NSDataTemplateSelector getContentTemplateSelector() {
        return new NSDataTemplateSelector(nGetContentTemplateSelector(getPtr()));
    }

    /**
     * Gets or sets a DataTemplateSelector that provides custom logic for choosing the template
     * that is used to display the content of the control
     */
    public final void setContentTemplateSelector(final NSDataTemplateSelector selector) {
        nSetContentTemplateSelector(getPtr(), selector.getPtr());
    }

    /**
     * Gets the content of the currently selected TabItem
     */
    public final NSBaseComponent getSelectedContent() {
        return new NSBaseComponent(nGetSelectedContent(getPtr()));
    }

    /**
     * Gets the DataTemplate of the currently selected item
     */
    public final NSDataTemplate getSelectedContentTemplate() {
        return new NSDataTemplate(nGetSelectedContentTemplate(getPtr()));
    }

    /**
     * Gets the DataTemplateSelector of the currently selected item
     */
    public final NSDataTemplateSelector getSelectedContentTemplateSelector() {
        return new NSDataTemplateSelector(nGetSelectedContentTemplateSelector(getPtr()));
    }

    /**
     * Gets or sets how tab headers align relative to the tab content
     */
    public final NSGui_Dock getTabStripPlacement() {
        return NSGui_Dock.values()[nGetTabStripPlacement(getPtr())];
    }

    /**
     * Gets or sets how tab headers align relative to the tab content
     */
    public final void setTabStripPlacement(final NSGui_Dock dock) {
        nSetTabStripPlacement(getPtr(), dock.ordinal());
    }

    private static native long nCreate();

    private static native long nGetContentTemplate(long ptr);

    private static native void nSetContentTemplate(long ptr, long element_ptr);

    private static native long nGetContentTemplateSelector(long ptr);

    private static native void nSetContentTemplateSelector(long ptr, long selector_ptr);

    private static native long nGetSelectedContent(long ptr);

    private static native long nGetSelectedContentTemplate(long ptr);

    private static native long nGetSelectedContentTemplateSelector(long ptr);

    private static native int nGetTabStripPlacement(long ptr);

    private static native void nSetTabStripPlacement(long ptr, int value);
}
