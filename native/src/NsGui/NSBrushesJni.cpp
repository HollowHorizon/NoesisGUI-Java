//
// Created by Sixik on 10.12.2025.
//

#include <jni.h>
#include <jni_md.h>

#include "NsGui/Brushes.h"

extern "C" {

JNIEXPORT jlong JNICALL
Java_dev_sixik_noesisgui_nsgui_NSBrushes_nFromIndex(JNIEnv *, jclass, jint index) {
    return reinterpret_cast<jlong>(Noesis::Brushes::FromIndex(index));
}
}
