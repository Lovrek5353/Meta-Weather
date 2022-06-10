package com.example.metaweather.models

import com.example.metaweather.models.WeatherMapper.*
import com.example.metaweather.models.WeatherMapper.Cloud

data class Weather(
   val visibility: Int?,
    val time: Long?,
    val placeName: String?,
   val weatherId: Int?,
    val weatherType: String?,
    val weatherDescription: String?,
    val temperature: Double?,
    val feelsLike: Double?,
    val minTemp: Double?,
    val maxTemp: Double?,
    val pressure: Int?,
    val humidity: Int?,
    val windSpeed: Double?,
    val windGust: Double?,
    val cloudiness: Int?,
    val country: String?,
    val sunriseTime: Long?,
    val sunsetTime: Long?,
    val rainVolume: Double?,
    val snowVolume: Double?,
)



/*data class Wheater(
    val temp: Float,
    val humidity: Int
)

fun WheaterResponse.toWheater()=Wheater(
    temp,
    humidity
)*/


/*fun WeatherResponse.toWeather(main: Main, wind: Wind, cloud: Cloud, system: GeneralInfo, rain: Rain?, snow: Snow? )=Weather(
    visibility,
    dt,
    cityName,
*//*    wheaterId = wheater.id,
    wheaterType = wheater.wheaterType,
    wheaterDescription = wheater.description,*//*
    temperature = main.temperature,
    feelsLike = main.feelsLike,
    minTemp = main.minTemp,
    maxTemp = main.maxTemp,
    pressure = main.pressure,
    humidity = main.humidity,
    windGust = wind.windGust,
    windSpeed = wind.windSpeed,
    cloudiness = cloud.cloudiness,
    country = system.country,
    sunriseTime = system.sunriseTime,
    sunsetTime = system.sunsetTime,
    rainVolume = rain?.rainVolume,
    snowVolume = snow?.snowVolume
)*/
fun MainResponse.toWeather(weather: List<InfoAboutWeather>?, main: MainParametars?, wind: WindParams?, cloud: Cloud?, system: GeneralInfo?, rain: RainParams?, snow: SnowParams?)=Weather(
    visibility,
    dt,
    name,
    weatherId = weather?.first()?.id,
    weatherType = weather?.first()?.weatherType,
    weatherDescription = weather?.first()?.description,
    temperature = main?.temperature,
    feelsLike = main?.feelsLike,
    minTemp = main?.minTemp,
    maxTemp = main?.maxTemp,
    pressure = main?.pressure,
    humidity = main?.humidity,
    windGust = wind?.windGust,
    windSpeed = wind?.windSpeed,
    cloudiness = cloud?.cloudiness,
    country = system?.country,
    sunriseTime = system?.sunriseTime,
    sunsetTime = system?.sunsetTime,
    rainVolume = rain?.rainVolume,
    snowVolume = snow?.snowVolume
)


