package dev.sixik.noesisgui.nshandlers;

import dev.sixik.noesisgui.nscore.NSBaseComponent;
import dev.sixik.noesisgui.nsgui.NSItemsChangedEventArgs;

@FunctionalInterface
public interface NSItemsChangedEventHandler {

    void handler(NSBaseComponent component, NSItemsChangedEventArgs args);
}
