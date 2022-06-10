package com.example.metaweather.models

import com.example.metaweather.models.WeatherMapper.MainResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastResponseList(
    @SerialName("list")
    val forecast: List<MainResponse>
)
