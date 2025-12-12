package dev.sixik.noesisgui.nshandlers;

import dev.sixik.noesisgui.nscore.NSBaseComponent;
import dev.sixik.noesisgui.nsgui.NSRequestNavigateEventArgs;

@FunctionalInterface
public interface NSRequestNavigateEventHandler {

    void handler(NSBaseComponent component, NSRequestNavigateEventArgs args);
}
