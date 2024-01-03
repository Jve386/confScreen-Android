package com.jve386.androidconfig

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.jve386.androidconfig.ScreenSettings.SettingsActivity
import com.jve386.androidconfig.databinding.MainActivityBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use View Binding to inflate the layout and initialize the binding object
        binding = MainActivityBinding.inflate(layoutInflater)

        // Set the content view of the activity to the root view of the inflated layout
        setContentView(binding.root)
        binding.btnSettings.setOnClickListener {
            navigateToSettings()
        }
    }

    private fun navigateToSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}