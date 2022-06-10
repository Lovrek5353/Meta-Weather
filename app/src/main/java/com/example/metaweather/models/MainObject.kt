package com.example.metaweather.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainObject(
    @SerialName("temp")
    val temperature: Float?= null,
    @SerialName("feels_like")
    val feelsLike: Float?= null,
    @SerialName("temp_min")
    val minTemp: Float?= null,
    @SerialName("temp_max")
    val maxTemp: Float?= null,
    @SerialName("pressure")
    val pressure: Int?= null,
    @SerialName("humidity")
    val humidity: Int?= null
)

data class Main(
    val temperature: Float?,
    val feelsLike: Float?,
    val minTemp: Float?,
    val maxTemp: Float?,
    val pressure: Int?,
    val humidity: Int?
)

fun MainObject.toMain()=Main(
    temperature,
    feelsLike,
    minTemp,
    maxTemp,
    pressure,
    humidity
)

