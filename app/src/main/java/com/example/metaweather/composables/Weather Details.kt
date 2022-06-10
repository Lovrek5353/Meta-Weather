package com.example.metaweather.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.metaweather.R
import com.example.metaweather.models.Weather

@Composable
fun WeatherDetails(
    item: Weather?
){
    Card(
        modifier = Modifier
            .background(Color.Black)
    ){
        Row{
            Column(modifier = Modifier.weight(0.3f)) {
                Image(
                    painter = painterResource(id = R.drawable.atmospheric),
                    contentDescription = stringResource(id = R.string.pressure_image),
                    modifier = Modifier.background(Color.Black)
                )
                Text(text = stringResource(id = R.string.pressure),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                )
                Text(
                    buildAnnotatedString {
                        append(item?.pressure.toString())
                        append(" hPa")
                    },
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)

                )
            }
            Column(modifier = Modifier
                .weight(0.3f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.wind),
                    contentDescription = stringResource(id = R.string.wind_image),
                    modifier = Modifier.background(Color.Black)
                )
                Text(text = stringResource(id = R.string.wind),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                )
                Text(
                buildAnnotatedString {
                    append(item?.windSpeed.toString())
                    append(" km/h")
                },
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)

                )
            }
            Column(modifier = Modifier
                .weight(0.3f)
                .background(Color.Black)
            ) {
                Image(painter = painterResource(id = R.drawable.humidity) ,
                    contentDescription = stringResource(id = R.string.humidity_image),
                    modifier = Modifier.background(Color.Black)
                )
                Text(text = stringResource(id = R.string.humidity),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                    .fillMaxWidth()
                        .background(Color.Black)
                )
                Text(
                    buildAnnotatedString {
                        append(item?.humidity.toString())
                        append(" %")
                    },
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                )
            }
            
        }
    }
}

@Preview
@Composable
fun WeatherDetailsPreview(){
    WeatherDetails(
        item= Weather(
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
    )
}


