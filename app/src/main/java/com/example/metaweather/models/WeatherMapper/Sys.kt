package com.example.metaweather.models.WeatherMapper



import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sys(
    @SerialName("country")
    val country: String?= null,
    @SerialName("id")
    val id: Int?= null,
/*    @SerialName("message")
    val message: Double?,*/
    @SerialName("sunrise")
    val sunrise: Long?= null,
    @SerialName("sunset")
    val sunset: Long?= null,
    @SerialName("type")
    val type: Int?= null
)

data class GeneralInfo(
    val country: String?,
    val sunsetTime: Long?,
    val sunriseTime: Long?
)

fun Sys.toGeneralInfo()=GeneralInfo(
    country,
    sunset,
    sunrise
)
