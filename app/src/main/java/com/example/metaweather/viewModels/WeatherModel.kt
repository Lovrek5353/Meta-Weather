package com.example.metaweather.viewModels

import androidx.lifecycle.ViewModel
import com.example.metaweather.models.Weather
import com.example.metaweather.repository.WeatherRepository
import kotlinx.coroutines.flow.SharedFlow

class WeatherModel(
    var weatherRepository: WeatherRepository
) : ViewModel() {
    fun getWeatherdata(): SharedFlow<Weather> {
        return weatherRepository.loadWeatherData()
    }

    fun getWeatherForecast(): SharedFlow<List<Weather>> {
        return weatherRepository.loadForecastData()
    }

    suspend fun getCityInfo(cityName: String) {
        weatherRepository.getGeoInfoForCity(cityName)
    }

    fun getUnitParam(unitName: String) {
        weatherRepository.getUnitInfo(unit=unitName)

    }
}