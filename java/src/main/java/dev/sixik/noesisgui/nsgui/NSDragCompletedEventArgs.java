package dev.sixik.noesisgui.nsgui;

public class NSDragCompletedEventArgs extends NSRoutedEventArgs {

    public final boolean canceled;
    public final float horizontalChange;
    public final float verticalChange;

    public NSDragCompletedEventArgs(long source_ptr, long routedEvent_ptr, boolean handled,
                                    boolean canceled, float horizontalChange, float verticalChange) {
        super(source_ptr, routedEvent_ptr, handled);
        this.canceled = canceled;
        this.horizontalChange = horizontalChange;
        this.verticalChange = verticalChange;
    }
}
