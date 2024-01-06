package com.jve386.androidconfig.screenSettings

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.switchmaterial.SwitchMaterial
import com.jve386.androidconfig.R
import kotlin.math.log

class SettingsActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val swtch = findViewById<Switch>(R.id.sbtnDarkmode) as SwitchMaterial

        swtch.setOnClickListener{
            if(swtch.isChecked){
                Toast.makeText(applicationContext, "Switch is on", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(applicationContext, "Switch is off", Toast.LENGTH_LONG).show()
            }

        }
    }
}
