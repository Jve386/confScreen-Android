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

        val swt = findViewById<SwitchMaterial>(R.id.swtDarkMode)

        swt.setOnClickListener {
            if (swt.isChecked) {
                Toast.makeText(applicationContext, "Switch is on", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "Switch is off", Toast.LENGTH_LONG).show()
            }
        }
    }
}