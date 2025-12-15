package dev.sixik.noesisgui.nshandlers;

import dev.sixik.noesisgui.nscore.NSBaseComponent;
import dev.sixik.noesisgui.nsgui.NSDragStartedEventArgs;

@FunctionalInterface
public interface NSDragStartedEventHandler {

    void handler(NSBaseComponent component, NSDragStartedEventArgs args);
}
