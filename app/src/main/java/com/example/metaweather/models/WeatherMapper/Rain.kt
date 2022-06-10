package com.example.metaweather.models.WeatherMapper


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rain(
    @SerialName("1h")
    val rainVolume: Double?= null
)

data class RainParams(
    val rainVolume: Double?
)

fun Rain.toRainParams()=RainParams(
    rainVolume
)
