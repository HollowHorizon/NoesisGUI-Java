//
// Created by Sixik on 11.12.2025.
//

#include <jni.h>

#include "NsGui/CheckBox.h"

extern "C" {

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSCheckBox_nCreate(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(new Noesis::CheckBox());
    }
}
