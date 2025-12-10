package dev.sixik.noesisgui.nsgui;

/**
 * Represents a control that can be used to present a collection of items.
 * <p>
 * Each ItemsControl type has a corresponding item container type. The corresponding item container
 * for each ItemsControl appends "Item" to its name. For example, for ListBox, the item containers
 * are ListBoxItem controls; for ComboBox, they are ComboBoxItem controls. You can explicitly
 * create a container type for each item in the ItemsControl, but it is not necessary. When you do
 * not explicitly create the container type, one is generated that contains a data item in the item
 * collection.
 * <p>
 * For example, if you bind a collection of string objects to the ItemsSource property
 * of a ListBox, you do not explicitly create ListBoxItem objects, but the ListBox will generate
 * one for each string. You can access a generated item container by using the
 * ItemContainerGenerator property.
 * <p>
 * <strong>XAML Example:</strong>
 * <pre>{@code
 * <ItemsControl>
 *   <ItemsControl.ItemTemplate>
 *     <DataTemplate>
 *       <Grid Margin="0,0,0,5">
 *         <Grid.ColumnDefinitions>
 *           <ColumnDefinition Width="*"/>
 *           <ColumnDefinition Width="100"/>
 *         </Grid.ColumnDefinitions>
 *         <TextBlock Text="{Binding Title}"/>
 *         <ProgressBar Grid.Column="1" Minimum="0" Maximum="100" Value="{Binding Completion}"/>
 *       </Grid>
 *     </DataTemplate>
 *   </ItemsControl.ItemTemplate>
 * </ItemsControl>
 * }</pre>
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.controls.itemscontrol.aspx">
 *      ItemsControl Documentation on MSDN</a>
 * @since 1.0
 */
public class NSItemsControl extends NSControl {

    public NSItemsControl(long ptr) {
        super(ptr);
    }
}
