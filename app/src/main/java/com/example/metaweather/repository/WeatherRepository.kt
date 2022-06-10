package com.example.metaweather.repository

import com.example.metaweather.models.Weather
import com.example.metaweather.models.WeatherMapper.*
import com.example.metaweather.models.toWeather
import com.example.metaweather.networking.WeatherApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

interface WeatherRepository {

    fun loadWeatherData(): SharedFlow<Weather>
    fun loadForecastData(): SharedFlow<List<Weather>>
    suspend fun getGeoInfoForCity(cityName: String)
    fun getUnitInfo(unit: String)
}

internal class WeatherRepositoryImpl(
    private val weatherApi: WeatherApi,
) : WeatherRepository {
    private val flowScope = CoroutineScope(Dispatchers.Default)
    private var name: String = "Zagreb"
    private var unitParam: String="metric"
    private val weatherDataPublisher = MutableSharedFlow<Weather>()
    private val weatherForecastPublisher = MutableSharedFlow<List<Weather>>()

    override suspend fun getGeoInfoForCity(cityName: String) {
        name = cityName
    }

    override fun getUnitInfo(unit: String) {
        unitParam=unit
    }


    private val weatherDataInitialFlow =
        flow {
            val res = weatherApi.fetchCurrentWheater(name = name, unit=unitParam)
            val main = res.main?.toMainParametars()
            val weather = res.weather?.map { it.toInfoAboutWheather() }
            val wind = res.wind?.toWindParams()
            val cloud = res.clouds?.toCloud()
            val system = res.sys?.toGeneralInfo()
            val rain = res.rain?.toRainParams()
            val snow = res.snow?.toSnowParams()
            emit(
                weatherApi.fetchCurrentWheater(name = name,unit=unitParam)
                    .toWeather(weather, main, wind, cloud, system, rain, snow)
            )
        }
            .shareIn(
                flowScope,
                SharingStarted.WhileSubscribed(),
                replay = 1
            )
    private val weatherForecastInitialFlow =
        flow {
            val forecast =
                weatherApi.fetchCurrentForecast(name = name,unit=unitParam)
            for (it in forecast.forecast) {
                val main = it.main?.toMainParametars()
                val weather = it.weather?.map { it.toInfoAboutWheather() }
                val wind = it.wind?.toWindParams()
                val cloud = it.clouds?.toCloud()
                val system = it.sys?.toGeneralInfo()
                val rain = it.rain?.toRainParams()
                val snow = it.snow?.toSnowParams()
                emit(forecast.forecast.map {
                    it.toWeather(
                        weather,
                        main,
                        wind,
                        cloud,
                        system,
                        rain,
                        snow
                    )
                })
            }
        }
            .shareIn(
                flowScope,
                SharingStarted.WhileSubscribed(),
                replay = 1
            )


    private val weatherData = merge(
        weatherDataInitialFlow,
        weatherDataPublisher
    )
        .shareIn(
            flowScope,
            SharingStarted.WhileSubscribed(),
            replay = 1
        )
    private val forecastData = merge(
        weatherForecastInitialFlow,
        weatherForecastPublisher
    )
        .shareIn(
            flowScope,
            SharingStarted.WhileSubscribed(),
            replay = 1
        )

    override fun loadWeatherData(): SharedFlow<Weather> = weatherData
    override fun loadForecastData(): SharedFlow<List<Weather>> = forecastData

}