package com.xenia.handsheadsschooltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                val player = Player("Mark")
                player.health = 100

                val monster = Monster()
                monster.health = 100

                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    // create navController
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.WelcomeScreen.route
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