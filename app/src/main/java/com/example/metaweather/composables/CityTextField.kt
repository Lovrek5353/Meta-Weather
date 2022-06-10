package com.example.metaweather.composables

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.metaweather.R
import com.example.metaweather.navigation.Screen
import com.example.metaweather.repository.WeatherRepository
import com.example.metaweather.repository.WeatherRepositoryImpl
import com.example.metaweather.viewModels.WeatherModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get

@Composable
fun CityTextField(
    navController: NavController,
    viewModel: WeatherModel,
){
    //val scaffoldState: ScaffoldState = rememberScaffoldState()
    //var text: String= ""
    val coroutineScope= rememberCoroutineScope()
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        colors=TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color.Black,
            textColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor =Color.White,
            unfocusedLabelColor = Color.White,
            unfocusedBorderColor = Color.White
        ),
        value = text ,
        onValueChange = {
            text= it
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Place,
                contentDescription = stringResource(id = R.string.location_icon) )
        },
        trailingIcon = {
                       IconButton(onClick = {
                           coroutineScope.launch {
                               enterParams(viewModel=viewModel, text, navController=navController)
                           }
                       }) {
                           Icon(imageVector =Icons.Filled.ArrowForward ,
                               contentDescription = stringResource(id = R.string.forward_arrow)
                           )
                       }
        },
        label={ Text(text = stringResource(id = R.string.location))},
        placeholder = { Text(text = stringResource(id = R.string.desire_location))},
        keyboardOptions = KeyboardOptions.Default.copy(
            capitalization = KeyboardCapitalization.Words,
            autoCorrect = false,
            keyboardType = KeyboardType.Text
        )
    )

}

suspend fun enterParams(
    viewModel: WeatherModel,
    cityName: String,
    navController: NavController
){
    viewModel.getCityInfo(cityName)
    navController.navigate(Screen.MainScreen.route)
}



/*@Preview
@Composable
fun CityTextFieldPreview(){
    CityTextField()
}*/

