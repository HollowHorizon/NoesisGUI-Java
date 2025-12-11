package dev.sixik.noesisgui.nsgui;

public class NSCheckBox extends NSToggleButton {

    public NSCheckBox() {
        this(nCreate());
    }

    public NSCheckBox(long ptr) {
        super(ptr);
    }

    private static native long nCreate();
}
