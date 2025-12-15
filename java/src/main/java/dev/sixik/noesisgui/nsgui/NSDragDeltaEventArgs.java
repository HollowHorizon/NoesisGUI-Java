package dev.sixik.noesisgui.nsgui;

public class NSDragDeltaEventArgs extends NSRoutedEventArgs {

    public float horizontalChange;
    public float verticalChange;

    public NSDragDeltaEventArgs(long source_ptr, long routedEvent_ptr, boolean handled,
                                float horizontalChange, float verticalChange) {
        super(source_ptr, routedEvent_ptr, handled);
        this.horizontalChange = horizontalChange;
        this.verticalChange = verticalChange;
    }
}
