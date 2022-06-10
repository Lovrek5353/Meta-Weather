package com.example.metaweather.navigation

sealed class Screen(val route: String){
    object MainScreen: Screen("main")
    object SettingsScreen: Screen("setting")
}