package com.jve386.androidconfig.screenSettings

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.android.material.slider.RangeSlider
import com.google.android.material.switchmaterial.SwitchMaterial
import com.jve386.androidconfig.R
import com.jve386.androidconfig.databinding.ActivitySettingsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsActivity : AppCompatActivity() {

    companion object {
        const val VOLUME_LEVEL = "volume_lvl"
        const val KEY_BLUETOOTH = "key_bluetooth"
        const val KEY_VIBRATION = "key_vibration"
        const val KEY_DARKMODE = "key_darkmode"
    }

    private lateinit var binding: ActivitySettingsBinding
    private var firstTime: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()

        CoroutineScope(Dispatchers.IO).launch {
            getSettings().filter { firstTime }.collect { settingsModel ->
                if (settingsModel != null) {
                    runOnUiThread {
                        binding.swtBluetooth.isChecked = settingsModel.bluetooth
                        binding.swtVibration.isChecked = settingsModel.vibration
                        binding.swtDarkMode.isChecked = settingsModel.darkMode
                        binding.rsVolume.setValues(settingsModel.volumeLevel.toFloat())
                        firstTime = !firstTime
                    }
                }
            }
        }

    }

    private fun initUI() {
        binding.rsVolume.addOnChangeListener { _, value, _ ->
            CoroutineScope(Dispatchers.IO).launch {
                saveVolume(value.toInt())
            }
        }

        binding.swtBluetooth.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveChecks(KEY_BLUETOOTH, value)
            }
        }

        binding.swtVibration.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveChecks(KEY_VIBRATION, value)
            }
        }

        binding.swtDarkMode.setOnCheckedChangeListener { _, value ->
            if (value) {
                enableDarkMode()
            } else {
                disableDarkMode()
            }
            CoroutineScope(Dispatchers.IO).launch {
                saveChecks(KEY_DARKMODE, value)
            }
        }

    }

    private suspend fun saveVolume(value: Int) {
        dataStore.edit { preferences ->
            preferences[intPreferencesKey(VOLUME_LEVEL)] = value
        }
    }

    private suspend fun saveChecks(key: String, value: Boolean) {
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(key)] = value
        }
    }

    private fun getSettings(): Flow<SettingsModel?> {
        return dataStore.data.map { preferences ->
            SettingsModel(
                preferences[intPreferencesKey(VOLUME_LEVEL)] ?: 50,
                preferences[booleanPreferencesKey(KEY_BLUETOOTH)] ?: true,
                preferences[booleanPreferencesKey(KEY_VIBRATION)] ?: false,
                preferences[booleanPreferencesKey(KEY_DARKMODE)] ?: true
            )
        }
    }

    private fun enableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        delegate.applyDayNight()
    }

    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        delegate.applyDayNight()
    }
}