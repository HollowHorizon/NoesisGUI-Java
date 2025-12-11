package dev.sixik.noesisgui_impl;

import dev.sixik.noesisgui.nsgui.*;

public class NoesisGuiWidgets {

    public static NSButton button() {
        return new NSButton();
    }

    public static NSToggleButton toggleButton() {
        return new NSToggleButton();
    }

    public static NSRadioButton radioButton() {
        return new NSRadioButton();
    }

    public static NSCheckBox checkBox() {
        return new NSCheckBox();
    }

    public static NSRepeatButton repeatButton() {
        return new NSRepeatButton();
    }

    public static NSGridViewColumnHeader gridViewColumnHeader() {
        return new NSGridViewColumnHeader();
    }
}
