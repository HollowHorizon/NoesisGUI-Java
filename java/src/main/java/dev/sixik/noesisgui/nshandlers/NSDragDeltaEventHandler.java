package dev.sixik.noesisgui.nshandlers;

import dev.sixik.noesisgui.nscore.NSBaseComponent;
import dev.sixik.noesisgui.nsgui.NSDragDeltaEventArgs;

@FunctionalInterface
public interface NSDragDeltaEventHandler {

    void handler(NSBaseComponent component, NSDragDeltaEventArgs args);
}
