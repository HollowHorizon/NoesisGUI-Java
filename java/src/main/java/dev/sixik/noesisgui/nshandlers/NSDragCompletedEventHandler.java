package dev.sixik.noesisgui.nshandlers;

import dev.sixik.noesisgui.nscore.NSBaseComponent;
import dev.sixik.noesisgui.nsgui.NSDragCompletedEventArgs;

@FunctionalInterface
public interface NSDragCompletedEventHandler {

    void handler(NSBaseComponent component, NSDragCompletedEventArgs args);
}
