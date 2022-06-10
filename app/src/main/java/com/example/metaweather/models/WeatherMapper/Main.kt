package com.example.metaweather.models.WeatherMapper


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Main(
    @SerialName("feels_like")
    val feelsLike: Double?,
    @SerialName("humidity")
    val humidity: Int?,
    @SerialName("pressure")
    val pressure: Int?,
    @SerialName("temp")
    val temp: Double?,
    @SerialName("temp_max")
    val tempMax: Double?,
    @SerialName("temp_min")
    val tempMin: Double?
)

data class MainParametars(
    val temperature: Double?,
    val feelsLike: Double?,
    val minTemp: Double?,
    val maxTemp: Double?,
    val pressure: Int?,
    val humidity: Int?
)

fun Main.toMainParametars()=MainParametars(
    temp,
    feelsLike,
    tempMin,
    tempMax,
    pressure,
    humidity
)