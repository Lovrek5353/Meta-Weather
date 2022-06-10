package com.example.metaweather


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.metaweather.navigation.Screen
import com.example.metaweather.ui.theme.MetaWeatherTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MetaWeatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if (isFirstTime()) {
                        Navigation(startRoute = Screen.SettingsScreen.route)
                    } else {
                        Navigation(startRoute = Screen.MainScreen.route)
                    }
                }
            }
        }
    }

    private fun isFirstTime(): Boolean {
        var pref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        var ranBefore: Boolean = pref.getBoolean("RanBefore", false)
        if (!ranBefore) {
            // first time
            val editor = pref.edit()
            editor.putBoolean("RanBefore", true)
            editor.commit()
        }
        return !ranBefore
    }
}




