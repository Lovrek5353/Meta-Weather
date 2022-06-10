package com.example.metaweather.composables


import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import com.example.metaweather.models.Weather


@Composable
fun ForecastList(
    modifier: Modifier=Modifier,
    ForecastItems: List<Weather>?,
){
    Log.d("receivedList",ForecastItems.toString())
    var tempList: MutableList<Weather> = arrayListOf()
    ForecastItems?.forEach {
        tempList.add(it)
    }
    Log.d("givenList",tempList.toString())
    LazyRow(modifier = Modifier.fillMaxWidth()){
        items(tempList){
            ForecastCard(item = it)
        }
    }
/*   LazyRow(){
        items(count = ForecastItems?.size,
        itemContent = ForecastItems){
    }*/
 /* Row(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            //.fillMaxSize()
    ){
       ForecastItems?.forEach{
            ForecastCard(item = it)
        }
    }*/
    
}

@Preview
@Composable
fun ForecastListPreview(){
    ForecastList(
        ForecastItems = listOf(
            Weather(
                visibility = 5,
                time=1234,
                placeName = "Horvati",
                weatherId = 1,
                weatherType = "Clouds",
                weatherDescription = "Clouds",
                temperature = 20.25,
                feelsLike = 21.25,
                minTemp = 17.42,
                maxTemp = 22.52,
                pressure = 1025,
                humidity = 30,
                windSpeed = 5.5,
                windGust = 12.25,
                cloudiness = 13,
                country = "CRO",
                sunsetTime = 2105,
                sunriseTime = 614,
                rainVolume = 0.0,
                snowVolume = 0.0
        ),
            Weather(
                visibility = 5,
                time=1234,
                placeName = "Horvati",
                weatherId = 1,
                weatherType = "Clouds",
                weatherDescription = "Clouds",
                temperature = 20.25,
                feelsLike = 21.25,
                minTemp = 17.42,
                maxTemp = 22.52,
                pressure = 1025,
                humidity = 30,
                windSpeed = 5.5,
                windGust = 12.25,
                cloudiness = 13,
                country = "CRO",
                sunsetTime = 2105,
                sunriseTime = 614,
                rainVolume = 0.0,
                snowVolume = 0.0
        )
    ))
}
