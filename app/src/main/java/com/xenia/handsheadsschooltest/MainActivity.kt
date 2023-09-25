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
import com.xenia.handsheadsschooltest.classes.Monster
import com.xenia.handsheadsschooltest.classes.Player
import com.xenia.handsheadsschooltest.presentation.MainScreen
import com.xenia.handsheadsschooltest.ui.theme.HandsHeadsSchoolTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HandsHeadsSchoolTestTheme {

                val player = Player("Mark")
                player.health = 100
                player.attack = 20
                player.protection = 10

                val monster = Monster()
                monster.health = 100
                monster.attack = 10
                monster.protection = 10

                MainScreen(player, monster)
            }
        }
    }
}