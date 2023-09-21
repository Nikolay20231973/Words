package com.example.words.screens.one_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.words.navigation.Screens
import com.example.words.screens.one_1.u.GameScreen

// ЭКРАН ИГРЫ И ВНИЗУ КНОПКА ПЕРЕХОДА НА ДРУГОЙ ЭКРАН
@Composable
fun OneScreen(navController: NavController){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally){

        //НИЖЕ КОД ИГРА СЛОВ
        Column (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.9f)
            .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            GameScreen()
        }
            // ВЫШЕ КОД ИГРЫ СЛОВ

            // НИЖЕ КНОПКА ПЕРЕХОДА НА ДРУГОЙ ЭКРАН С ПОДСКАЗКАМИ
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center
            )
            {
                Button(
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.run {
                        val buttonColors: ButtonColors =
                            buttonColors(Color.Black)
                        buttonColors
                    },
                    modifier = Modifier.padding(1.dp),
                    onClick = {
                        //TODO: Navigate to Details
                        navController.navigate(Screens.Two.route)
                    })

                {
                    Text(
                        text = "подсказки",
                        modifier = Modifier
                            .padding(5.dp),
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }
            }
        }
    }
