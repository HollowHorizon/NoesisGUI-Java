package dev.sixik.noesisgui.nsgui;

public class NSCompositionUnderline {

    public long start;
    public long end;
    public NSGui_CompositionLineStyle nsCompositionUnderline = NSGui_CompositionLineStyle.CompositionLineStyle_Dash;
    public boolean bold;

    public NSCompositionUnderline() {}

    public NSCompositionUnderline(long start, long end, int line, boolean bold) {
        set(start, end, line, bold);
    }

    public void set(long start, long end, int line, boolean bold) {
        this.start = start;
        this.end = end;
        this.nsCompositionUnderline = NSGui_CompositionLineStyle.values()[line];
        this.bold = bold;
    }
}
