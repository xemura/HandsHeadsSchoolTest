package com.xenia.handsheadsschooltest.presentation.util

sealed class Screen(val route: String) {
    object WelcomeScreen: Screen("welcome_screen")
    object GameScreen: Screen("game_screen")
}