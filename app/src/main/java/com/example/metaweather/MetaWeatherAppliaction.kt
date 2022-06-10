package com.example.metaweather

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.metaweather.module.apiModule
import com.example.metaweather.module.httpClientModule
import com.example.metaweather.module.repositoryModule
import com.example.metaweather.navigation.Screen
import com.example.metaweather.screens.SettingsScreen
import com.example.metaweather.screens.WeatherScreen
import com.example.metaweather.viewModels.WeatherModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.compose.get
import org.koin.core.context.startKoin


class MetaWeatherAppliaction : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MetaWeatherAppliaction)
            modules(
                httpClientModule,
                repositoryModule,
                apiModule
            )
        }
    }
}


@Composable
fun Navigation(startRoute: String) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startRoute
    )
    {
        composable(route = Screen.MainScreen.route) {
            WeatherScreen(
                viewModel = WeatherModel(weatherRepository = get()),
                navController = navController
            )
        }
        composable(route = Screen.SettingsScreen.route) {
            SettingsScreen(
                navController = navController,
                viewModel = WeatherModel(weatherRepository = get())
            )
        }
    }
}
