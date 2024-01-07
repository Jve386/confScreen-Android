package com.jve386.androidconfig.screenSettings

// Data class to represent the settings model
data class SettingsModel(
    var volumeLevel: Int,     // Volume level of the device
    var bluetooth: Boolean,    // Bluetooth status (true if enabled, false if disabled)
    var vibration: Boolean,    // Vibration status (true if enabled, false if disabled)
    var darkMode: Boolean      // Dark mode status (true if enabled, false if disabled)
)
