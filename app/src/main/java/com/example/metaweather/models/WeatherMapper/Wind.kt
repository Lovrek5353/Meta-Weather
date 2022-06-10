package com.example.metaweather.models.WeatherMapper


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Wind(
    @SerialName("deg")
    val deg: Double?,
    @SerialName("speed")
    val speed: Double?
)

data class WindParams(
    val windSpeed: Double?= null,
    val windGust: Double?= null
)

fun Wind.toWindParams()=WindParams(
    speed,
    deg
)