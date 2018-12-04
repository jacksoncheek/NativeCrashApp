package com.jacksoncheek.nativecrashapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.jacksoncheek.devicepropertieslib.DevicePropertiesNative

class MainActivity : AppCompatActivity() {

    private lateinit var devicePropertiesTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        devicePropertiesTextView = this.findViewById(R.id.device_properties)

        val deviceProperties = DevicePropertiesNative()

        devicePropertiesTextView.text = deviceProperties.getDevicePropertiesNative()
    }
}
