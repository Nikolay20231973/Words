package com.example.words.navigation

sealed class Screens (val route: String) {
 //   object Game:Screens("game_screen")
    object Two: Screens("two_screen")
    object One: Screens("one_screen")
}