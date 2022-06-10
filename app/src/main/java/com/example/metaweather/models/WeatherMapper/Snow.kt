package com.example.metaweather.models.WeatherMapper

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Snow(
    @SerialName("1h")
    val snowVolume: Double?= null,
)

data class SnowParams(
    val snowVolume: Double?
)

fun Snow.toSnowParams()=SnowParams(
    snowVolume
)

