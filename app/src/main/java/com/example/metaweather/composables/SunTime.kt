package com.example.metaweather.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.metaweather.R
import com.example.metaweather.models.Weather


@Composable
fun SunTime(
    item: Weather?
) {
    Card(
        modifier = Modifier
            .background(Color.Black)
    ) {
        Row {
            Column(modifier = Modifier
                .weight(0.5f)
                .background(Color.Black)
            ) {
                Text(
                    text = stringResource(id = R.string.sunrise),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                )
                Text(
                    text = "06:56:00",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                )
                Image(
                    painter = painterResource(id = R.drawable.sunrise),
                    contentDescription = stringResource(id = R.string.sunrise_image),
                    modifier = Modifier.background(Color.Black)
                )
            }
            Column(modifier = Modifier
                .weight(0.5f)
                .background(Color.Black)
            ) {
                Text(
                    text = stringResource(id = R.string.sunset),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                )
                Text(
                    text = "17:24:00",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                )
                Image(
                    painter = painterResource(id = R.drawable.sunset),
                    contentDescription = stringResource(id = R.string.sunrise_image),
                    modifier = Modifier.background(Color.Black)
                )
            }
        }
    }
}


@Preview
@Composable
fun SunTimePreview() {
    SunTime(
        item = Weather(
            visibility = 5,
            time = 1234,
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

        ) //TODO()
    )
}