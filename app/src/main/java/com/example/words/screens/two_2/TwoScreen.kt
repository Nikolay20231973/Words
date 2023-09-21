package com.example.words.screens.two_2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.words.R
import com.example.words.navigation.Screens

@Composable
fun TwoScreen(navController: NavController) {
    //val mediumPadding = dimensionResource(R.dimen.padding_medium)
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                //.padding(mediumPadding)
                .fillMaxHeight(),
            // .background(Color.Green),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.words),

                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        // внизу код кнопка
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Button (
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.run {
                    val buttonColors: ButtonColors =
                        buttonColors(Color.Black)
                    buttonColors
                }
                ,
                modifier = Modifier.padding(5.dp),
                onClick = {
                    //TODO: Navigate to Details
                    navController.navigate(Screens.One.route)
                }
            ) {
                Text(
                    "в игру",
                    Modifier.padding(5.dp),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }

        //верху код кнопка
    }
}