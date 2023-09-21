package com.example.words.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.words.screens.one_1.OneScreen
import com.example.words.screens.one_1.u.GameScreen
import com.example.words.screens.two_2.TwoScreen



// навигационный график
@Composable
fun NavGraph(navController: NavHostController ){
    NavHost(
        navController = navController,
        startDestination = Screens.One.route)
    {
        composable(route = Screens.Game.route){
            GameScreen(navController)
       }

        composable(route = Screens.Two.route){
            TwoScreen(navController)
        }

        composable(route = Screens.One.route){
            OneScreen(navController)
        }

    }
}

