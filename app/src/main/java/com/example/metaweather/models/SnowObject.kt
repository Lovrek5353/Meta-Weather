package com.example.metaweather.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SnowObject(
    @SerialName("1h")
    val snowVolume: Int?= null,
)

data class Snow(
    val snowVolume: Int?
)

fun SnowObject.toSnow()=Snow(
    snowVolume
)
