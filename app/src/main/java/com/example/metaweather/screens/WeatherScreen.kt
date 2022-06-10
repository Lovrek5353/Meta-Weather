package com.example.metaweather.screens

import com.example.metaweather.MetaWeatherAppliaction
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.NavController
import com.example.metaweather.R
import com.example.metaweather.composables.ForecastList
import com.example.metaweather.composables.Precipitations
import com.example.metaweather.composables.SunTime
import com.example.metaweather.composables.WeatherDetails
import com.example.metaweather.navigation.Screen
import com.example.metaweather.viewModels.WeatherModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.flow.collect


@Composable
fun WeatherScreen(
    viewModel: WeatherModel,
    navController: NavController
) {
    var weatherdata = viewModel.getWeatherdata().collectAsState(initial = null).value
    var forecast = viewModel.getWeatherForecast().collectAsState(initial = null).value

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                backgroundColor = colorResource(id = R.color.grey)
            ) {
                IconButton(onClick = { navController.navigate(Screen.SettingsScreen.route) }) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = stringResource(id = R.string.settings),
                        tint = White
                    )
                }
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                )
            }

        },
        modifier = Modifier
            .background(Color.Black)
    ) {
            LazyColumn(
                modifier = Modifier
                    .background(Black)
                    .absolutePadding(left = 20.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.width(15.dp))
                }
                item {
                    LazyRow() {
                        item {
                            Text(
                                buildAnnotatedString {
                                    append((weatherdata?.temperature)?.toInt().toString())
                                    append("°")
                                },
                                fontSize = 100.sp,
                                color = White,
                            )
                        }
                        item {
                            var painter: Painter = painterResource(id = R.drawable.sunny)
                            when (weatherdata?.weatherType.toString()) {
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
                                contentDescription = stringResource(id = R.string.current_weather),
                                alignment = Alignment.TopEnd,
                                modifier = Modifier
                                    .absolutePadding(left = 20.dp)
                            )
                        }
                    }
                }
                item {
                    Row() {
                        Text(
                            text = weatherdata?.placeName.toString(),
                            fontSize = 40.sp,
                            color = White
                        )
                        Icon(
                            imageVector = Icons.Filled.Place,
                            contentDescription = stringResource(id = R.string.location_icon),
                            modifier = Modifier
                                .size(40.dp)
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        buildAnnotatedString {
                            append(stringResource(id = R.string.temp_look))
                            append(" ")
                            append(weatherdata?.feelsLike?.toInt().toString())
                            append("°C")
                        },
                        fontSize = 25.sp,
                        color = White
                    )
                    Text(
                        buildAnnotatedString {
                            append(weatherdata?.minTemp?.toInt().toString())
                            append("°C")
                            append(" / ")
                            append(weatherdata?.maxTemp?.toInt().toString())
                            append("°C")
                        },
                        fontSize = 25.sp,
                        color = White
                    )
                    Text(
                        buildAnnotatedString {
                            append(weatherdata?.weatherType.toString())
                            append("  /  ")
                            append(weatherdata?.weatherDescription.toString())
                        },
                        fontSize = 25.sp,
                        color = White
                    )
                }
                item {
                    ForecastList(ForecastItems = forecast)
                }
                item {
                    Spacer(
                        modifier = Modifier
                            .height(10.dp)
                            .background(Color.Black)
                    )
                    SunTime(item = weatherdata)
                }
                item {
                    Spacer(
                        modifier = Modifier
                            .height(15.dp)
                            .background(Color.Black)
                    )
                    WeatherDetails(item = weatherdata)
                }
                item {
                    Spacer(
                        modifier = Modifier
                            .height(15.dp)
                            .background(Color.Black)
                    )
                    Precipitations(item = weatherdata)
                }
            }
        }
}


