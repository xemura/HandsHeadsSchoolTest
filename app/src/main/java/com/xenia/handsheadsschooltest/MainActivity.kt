package com.xenia.handsheadsschooltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xenia.handsheadsschooltest.classes.Monster
import com.xenia.handsheadsschooltest.classes.Player
import com.xenia.handsheadsschooltest.presentation.GameScreen
import com.xenia.handsheadsschooltest.presentation.WelcomeScreen
import com.xenia.handsheadsschooltest.presentation.util.Screen
import com.xenia.handsheadsschooltest.ui.theme.HandsHeadsSchoolTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HandsHeadsSchoolTestTheme {
                val player = Player("Xenia") // create object Player
                player.health = 100 // add health, always 100

                val monster = Monster() // create object Monster
                monster.health = 100 // add health, always 100

                Surface(
                    color = Color.Black
                ) {
                    // create navController
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.WelcomeScreen.route // start screen
                    ) {
                        composable(route = Screen.WelcomeScreen.route) {
                            WelcomeScreen(
                                navController = navController,
                                player,
                                monster
                            )
                        }
                        composable(route = Screen.GameScreen.route) {
                            GameScreen(
                                navController = navController,
                                player,
                                monster
                            )
                        }
                    }

                }
            }
        }
    }
}