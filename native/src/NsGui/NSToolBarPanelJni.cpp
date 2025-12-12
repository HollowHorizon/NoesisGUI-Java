//
// Created by Sixik on 12.12.2025.
//

#include <jni.h>

#include "NsGui/ToolBarPanel.h"

extern "C" {

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSToolBarPanel_nCreate(JNIEnv *env, jclass clazz) {
        return reinterpret_cast<jlong>(new Noesis::ToolBarPanel());
    }
}
