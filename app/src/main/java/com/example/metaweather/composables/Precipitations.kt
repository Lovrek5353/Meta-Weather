package com.example.metaweather.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.metaweather.R
import com.example.metaweather.models.Weather

@Composable
fun Precipitations(
    item: Weather?
) {
    Card() {
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Black)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rain),
                    contentDescription = stringResource(id = R.string.rain_img),
                    modifier = Modifier
                        .background(Color.Black)
                        .scale(0.8f)
                )
                Text(
                    text = stringResource(id = R.string.rain),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                )
                if (item?.rainVolume==null){
                    Text(
                        text ="0 mm",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Black)
                    )
                }
                else{
                    Text(
                        buildAnnotatedString {
                            append(item?.rainVolume.toString())
                            append(" mm")
                        },
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Black)
                    )
                }

            }
            Column(
            modifier = Modifier
                .weight(1f)
                .background(Color.Black)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.snow),
                    contentDescription = stringResource(id = R.string.snow_img),
                    modifier = Modifier
                        .background(Color.Black)
                        .scale(0.8f)

                )
                Text(
                    text = stringResource(id = R.string.snow),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                )
                if(item?.snowVolume==null){
                    Text(
                        text ="0 mm",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Black)
                    )
                }
                else{
                    Text(
                        buildAnnotatedString {
                            append(item?.snowVolume.toString())
                            append(" mm")
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
}

@Preview
@Composable
fun PrecipitationsPreview() {
    Precipitations(
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

