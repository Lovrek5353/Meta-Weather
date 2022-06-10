package com.example.metaweather.models.ForecastMapper


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForeCastResponse(
    @SerialName("city")
    val city: City?,
    @SerialName("cnt")
    val cnt: Int?,
    @SerialName("cod")
    val cod: String?,
/*    @SerialName("list")
    val list: List<>?,*/
    @SerialName("message")
    val message: Int?
)