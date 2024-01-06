package com.jve386.androidconfig.screenSettings

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.switchmaterial.SwitchMaterial
import com.jve386.androidconfig.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val swtDarkMode = findViewById<SwitchMaterial>(R.id.swtDarkMode)
        val swtBluetooth = findViewById<SwitchMaterial>(R.id.swtBluetooth)
        val swtvibrate = findViewById<SwitchMaterial>(R.id.swtVibration)

        swtDarkMode.setOnClickListener {
            if (swtDarkMode.isChecked) {
                Toast.makeText(applicationContext, "Dark Mode switch is on", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "Dark Mode switch is off", Toast.LENGTH_LONG).show()
            }
        }

        swtBluetooth.setOnClickListener {
            if (swtBluetooth.isChecked) {
                Toast.makeText(applicationContext, "Bluetooth switch is on", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "Bluetooth switch is off", Toast.LENGTH_LONG).show()
            }
        }

        swtvibrate.setOnClickListener {
            if (swtvibrate.isChecked) {
                Toast.makeText(applicationContext, "Vibration switch is on", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "Vibration switch is off", Toast.LENGTH_LONG).show()
            }
        }


    }
}