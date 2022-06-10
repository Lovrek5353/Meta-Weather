package com.example.metaweather.networking

import com.example.metaweather.models.*
import com.example.metaweather.models.WeatherMapper.MainResponse
import io.ktor.client.*

import io.ktor.client.request.*

interface WeatherApi {
    suspend fun fetchCurrentWheater(name: String, unit:String): MainResponse
    suspend fun fetchCurrentForecast(name: String, unit:String): ForecastResponseList

}

internal class WeatherApiImpl(private val client: HttpClient): WeatherApi{

override suspend fun fetchCurrentWheater(name: String, unit: String): MainResponse =
    client.get(
        "${HttpRoutes.baseURL}weather?q=$name&appid=${HttpRoutes.apiKey}&units=$unit"
    )

    override suspend fun fetchCurrentForecast(name: String, unit: String): ForecastResponseList =
        client.get(
            "${HttpRoutes.baseURL}forecast?q=$name&appid=${HttpRoutes.apiKey}&units=$unit"
        )
}