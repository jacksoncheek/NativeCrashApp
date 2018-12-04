package com.jacksoncheek.devicepropertieslib

import android.os.Build
import android.util.Log

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

        val deviceProperties = StringBuilder()

        deviceProperties.append("Device: ${Build.DEVICE}")
        deviceProperties.append("\nManufacturer: ${Build.MANUFACTURER}")
        deviceProperties.append("\nModel: ${Build.MODEL}")
        deviceProperties.append("\nVersion.Release: ${Build.VERSION.RELEASE}")
        deviceProperties.append("\nVersion.Incremental: ${Build.VERSION.INCREMENTAL}")
        deviceProperties.append("\nVersion.SDK: ${Build.VERSION.SDK_INT}")
        deviceProperties.append("\nFingerprint: ${Build.FINGERPRINT}")
        deviceProperties.append("\nBoard: ${Build.BOARD}")
        deviceProperties.append("\nBrand: ${Build.BRAND}")

        return deviceProperties.toString()
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