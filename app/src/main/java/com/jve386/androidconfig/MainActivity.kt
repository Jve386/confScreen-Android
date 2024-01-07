package com.jve386.androidconfig

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.jve386.androidconfig.screenSettings.SettingsActivity
import com.jve386.androidconfig.databinding.MainActivityBinding

// Main activity responsible for displaying the main screen
class MainActivity : ComponentActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use View Binding to inflate the layout and initialize the binding object
        binding = MainActivityBinding.inflate(layoutInflater)

        // Set the content view of the activity to the root view of the inflated layout
        setContentView(binding.root)

        // Set a click listener for the "Settings" button
        binding.btnSettings.setOnClickListener {
            // Navigate to the settings screen
            navigateToSettings()
        }
    }

    // Function to navigate to the SettingsActivity
    private fun navigateToSettings() {
        // Create an intent to start the SettingsActivity
        val intent = Intent(this, SettingsActivity::class.java)

        // Start the SettingsActivity
        startActivity(intent)
    }
}
