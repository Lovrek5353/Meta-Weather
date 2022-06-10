package com.example.metaweather.models.WeatherMapper


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherParams(
    @SerialName("description")
    val description: String?,
    @SerialName("icon")
    val icon: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("main")
    val main: String?
)

data class InfoAboutWeather(
    val id: Int?,
    val weatherType: String?= null,
    val description: String?= null
)

fun WeatherParams.toInfoAboutWheather()=InfoAboutWeather(
    id,
    main,
    description
)
