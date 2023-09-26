package com.xenia.handsheadsschooltest.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.xenia.handsheadsschooltest.classes.Monster
import com.xenia.handsheadsschooltest.classes.Player
import com.xenia.handsheadsschooltest.presentation.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    navController: NavController,
    player: Player,
    monster: Monster
) {
    val playerAttack = remember{ mutableStateOf("") }
    val playerProtection = remember{ mutableStateOf("") }

    val monsterAttack = remember{ mutableStateOf("") }
    val monsterProtection = remember{ mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Player")

        Text(playerAttack.value, fontSize = 28.sp)

        TextField(
            value = playerAttack.value,
            textStyle = TextStyle(fontSize=25.sp),
            onValueChange = {newText -> playerAttack.value = newText}
        )

        Text(playerProtection.value, fontSize = 28.sp)

        TextField(
            value = playerProtection.value,
            textStyle = TextStyle(fontSize=25.sp),
            onValueChange = {newText -> playerProtection.value = newText}
        )

        Text(text = "Monster")

        Text(monsterAttack.value, fontSize = 28.sp)

        TextField(
            value = monsterAttack.value,
            textStyle = TextStyle(fontSize=25.sp),
            onValueChange = {newText -> monsterAttack.value = newText}
        )

        Text(monsterProtection.value, fontSize = 28.sp)

        TextField(
            value = monsterProtection.value,
            textStyle = TextStyle(fontSize=25.sp),
            onValueChange = {newText -> monsterProtection.value = newText}
        )

        OutlinedButton(
            modifier = Modifier.padding(20.dp),
            onClick = {
                // proverka
                player.attack = playerAttack.value.toInt()
                player.protection = playerProtection.value.toInt()

                monster.attack = monsterAttack.value.toInt()
                monster.protection = monsterProtection.value.toInt()

                navController.navigate(Screen.GameScreen.route)
            }
        ) {
            Text("Play", fontSize = 22.sp)
        }
    }
}