package dev.sixik.noesisgui.nsgui;

/**
 * Provides access to a rich set of OpenType typography properties.
 * <p>
 * The Typography object exposes the set of features that an OpenType font supports. All properties
 * have an attached property usage in XAML so they can be used in all text element types.
 *
 * <h3>XAML Example:</h3>
 * <pre>{@code
 * <Grid
 *   xmlns="http://schemas.microsoft.com/winfx/2006/xaml/presentation"
 *   xmlns:x="http://schemas.microsoft.com/winfx/2006/xaml">
 *   <TextBlock FontFamily="Fonts/#Arial" Typography.CapitalSpacing="True">
 *     <Run>CAPITALS</Run>
 *     <Run Typography.Capitals="SmallCaps">Capitals</Run>
 *     <Run Typography.Capitals="AllSmallCaps">Capitals</Run>
 *   </TextBlock>
 * </Grid>
 * }</pre>
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.documents.typography.aspx">
 * Microsoft Documentation: Typography Class</a>
 */
public class NSTypography {

    // Index of an alternate annotation form. Default: 0
    private int annotationAlternates = 0;

    // Capital form of the selected font. Default: Normal
    private NSGui_FontCapitals capitals = NSGui_FontCapitals.FontCapitals_Normal;

    // Inter-glyph spacing for all-capital text. Default: false
    private boolean capitalSpacing = false;

    // Vertical position adjust for case-sensitive forms. Default: false
    private boolean caseSensitiveForms = false;

    // Use contextual alternates. Default: true
    private boolean contextualAlternates = true;

    // Enable contextual ligatures. Default: true
    private boolean contextualLigatures = true;

    // Index of a contextual swashes form. Default: 0
    private int contextualSwashes = 0;

    // Enable discretionary ligatures. Default: false
    private boolean discretionaryLigatures = false;

    // Replace standard Japanese forms with expert forms. Default: false
    private boolean eastAsianExpertForms = false;

    // East Asian language glyph version. Default: Normal
    private NSGui_FontEastAsianLanguage eastAsianLanguage = NSGui_FontEastAsianLanguage.FontEastAsianLanguage_Normal;

    // East Asian widths for Latin characters. Default: Normal
    private NSGui_FontEastAsianWidths eastAsianWidths = NSGui_FontEastAsianWidths.FontEastAsianWidths_Normal;

    // Fraction style. Default: Normal
    private NSGui_FontFraction fraction = NSGui_FontFraction.FontFraction_Normal;

    // Historical forms. Default: false
    private boolean historicalForms = false;

    // Historical ligatures. Default: false
    private boolean historicalLigatures = false;

    // Kerning enabled. Default: true
    private boolean kerning = true;

    // Mathematical Greek forms. Default: false
    private boolean mathematicalGreek = false;

    // Numeral alignment. Default: Normal
    private NSGui_FontNumeralAlignment numeralAlignment = NSGui_FontNumeralAlignment.FontNumeralAlignment_Normal;

    // Numeral style. Default: Normal
    private NSGui_FontNumeralStyle numeralStyle = NSGui_FontNumeralStyle.FontNumeralStyle_Normal;

    // Slashed zero. Default: false
    private boolean slashedZero = false;

    // Standard ligatures. Default: true
    private boolean standardLigatures = true;

    // Index of a standard swashes form. Default: 0
    private int standardSwashes = 0;

    // Index of stylistic alternates form. Default: 0
    private int stylisticAlternates = 0;

    // Stylistic sets 1–20. Default: false
    private boolean stylisticSet1 = false;
    private boolean stylisticSet2 = false;
    private boolean stylisticSet3 = false;
    private boolean stylisticSet4 = false;
    private boolean stylisticSet5 = false;
    private boolean stylisticSet6 = false;
    private boolean stylisticSet7 = false;
    private boolean stylisticSet8 = false;
    private boolean stylisticSet9 = false;
    private boolean stylisticSet10 = false;
    private boolean stylisticSet11 = false;
    private boolean stylisticSet12 = false;
    private boolean stylisticSet13 = false;
    private boolean stylisticSet14 = false;
    private boolean stylisticSet15 = false;
    private boolean stylisticSet16 = false;
    private boolean stylisticSet17 = false;
    private boolean stylisticSet18 = false;
    private boolean stylisticSet19 = false;
    private boolean stylisticSet20 = false;

    // Font variants. Default: Normal
    private NSGui_FontVariants variants = NSGui_FontVariants.FontVariants_Normal;

    // === Get/Set методы (1:1 с C++ API, но в Java-стиле) ===

    public int getAnnotationAlternates() {
        return annotationAlternates;
    }

    public void setAnnotationAlternates(int value) {
        this.annotationAlternates = value;
    }

    public NSGui_FontCapitals getCapitals() {
        return capitals;
    }

    public void setCapitals(NSGui_FontCapitals value) {
        this.capitals = value;
    }

    public boolean isCapitalSpacing() {
        return capitalSpacing;
    }

    public void setCapitalSpacing(boolean value) {
        this.capitalSpacing = value;
    }

    public boolean isCaseSensitiveForms() {
        return caseSensitiveForms;
    }

    public void setCaseSensitiveForms(boolean value) {
        this.caseSensitiveForms = value;
    }

    public boolean isContextualAlternates() {
        return contextualAlternates;
    }

    public void setContextualAlternates(boolean value) {
        this.contextualAlternates = value;
    }

    public boolean isContextualLigatures() {
        return contextualLigatures;
    }

    public void setContextualLigatures(boolean value) {
        this.contextualLigatures = value;
    }

    public int getContextualSwashes() {
        return contextualSwashes;
    }

    public void setContextualSwashes(int value) {
        this.contextualSwashes = value;
    }

    public boolean isDiscretionaryLigatures() {
        return discretionaryLigatures;
    }

    public void setDiscretionaryLigatures(boolean value) {
        this.discretionaryLigatures = value;
    }

    public boolean isEastAsianExpertForms() {
        return eastAsianExpertForms;
    }

    public void setEastAsianExpertForms(boolean value) {
        this.eastAsianExpertForms = value;
    }

    public NSGui_FontEastAsianLanguage getEastAsianLanguage() {
        return eastAsianLanguage;
    }

    public void setEastAsianLanguage(NSGui_FontEastAsianLanguage value) {
        this.eastAsianLanguage = value;
    }

    public NSGui_FontEastAsianWidths getEastAsianWidths() {
        return eastAsianWidths;
    }

    public void setEastAsianWidths(NSGui_FontEastAsianWidths value) {
        this.eastAsianWidths = value;
    }

    public NSGui_FontFraction getFraction() {
        return fraction;
    }

    public void setFraction(NSGui_FontFraction value) {
        this.fraction = value;
    }

    public boolean isHistoricalForms() {
        return historicalForms;
    }

    public void setHistoricalForms(boolean value) {
        this.historicalForms = value;
    }

    public boolean isHistoricalLigatures() {
        return historicalLigatures;
    }

    public void setHistoricalLigatures(boolean value) {
        this.historicalLigatures = value;
    }

    public boolean isKerning() {
        return kerning;
    }

    public void setKerning(boolean value) {
        this.kerning = value;
    }

    public boolean isMathematicalGreek() {
        return mathematicalGreek;
    }

    public void setMathematicalGreek(boolean value) {
        this.mathematicalGreek = value;
    }

    public NSGui_FontNumeralAlignment getNumeralAlignment() {
        return numeralAlignment;
    }

    public void setNumeralAlignment(NSGui_FontNumeralAlignment value) {
        this.numeralAlignment = value;
    }

    public NSGui_FontNumeralStyle getNumeralStyle() {
        return numeralStyle;
    }

    public void setNumeralStyle(NSGui_FontNumeralStyle value) {
        this.numeralStyle = value;
    }

    public boolean isSlashedZero() {
        return slashedZero;
    }

    public void setSlashedZero(boolean value) {
        this.slashedZero = value;
    }

    public boolean isStandardLigatures() {
        return standardLigatures;
    }

    public void setStandardLigatures(boolean value) {
        this.standardLigatures = value;
    }

    public int getStandardSwashes() {
        return standardSwashes;
    }

    public void setStandardSwashes(int value) {
        this.standardSwashes = value;
    }

    public int getStylisticAlternates() {
        return stylisticAlternates;
    }

    public void setStylisticAlternates(int value) {
        this.stylisticAlternates = value;
    }

    public boolean isStylisticSet1() {
        return stylisticSet1;
    }

    public void setStylisticSet1(boolean value) {
        this.stylisticSet1 = value;
    }

    public boolean isStylisticSet2() {
        return stylisticSet2;
    }

    public void setStylisticSet2(boolean value) {
        this.stylisticSet2 = value;
    }

    public boolean isStylisticSet3() {
        return stylisticSet3;
    }

    public void setStylisticSet3(boolean value) {
        this.stylisticSet3 = value;
    }

    public boolean isStylisticSet4() {
        return stylisticSet4;
    }

    public void setStylisticSet4(boolean value) {
        this.stylisticSet4 = value;
    }

    public boolean isStylisticSet5() {
        return stylisticSet5;
    }

    public void setStylisticSet5(boolean value) {
        this.stylisticSet5 = value;
    }

    public boolean isStylisticSet6() {
        return stylisticSet6;
    }

    public void setStylisticSet6(boolean value) {
        this.stylisticSet6 = value;
    }

    public boolean isStylisticSet7() {
        return stylisticSet7;
    }

    public void setStylisticSet7(boolean value) {
        this.stylisticSet7 = value;
    }

    public boolean isStylisticSet8() {
        return stylisticSet8;
    }

    public void setStylisticSet8(boolean value) {
        this.stylisticSet8 = value;
    }

    public boolean isStylisticSet9() {
        return stylisticSet9;
    }

    public void setStylisticSet9(boolean value) {
        this.stylisticSet9 = value;
    }

    public boolean isStylisticSet10() {
        return stylisticSet10;
    }

    public void setStylisticSet10(boolean value) {
        this.stylisticSet10 = value;
    }

    public boolean isStylisticSet11() {
        return stylisticSet11;
    }

    public void setStylisticSet11(boolean value) {
        this.stylisticSet11 = value;
    }

    public boolean isStylisticSet12() {
        return stylisticSet12;
    }

    public void setStylisticSet12(boolean value) {
        this.stylisticSet12 = value;
    }

    public boolean isStylisticSet13() {
        return stylisticSet13;
    }

    public void setStylisticSet13(boolean value) {
        this.stylisticSet13 = value;
    }

    public boolean isStylisticSet14() {
        return stylisticSet14;
    }

    public void setStylisticSet14(boolean value) {
        this.stylisticSet14 = value;
    }

    public boolean isStylisticSet15() {
        return stylisticSet15;
    }

    public void setStylisticSet15(boolean value) {
        this.stylisticSet15 = value;
    }

    public boolean isStylisticSet16() {
        return stylisticSet16;
    }

    public void setStylisticSet16(boolean value) {
        this.stylisticSet16 = value;
    }

    public boolean isStylisticSet17() {
        return stylisticSet17;
    }

    public void setStylisticSet17(boolean value) {
        this.stylisticSet17 = value;
    }

    public boolean isStylisticSet18() {
        return stylisticSet18;
    }

    public void setStylisticSet18(boolean value) {
        this.stylisticSet18 = value;
    }

    public boolean isStylisticSet19() {
        return stylisticSet19;
    }

    public void setStylisticSet19(boolean value) {
        this.stylisticSet19 = value;
    }

    public boolean isStylisticSet20() {
        return stylisticSet20;
    }

    public void setStylisticSet20(boolean value) {
        this.stylisticSet20 = value;
    }

    public NSGui_FontVariants getVariants() {
        return variants;
    }

    public void setVariants(NSGui_FontVariants value) {
        this.variants = value;
    }

    public void applyToNative(long nativePtr) {
        if (nativePtr == 0L) return;

        nApplyToNative(
                nativePtr,
                annotationAlternates,
                capitals.ordinal(),
                capitalSpacing,
                caseSensitiveForms,
                contextualAlternates,
                contextualLigatures,
                contextualSwashes,
                discretionaryLigatures,
                eastAsianExpertForms,
                eastAsianLanguage.ordinal(),
                eastAsianWidths.ordinal(),
                fraction.ordinal(),
                historicalForms,
                historicalLigatures,
                kerning,
                mathematicalGreek,
                numeralAlignment.ordinal(),
                numeralStyle.ordinal(),
                slashedZero,
                standardLigatures,
                standardSwashes,
                stylisticAlternates,
                stylisticSet1,
                stylisticSet2,
                stylisticSet3,
                stylisticSet4,
                stylisticSet5,
                stylisticSet6,
                stylisticSet7,
                stylisticSet8,
                stylisticSet9,
                stylisticSet10,
                stylisticSet11,
                stylisticSet12,
                stylisticSet13,
                stylisticSet14,
                stylisticSet15,
                stylisticSet16,
                stylisticSet17,
                stylisticSet18,
                stylisticSet19,
                stylisticSet20,
                variants.ordinal()
        );
    }

    public void loadFromNative(long nativePtr) {
        if (nativePtr == 0L) return;
        nLoadFromNative(nativePtr, this);
    }

    private static native void nApplyToNative(
            long nativePtr,
            int annotationAlternates,
            int capitalsOrdinal,
            boolean capitalSpacing,
            boolean caseSensitiveForms,
            boolean contextualAlternates,
            boolean contextualLigatures,
            int contextualSwashes,
            boolean discretionaryLigatures,
            boolean eastAsianExpertForms,
            int eastAsianLanguageOrdinal,
            int eastAsianWidthsOrdinal,
            int fractionOrdinal,
            boolean historicalForms,
            boolean historicalLigatures,
            boolean kerning,
            boolean mathematicalGreek,
            int numeralAlignmentOrdinal,
            int numeralStyleOrdinal,
            boolean slashedZero,
            boolean standardLigatures,
            int standardSwashes,
            int stylisticAlternates,
            boolean stylisticSet1,
            boolean stylisticSet2,
            boolean stylisticSet3,
            boolean stylisticSet4,
            boolean stylisticSet5,
            boolean stylisticSet6,
            boolean stylisticSet7,
            boolean stylisticSet8,
            boolean stylisticSet9,
            boolean stylisticSet10,
            boolean stylisticSet11,
            boolean stylisticSet12,
            boolean stylisticSet13,
            boolean stylisticSet14,
            boolean stylisticSet15,
            boolean stylisticSet16,
            boolean stylisticSet17,
            boolean stylisticSet18,
            boolean stylisticSet19,
            boolean stylisticSet20,
            int variantsOrdinal
    );

    private void applyFromNativeData(
            int annotationAlternates,
            int capitalsOrdinal,
            boolean capitalSpacing,
            boolean caseSensitiveForms,
            boolean contextualAlternates,
            boolean contextualLigatures,
            int contextualSwashes,
            boolean discretionaryLigatures,
            boolean eastAsianExpertForms,
            int eastAsianLanguageOrdinal,
            int eastAsianWidthsOrdinal,
            int fractionOrdinal,
            boolean historicalForms,
            boolean historicalLigatures,
            boolean kerning,
            boolean mathematicalGreek,
            int numeralAlignmentOrdinal,
            int numeralStyleOrdinal,
            boolean slashedZero,
            boolean standardLigatures,
            int standardSwashes,
            int stylisticAlternates,
            boolean stylisticSet1,
            boolean stylisticSet2,
            boolean stylisticSet3,
            boolean stylisticSet4,
            boolean stylisticSet5,
            boolean stylisticSet6,
            boolean stylisticSet7,
            boolean stylisticSet8,
            boolean stylisticSet9,
            boolean stylisticSet10,
            boolean stylisticSet11,
            boolean stylisticSet12,
            boolean stylisticSet13,
            boolean stylisticSet14,
            boolean stylisticSet15,
            boolean stylisticSet16,
            boolean stylisticSet17,
            boolean stylisticSet18,
            boolean stylisticSet19,
            boolean stylisticSet20,
            int variantsOrdinal
    ) {
        this.annotationAlternates = annotationAlternates;
        this.capitals = NSGui_FontCapitals.values()[capitalsOrdinal];
        this.capitalSpacing = capitalSpacing;
        this.caseSensitiveForms = caseSensitiveForms;
        this.contextualAlternates = contextualAlternates;
        this.contextualLigatures = contextualLigatures;
        this.contextualSwashes = contextualSwashes;
        this.discretionaryLigatures = discretionaryLigatures;
        this.eastAsianExpertForms = eastAsianExpertForms;
        this.eastAsianLanguage = NSGui_FontEastAsianLanguage.values()[eastAsianLanguageOrdinal];
        this.eastAsianWidths = NSGui_FontEastAsianWidths.values()[eastAsianWidthsOrdinal];
        this.fraction = NSGui_FontFraction.values()[fractionOrdinal];
        this.historicalForms = historicalForms;
        this.historicalLigatures = historicalLigatures;
        this.kerning = kerning;
        this.mathematicalGreek = mathematicalGreek;
        this.numeralAlignment = NSGui_FontNumeralAlignment.values()[numeralAlignmentOrdinal];
        this.numeralStyle = NSGui_FontNumeralStyle.values()[numeralStyleOrdinal];
        this.slashedZero = slashedZero;
        this.standardLigatures = standardLigatures;
        this.standardSwashes = standardSwashes;
        this.stylisticAlternates = stylisticAlternates;

        this.stylisticSet1 = stylisticSet1;
        this.stylisticSet2 = stylisticSet2;
        this.stylisticSet3 = stylisticSet3;
        this.stylisticSet4 = stylisticSet4;
        this.stylisticSet5 = stylisticSet5;
        this.stylisticSet6 = stylisticSet6;
        this.stylisticSet7 = stylisticSet7;
        this.stylisticSet8 = stylisticSet8;
        this.stylisticSet9 = stylisticSet9;
        this.stylisticSet10 = stylisticSet10;
        this.stylisticSet11 = stylisticSet11;
        this.stylisticSet12 = stylisticSet12;
        this.stylisticSet13 = stylisticSet13;
        this.stylisticSet14 = stylisticSet14;
        this.stylisticSet15 = stylisticSet15;
        this.stylisticSet16 = stylisticSet16;
        this.stylisticSet17 = stylisticSet17;
        this.stylisticSet18 = stylisticSet18;
        this.stylisticSet19 = stylisticSet19;
        this.stylisticSet20 = stylisticSet20;

        this.variants = NSGui_FontVariants.values()[variantsOrdinal];
    }

    private static native void nLoadFromNative(long nativePtr, NSTypography target);
}
