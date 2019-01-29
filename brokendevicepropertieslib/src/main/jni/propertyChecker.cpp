/****************************************************************************
 * File:        propertyChecker.cpp
 * Author:      Jackson Cheek
 * Date:        12/3/2018
 * Description: Device name checking with JNI NDK code.
 ****************************************************************************/

/****************************************************************************
 *>>>>>>>>>>>>>>>>>>>>>>>>> System Includes <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*
 ****************************************************************************/

// Android headers
#include <jni.h>
#include <android/log.h>

// String / file headers
#include <string.h>
#include <stdio.h>
#include <csignal>

/****************************************************************************
 *>>>>>>>>>>>>>>>>>>>>>>>>>> User Includes <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*
 ****************************************************************************/
#include "propertyChecker.h"

/****************************************************************************
 *>>>>>>>>>>>>>>>>>>>>>>>>>> Constant Macros <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*
 ****************************************************************************/

// LOGCAT
#define  LOG_TAG    "PropertyChecker"
#define  LOGD(...)  if (DEBUG) __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__);

// Set to 1 to enable debug log traces.
static int DEBUG = 1;

/****************************************************************************
 * Description: Enables debug logging.
 *
 * Parameters:
 *     env  - Java environment pointer
 *     jobj - javaobject
 * 	   bool - true to log debug messages
 ****************************************************************************/
void Java_com_jacksoncheek_devicepropertieslib_DevicePropertiesNative_setLogDebugMessages( JNIEnv* env, jobject jobj, jboolean debug)
{
    if (debug){
        DEBUG = 1;
    }
    else{
        DEBUG = 0;
    }
}

/****************************************************************************
 * Description: Accidentally force a stack overflow error by calling a
 * non-terminating recursive function.
 *
 * Parameters:
 *     int  - Seed integer to start recursive counting at
 ****************************************************************************/
void accidentallyForceStackOverflow(int seed)
{
    printf("Overflow: %d\n", seed);
    accidentallyForceStackOverflow(seed+1);
}

/****************************************************************************
 * Description: Gets device name.
 *
 * Parameters:
 *     env  - Java environment pointer
 *     jobj - javaobject
 *
 * Return: String of device name.
 ****************************************************************************/
jstring Java_com_jacksoncheek_devicepropertieslib_DevicePropertiesNative_checkDeviceProperties( JNIEnv* env, jobject jobj)
{
    jclass clazz = (env)->FindClass("com/jacksoncheek/devicepropertieslib/DevicePropertiesNative");

    jmethodID getDeviceName = (env)->GetMethodID(clazz, "getDeviceName", "()Ljava/lang/String;");

    jobject result = (env)->CallObjectMethod(jobj, getDeviceName);

    const char *properties = (env)->GetStringUTFChars((jstring) result, 0);

    LOGD("Forcing segmentation fault!");
    accidentallyForceStackOverflow(0);

    return (env)->NewStringUTF(properties);
}