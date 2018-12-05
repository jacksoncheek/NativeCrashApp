package com.jacksoncheek.devicepropertieslib

import android.os.Build
import android.util.Log
import com.jaredrummler.android.device.DeviceName

/**
 * A simple class to retrieve device properties.
 */
class DevicePropertiesNative {

    private val TAG = "DevicePropertiesNative"

    private var libraryLoaded = false

    /**
     * Loads the C/C++ libraries.
     */
    init {
        try {
            System.loadLibrary("property-checker")
            libraryLoaded = true
        } catch (error: UnsatisfiedLinkError) {
            Log.d(TAG, "Error loading library", error)
        }
    }

    /**
     * Checks if the native library was loaded.
     * @return true if loaded | false if not
     */
    private fun nativeLibraryLoaded(): Boolean {
        return libraryLoaded
    }

    /**
     * Get the device properties. This will be called from the native library though.
     * @return device properties
     */
    fun getDeviceProperties(): String {
        return DeviceName.getDeviceName()
    }

    /**
     * Get the device properties through the native library, which calls getDeviceProperties().
     * @return device properties
     */
    fun getDevicePropertiesNative(): String {

        if (!nativeLibraryLoaded()) {
            Log.d(TAG, "Native library was not loaded")
            return "Error checking device properties!"
        }

        setLogDebugMessages(BuildConfig.DEBUG)

        return checkDeviceProperties()
    }

    private external fun checkDeviceProperties(): String

    private external fun setLogDebugMessages(logDebugMessages: Boolean)
}