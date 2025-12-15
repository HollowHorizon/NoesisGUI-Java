//
// Created by Sixik on 16.12.2025.
//

#include <jni.h>

#include "NsGui/ListView.h"


extern "C" {

    JNIEXPORT jlong JNICALL Java_dev_sixik_noesisgui_nsgui_NSListView_nCreate(JNIEnv *env, jclass clazz) {
        return reinterpret_cast<jlong>(new Noesis::ListView());
    }
}
