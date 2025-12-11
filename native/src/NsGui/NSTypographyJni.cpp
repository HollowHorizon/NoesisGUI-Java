//
// Created by Sixik on 11.12.2025.
//

#include <jni.h>
#include <jni_md.h>

#include "NsGui/Typography.h"

namespace Noesis {
    enum FontNumeralStyle : int;
    enum FontNumeralAlignment : int;
    enum FontFraction : int;
    enum FontEastAsianLanguage : int;
    enum FontEastAsianWidths : int;
    enum FontCapitals : int;
    struct Typography;
}

extern "C" {

    JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSTypography_nApplyToNative(
        JNIEnv*,
        jclass,
        jlong nativePtr,
        jint annotationAlternates,
        jint capitalsOrdinal,
        jboolean capitalSpacing,
        jboolean caseSensitiveForms,
        jboolean contextualAlternates,
        jboolean contextualLigatures,
        jint contextualSwashes,
        jboolean discretionaryLigatures,
        jboolean eastAsianExpertForms,
        jint eastAsianLanguageOrdinal,
        jint eastAsianWidthsOrdinal,
        jint fractionOrdinal,
        jboolean historicalForms,
        jboolean historicalLigatures,
        jboolean kerning,
        jboolean mathematicalGreek,
        jint numeralAlignmentOrdinal,
        jint numeralStyleOrdinal,
        jboolean slashedZero,
        jboolean standardLigatures,
        jint standardSwashes,
        jint stylisticAlternates,
        jboolean stylisticSet1,
        jboolean stylisticSet2,
        jboolean stylisticSet3,
        jboolean stylisticSet4,
        jboolean stylisticSet5,
        jboolean stylisticSet6,
        jboolean stylisticSet7,
        jboolean stylisticSet8,
        jboolean stylisticSet9,
        jboolean stylisticSet10,
        jboolean stylisticSet11,
        jboolean stylisticSet12,
        jboolean stylisticSet13,
        jboolean stylisticSet14,
        jboolean stylisticSet15,
        jboolean stylisticSet16,
        jboolean stylisticSet17,
        jboolean stylisticSet18,
        jboolean stylisticSet19,
        jboolean stylisticSet20,
        jint variantsOrdinal
) {
    if (nativePtr == 0) return;

    auto* typo = reinterpret_cast<Noesis::Typography*>(nativePtr);

    typo->SetAnnotationAlternates(annotationAlternates);
    typo->SetCapitals(static_cast<Noesis::FontCapitals>(capitalsOrdinal));
    typo->SetCapitalSpacing(capitalSpacing == JNI_TRUE);
    typo->SetCaseSensitiveForms(caseSensitiveForms == JNI_TRUE);
    typo->SetContextualAlternates(contextualAlternates == JNI_TRUE);
    typo->SetContextualLigatures(contextualLigatures == JNI_TRUE);
    typo->SetContextualSwashes(contextualSwashes);
    typo->SetDiscretionaryLigatures(discretionaryLigatures == JNI_TRUE);
    typo->SetEastAsianExpertForms(eastAsianExpertForms == JNI_TRUE);
    typo->SetEastAsianLanguage(static_cast<Noesis::FontEastAsianLanguage>(eastAsianLanguageOrdinal));
    typo->SetEastAsianWidths(static_cast<Noesis::FontEastAsianWidths>(eastAsianWidthsOrdinal));
    typo->SetFraction(static_cast<Noesis::FontFraction>(fractionOrdinal));
    typo->SetHistoricalForms(historicalForms == JNI_TRUE);
    typo->SetHistoricalLigatures(historicalLigatures == JNI_TRUE);
    typo->SetKerning(kerning == JNI_TRUE);
    typo->SetMathematicalGreek(mathematicalGreek == JNI_TRUE);
    typo->SetNumeralAlignment(static_cast<Noesis::FontNumeralAlignment>(numeralAlignmentOrdinal));
    typo->SetNumeralStyle(static_cast<Noesis::FontNumeralStyle>(numeralStyleOrdinal));
    typo->SetSlashedZero(slashedZero == JNI_TRUE);
    typo->SetStandardLigatures(standardLigatures == JNI_TRUE);
    typo->SetStandardSwashes(standardSwashes);
    typo->SetStylisticAlternates(stylisticAlternates);

    typo->SetStylisticSet1(stylisticSet1 == JNI_TRUE);
    typo->SetStylisticSet2(stylisticSet2 == JNI_TRUE);
    typo->SetStylisticSet3(stylisticSet3 == JNI_TRUE);
    typo->SetStylisticSet4(stylisticSet4 == JNI_TRUE);
    typo->SetStylisticSet5(stylisticSet5 == JNI_TRUE);
    typo->SetStylisticSet6(stylisticSet6 == JNI_TRUE);
    typo->SetStylisticSet7(stylisticSet7 == JNI_TRUE);
    typo->SetStylisticSet8(stylisticSet8 == JNI_TRUE);
    typo->SetStylisticSet9(stylisticSet9 == JNI_TRUE);
    typo->SetStylisticSet10(stylisticSet10 == JNI_TRUE);
    typo->SetStylisticSet11(stylisticSet11 == JNI_TRUE);
    typo->SetStylisticSet12(stylisticSet12 == JNI_TRUE);
    typo->SetStylisticSet13(stylisticSet13 == JNI_TRUE);
    typo->SetStylisticSet14(stylisticSet14 == JNI_TRUE);
    typo->SetStylisticSet15(stylisticSet15 == JNI_TRUE);
    typo->SetStylisticSet16(stylisticSet16 == JNI_TRUE);
    typo->SetStylisticSet17(stylisticSet17 == JNI_TRUE);
    typo->SetStylisticSet18(stylisticSet18 == JNI_TRUE);
    typo->SetStylisticSet19(stylisticSet19 == JNI_TRUE);
    typo->SetStylisticSet20(stylisticSet20 == JNI_TRUE);

    typo->SetVariants(static_cast<Noesis::FontVariants>(variantsOrdinal));
}

    JNIEXPORT void JNICALL
Java_dev_sixik_noesisgui_nsgui_NSTypography_nLoadFromNative(
        JNIEnv* env,
        jclass,
        jlong nativePtr,
        jobject target
) {
    if (nativePtr == 0 || target == nullptr) return;

    auto* typo = reinterpret_cast<Noesis::Typography*>(nativePtr);

    jclass cls = env->GetObjectClass(target);
    if (cls == nullptr) return;

    jmethodID mid = env->GetMethodID(
            cls,
            "applyFromNativeData",
            "(JIIZZZZIZZIIIZZZZIIZZIIZZZZZZZZZZZZZZZZZZZZI)V"
    );
    env->DeleteLocalRef(cls);

    if (mid == nullptr) {
        return;
    }

    jint annotationAlternates      = typo->GetAnnotationAlternates();
    jint capitalsOrdinal           = static_cast<jint>(typo->GetCapitals());
    jboolean capitalSpacing        = typo->GetCapitalSpacing() ? JNI_TRUE : JNI_FALSE;
    jboolean caseSensitiveForms    = typo->GetCaseSensitiveForms() ? JNI_TRUE : JNI_FALSE;
    jboolean contextualAlternates  = typo->GetContextualAlternates() ? JNI_TRUE : JNI_FALSE;
    jboolean contextualLigatures   = typo->GetContextualLigatures() ? JNI_TRUE : JNI_FALSE;
    jint contextualSwashes         = typo->GetContextualSwashes();
    jboolean discretionaryLigatures= typo->GetDiscretionaryLigatures() ? JNI_TRUE : JNI_FALSE;
    jboolean eastAsianExpertForms  = typo->GetEastAsianExpertForms() ? JNI_TRUE : JNI_FALSE;
    jint eastAsianLanguageOrdinal  = static_cast<jint>(typo->GetEastAsianLanguage());
    jint eastAsianWidthsOrdinal    = static_cast<jint>(typo->GetEastAsianWidths());
    jint fractionOrdinal           = static_cast<jint>(typo->GetFraction());
    jboolean historicalForms       = typo->GetHistoricalForms() ? JNI_TRUE : JNI_FALSE;
    jboolean historicalLigatures   = typo->GetHistoricalLigatures() ? JNI_TRUE : JNI_FALSE;
    jboolean kerning               = typo->GetKerning() ? JNI_TRUE : JNI_FALSE;
    jboolean mathematicalGreek     = typo->GetMathematicalGreek() ? JNI_TRUE : JNI_FALSE;
    jint numeralAlignmentOrdinal   = static_cast<jint>(typo->GetNumeralAlignment());
    jint numeralStyleOrdinal       = static_cast<jint>(typo->GetNumeralStyle());
    jboolean slashedZero           = typo->GetSlashedZero() ? JNI_TRUE : JNI_FALSE;
    jboolean standardLigatures     = typo->GetStandardLigatures() ? JNI_TRUE : JNI_FALSE;
    jint standardSwashes           = typo->GetStandardSwashes();
    jint stylisticAlternates       = typo->GetStylisticAlternates();

    jboolean stylisticSet1  = typo->GetStylisticSet1()  ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet2  = typo->GetStylisticSet2()  ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet3  = typo->GetStylisticSet3()  ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet4  = typo->GetStylisticSet4()  ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet5  = typo->GetStylisticSet5()  ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet6  = typo->GetStylisticSet6()  ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet7  = typo->GetStylisticSet7()  ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet8  = typo->GetStylisticSet8()  ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet9  = typo->GetStylisticSet9()  ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet10 = typo->GetStylisticSet10() ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet11 = typo->GetStylisticSet11() ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet12 = typo->GetStylisticSet12() ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet13 = typo->GetStylisticSet13() ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet14 = typo->GetStylisticSet14() ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet15 = typo->GetStylisticSet15() ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet16 = typo->GetStylisticSet16() ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet17 = typo->GetStylisticSet17() ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet18 = typo->GetStylisticSet18() ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet19 = typo->GetStylisticSet19() ? JNI_TRUE : JNI_FALSE;
    jboolean stylisticSet20 = typo->GetStylisticSet20() ? JNI_TRUE : JNI_FALSE;

    jint variantsOrdinal = static_cast<jint>(typo->GetVariants());

    env->CallVoidMethod(
            target,
            mid,
            annotationAlternates,
            capitalsOrdinal,
            capitalSpacing,
            caseSensitiveForms,
            contextualAlternates,
            contextualLigatures,
            contextualSwashes,
            discretionaryLigatures,
            eastAsianExpertForms,
            eastAsianLanguageOrdinal,
            eastAsianWidthsOrdinal,
            fractionOrdinal,
            historicalForms,
            historicalLigatures,
            kerning,
            mathematicalGreek,
            numeralAlignmentOrdinal,
            numeralStyleOrdinal,
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
            variantsOrdinal
    );
}
}
