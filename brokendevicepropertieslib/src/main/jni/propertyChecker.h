/****************************************************************************
 * File:        propertyChecker.cpp
 * Author:      Jackson Cheek
 * Date:        12/3/2018
 * Description: Device property checking with JNI NDK code.
 ****************************************************************************/

extern "C" {

#include <jni.h>

void Java_com_jacksoncheek_devicepropertieslib_DevicePropertiesNative_setLogDebugMessages( JNIEnv* env, jobject jobj, jboolean debug);

jstring Java_com_jacksoncheek_devicepropertieslib_DevicePropertiesNative_checkDeviceProperties( JNIEnv* env, jobject jobj);

}