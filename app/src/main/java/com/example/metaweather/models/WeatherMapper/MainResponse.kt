package com.example.metaweather.models.WeatherMapper


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainResponse(
    @SerialName("base")
    val base: String?=null,
    @SerialName("clouds")
    val clouds: Clouds?=null,
    @SerialName("cod")
    val cod: Int?=null,
    @SerialName("coord")
    val coord: Coord?=null,
    @SerialName("dt")
    val dt: Long?=null,
    @SerialName("id")
    val id: Int?=null,
    @SerialName("main")
    val main: Main?=null,
    @SerialName("name")
    val name: String?=null,
    @SerialName("sys")
    val sys: Sys?=null,
    @SerialName("timezone")
    val timezone: Int?=null,
    @SerialName("visibility")
    val visibility: Int?=null,
    @SerialName("weather")
    val weather: List<WeatherParams>?=null,
    @SerialName("wind")
    val wind: Wind?=null,
    @SerialName("rain")
    val rain: Rain?=null,
    @SerialName("snow")
    val snow: Snow?=null
)