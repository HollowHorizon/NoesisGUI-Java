package dev.sixik.noesisgui.nsgui;

public class NSRequestNavigateEventArgs extends NSRoutedEventArgs {

    public String uri;
    public String target;

    public NSRequestNavigateEventArgs(long source_ptr, long routedEvent_ptr, boolean handled,
                                      String uri, String target) {
        super(source_ptr, routedEvent_ptr, handled);
        this.uri = uri;
        this.target = target;
    }
}
