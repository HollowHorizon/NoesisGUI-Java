//
// Created by Sixik on 11.12.2025.
//

#include <jni.h>
#include <jni_md.h>

#include "NsGui/StatusBarItem.h"

extern "C" {

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSStatusBarItem_nCreate(JNIEnv* env, jclass clazz) {
        return reinterpret_cast<jlong>(new Noesis::StatusBarItem());
    }

}
