package com.jacksoncheek.nativecrashapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.scottyab.rootbeer.RootBeer

class MainActivity : AppCompatActivity() {

    private lateinit var isRootedTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isRootedTextView = findViewById(R.id.root_check)

        val rootbeer = RootBeer(this)

        if (rootbeer.checkForRootNative()) {
            isRootedTextView.text = this.getText(R.string.device_rooted)
        } else {
            isRootedTextView.text = this.getText(R.string.device_not_rooted)
        }
    }
}
