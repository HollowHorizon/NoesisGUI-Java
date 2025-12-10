package dev.sixik.noesisgui.nsgui;

public enum NSGui_FontWeight {

    FontWeight_Thin(100),
    FontWeight_ExtraLight(200),
    FontWeight_UltraLight(200),
    FontWeight_Light(300),
    FontWeight_SemiLight(350),
    FontWeight_Normal(400),
    FontWeight_Regular(400),
    FontWeight_Medium(500),
    FontWeight_DemiBold(600),
    FontWeight_SemiBold(600),
    FontWeight_Bold(700),
    FontWeight_ExtraBold(800),
    FontWeight_UltraBold(800),
    FontWeight_Black(900),
    FontWeight_Heavy(900),
    FontWeight_ExtraBlack(950),
    FontWeight_UltraBlack(950);

    public final int value;

    NSGui_FontWeight(int value) {
        this.value = value;
    }

    public static NSGui_FontWeight get(int index) {
        for (NSGui_FontWeight value : NSGui_FontWeight.values()) {
            if(value.value == index) return value;
        }

        return null;
    }
}
