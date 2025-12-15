package dev.sixik.noesisgui.nsgui;

public class NSDragStartedEventArgs extends NSRoutedEventArgs {

    public float horizontalOffset;
    public float verticalOffset;

    public NSDragStartedEventArgs(long source_ptr, long routedEvent_ptr, boolean handled,
                                  float horizontalOffset, float verticalOffset) {
        super(source_ptr, routedEvent_ptr, handled);
        this.horizontalOffset = horizontalOffset;
        this.verticalOffset = verticalOffset;
    }
}
