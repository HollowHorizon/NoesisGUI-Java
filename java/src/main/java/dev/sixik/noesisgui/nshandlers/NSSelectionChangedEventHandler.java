package dev.sixik.noesisgui.nshandlers;

import dev.sixik.noesisgui.nscore.NSBaseComponent;
import dev.sixik.noesisgui.nsgui.NSSelectionChangedEventArgs;

@FunctionalInterface
public interface NSSelectionChangedEventHandler {

    void handler(NSBaseComponent component, NSSelectionChangedEventArgs args);
}
