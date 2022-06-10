package com.example.metaweather.models.WeatherMapper


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Clouds(
    @SerialName("all")
    val all: Int?
)

data class Cloud(
    val cloudiness: Int?
)

fun Clouds.toCloud()=Cloud(
    all
)