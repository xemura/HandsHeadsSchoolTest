package com.xenia.handsheadsschooltest.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.xenia.handsheadsschooltest.classes.Monster
import com.xenia.handsheadsschooltest.classes.Player
import com.xenia.handsheadsschooltest.exception.CustomException
import com.xenia.handsheadsschooltest.presentation.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    navController: NavController,
    player: Player,
    monster: Monster
) {
    val playerAttack = remember{ mutableStateOf("") }
    val playerDefense = remember{ mutableStateOf("") }

    val monsterAttack = remember{ mutableStateOf("") }
    val monsterDefense = remember{ mutableStateOf("") }

    val exception = CustomException()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Player", color = Color.White, fontSize = 22.sp)

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = playerAttack.value,
            textStyle = TextStyle(fontSize=22.sp),
            placeholder = { Text(text = "player attack", fontSize=22.sp, color = Color.LightGray) },
            maxLines = 1,
            onValueChange = {newText -> playerAttack.value = newText},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = playerDefense.value,
            textStyle = TextStyle(fontSize=22.sp),
            placeholder = { Text(text = "player defense", fontSize=22.sp, color = Color.LightGray) },
            maxLines = 1,
            onValueChange = {newText -> playerDefense.value = newText},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Monster", color = Color.White, fontSize = 22.sp)

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = monsterAttack.value,
            textStyle = TextStyle(fontSize=22.sp),
            placeholder = { Text(text = "monster attack", fontSize=22.sp, color = Color.LightGray) },
            maxLines = 1,
            onValueChange = {newText -> monsterAttack.value = newText},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = monsterDefense.value,
            textStyle = TextStyle(fontSize=22.sp),
            placeholder = { Text(text = "monster defense", fontSize=22.sp, color = Color.LightGray) },
            maxLines = 1,
            onValueChange = {newText -> monsterDefense.value = newText},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(28.dp))

        OutlinedButton(
            shape = RoundedCornerShape(20.dp),
            onClick = {

                if (playerAttack.value.toInt() in 1..30)
                    player.attack = playerAttack.value.toInt()
                else exception.attackParamException()

                if (playerDefense.value.toInt() in 1..30)
                    player.defense = playerDefense.value.toInt()
                else exception.defenseParamException()

                if (monsterAttack.value.toInt() in 1..30)
                    monster.attack = monsterAttack.value.toInt()
                else exception.attackParamException()

                if (monsterDefense.value.toInt() in 1..30)
                    monster.defense = monsterDefense.value.toInt()
                else exception.defenseParamException()

                navController.navigate(Screen.GameScreen.route)
            }
        ) {
            Text(
                "Play",
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}
