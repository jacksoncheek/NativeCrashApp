package com.jacksoncheek.devicepropertieslib

import android.util.Log
import com.jaredrummler.android.device.DeviceName

/**
 * A simple class to retrieve the device name.
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
     * Get the device name. This will be called from the native library though.
     * @return device name
     */
    fun getDeviceName(): String {
        return DeviceName.getDeviceName()
    }

    /**
     * Get the device name through the native library, which calls getDeviceName().
     * @return device name
     */
    fun getDeviceNameNative(): String {

        if (!nativeLibraryLoaded()) {
            Log.d(TAG, "Native library was not loaded")
            return "Error checking device name!"
        }

        setLogDebugMessages(BuildConfig.DEBUG)

        return checkDeviceProperties()
    }

    private external fun checkDeviceProperties(): String

    private external fun setLogDebugMessages(logDebugMessages: Boolean)
}