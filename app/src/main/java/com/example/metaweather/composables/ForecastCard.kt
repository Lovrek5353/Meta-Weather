package com.example.metaweather.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.metaweather.R
import com.example.metaweather.models.Weather
import java.text.SimpleDateFormat


@Composable
fun ForecastCard(
    item: Weather
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.Black)
    ) {
        val simpleDate = SimpleDateFormat("HH:mm:ss")
        val currentDate = simpleDate.format(item.time?.times(1000))

        Text(
            text = currentDate.toString(),
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        )
        var painter: Painter = painterResource(id = R.drawable.sunny)
        when (item?.weatherType.toString()) {
            "Clear" -> painter = painterResource(id = R.drawable.sunny)
            "Clouds" -> painter = painterResource(id = R.drawable.cloudy)
            "Rain" -> painter = painterResource(id = R.drawable.rain)
            "Sunny" -> painter = painterResource(id = R.drawable.sunny)
            "Thunderstorm" -> painter = painterResource(id = R.drawable.storm)
            "Drizzle" -> painter = painterResource(id = R.drawable.drizzle)
            "Snow" -> painter = painterResource(id = R.drawable.snow)
            "Mist" -> painter = painterResource(id = R.drawable.mist)
        }
        Image(
            painter = painter,
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(id = R.string.forecast_weather),
            alignment = Alignment.Center,
            modifier = Modifier
                .scale(0.5f)
                .background(Color.Black)
        )
        Text(
            buildAnnotatedString {
                append(item?.temperature?.toInt().toString())
                append("°C")
            },
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        )
        if (item?.rainVolume == null) {
            Text(
                text = "0%",
                color = Color.White,
                modifier = Modifier.background(Color.Black)
            )
        } else {
            Text(
                buildAnnotatedString {
                    append(item?.rainVolume?.toInt().toString())
                    append(" %")
                },
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
            )
        }

        Text(
            text=item.weatherDescription.toString().capitalize(),
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        )
    }

}

@Preview
@Composable
fun ForecastCardPreview() {
    ForecastCard(
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

        )
    )
}
