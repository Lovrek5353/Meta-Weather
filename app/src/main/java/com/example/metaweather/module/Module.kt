package com.example.metaweather.module

import com.example.metaweather.networking.KtorClient
import com.example.metaweather.networking.WeatherApi
import com.example.metaweather.networking.WeatherApiImpl
import com.example.metaweather.repository.WeatherRepository
import com.example.metaweather.repository.WeatherRepositoryImpl

import com.example.metaweather.viewModels.WeatherModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
val httpClientModule= module{
    single{KtorClient.httpClient}
}

val weatherModule= module{
    viewModel {
        WeatherModel(weatherRepository = get())
    }
}
val repositoryModule = module{
    single{ WeatherRepositoryImpl(get())}
    single<WeatherRepository> {WeatherRepositoryImpl(get())}
}
val apiModule=module{
    single<WeatherApi>{
       WeatherApiImpl(get())
    }
}