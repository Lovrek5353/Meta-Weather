package com.example.metaweather.screens

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.metaweather.R
import com.example.metaweather.composables.CityTextField
import org.koin.androidx.compose.get
import com.example.metaweather.navigation.Screen
import com.example.metaweather.ui.theme.Purple200
import com.example.metaweather.viewModels.WeatherModel


@Composable
fun SettingsScreen(
    viewModel: WeatherModel,
    navController: NavController
){
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar ={
            TopAppBar(
                backgroundColor= colorResource(id = R.color.grey)

            ) {
                IconButton(onClick = {navController.navigate(Screen.MainScreen.route) }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_arrow),
                        tint = Color.White
                    )

                }
                Text(
                    text = stringResource(id = R.string.app_name),
                    color=White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                )
            }

        },
        backgroundColor = Black
    ) {
        Column(modifier = Modifier
            .background(Black)
            .fillMaxSize()
            .absolutePadding(left = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = stringResource(
                id = R.string.select_location),
                color= White,
                fontSize = 40.sp,
                modifier = Modifier
                    .background(Black),

            )
            Spacer(modifier = Modifier
                .height(5.dp)
                .background(Black)
            )
            CityTextField(viewModel = viewModel, navController = navController)

            Spacer(modifier = Modifier
                .height(20.dp)
                .background(Black)
            )

            Text(
                text= "Choose units: ",
                color = White,
                fontSize = 40.sp,
                modifier = Modifier
                    .background(Black)
            )
            val selectedValue=remember{ mutableStateOf("")}
            val labelMetric="Metric"
            val labelImperial="Imperial"

            Row{
                RadioButton(
                    selected =selectedValue.value==labelMetric,
                    onClick = { viewModel.getUnitParam(labelMetric.toLowerCase())},
                    colors= RadioButtonDefaults.colors(
                        unselectedColor = White,
                        selectedColor = Purple200
                    )
                )
                Text(
                    text = labelMetric,
                    color= White,
                    fontSize = 30.sp,
                )
                Spacer(modifier = Modifier
                    .background(Black)
                    .width(20.dp)
                )
                RadioButton(
                    selected = selectedValue.value==labelImperial ,
                    onClick = { viewModel.getUnitParam(labelImperial.toLowerCase())},
                    colors= RadioButtonDefaults.colors(
                        unselectedColor = White,
                        selectedColor = Purple200
                    )
                )
                Text(text = labelImperial, color= White,fontSize = 30.sp)
            }
/*            Text(
                text = stringResource(id = R.string.notification),
                color=White,
                modifier = Modifier
                    .background(Black)
            )
            Spacer(modifier = Modifier
                .height(5.dp)
                .background(Black)
            )
            val checkedState = remember { mutableStateOf(true) }
            Switch(
                checked=checkedState.value,
                onCheckedChange = { checkedState.value = it }
            )*/
        }

    }
    suspend fun enterParams(name: String){
        viewModel.weatherRepository.getGeoInfoForCity(name)
        navController.navigate(Screen.MainScreen.route)
    }
}



/*
@Preview
@Composable
fun SettingsScreenPreview(){
    SettingsScreen()
}*/
