package com.xenia.handsheadsschooltest.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xenia.handsheadsschooltest.R
import com.xenia.handsheadsschooltest.classes.Monster
import com.xenia.handsheadsschooltest.classes.Player
import java.util.Timer
import java.util.TimerTask

@Composable
fun MainScreen(player: Player, monster: Monster) {
    var healthPlayer by remember { mutableStateOf(1.0f) }
    var healthMonster by remember { mutableStateOf(1.0f) }
    var gameOver by remember { mutableStateOf(false) }
    var textPlayer by remember { mutableStateOf("") }
    var textMonster by remember { mutableStateOf("") }

    val timer = Timer()
    val task = object : TimerTask() {
        override fun run() {
            if (!gameOver) {
                if (monster.monsterAttack(monster, player)) {
                    healthPlayer = ((player.health).toDouble()/100).toFloat()
                } else {
                    healthPlayer = 0.0f
                    textMonster = "Win!"
                    gameOver = true
                }
            }
        }
    }
    timer.schedule(task, 1000, 3000)


    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LinearProgressIndicator(
                progress = healthPlayer,
                modifier = Modifier
                    .padding(20.dp)
                    .height(15.dp)
                    .size(100.dp),
                color = Color.Black,
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Image(
                painter = painterResource(id = R.drawable.player),
                contentDescription = "player",
                Modifier.size(100.dp)
            )
            OutlinedButton(
                modifier = Modifier.padding(20.dp),
                onClick = {
                    if (!gameOver) {
                        if (player.playerAttack(player, monster)) {
                            healthMonster = ((monster.health).toDouble() / 100).toFloat()
                        } else {
                            healthMonster = 0.0f
                            textPlayer = "Win!"
                            gameOver = true
                        }
                    }
                }
            ) {
                Text("Attack", fontSize = 22.sp)
            }
            Text("Доступных: ${player.getNumberOfHeal()}", fontSize = 16.sp)
            OutlinedButton(
                modifier = Modifier.padding(20.dp),
                onClick = {
                    if (!gameOver) {
                        player.healingPlayer(player)
                        healthPlayer = ((player.health).toDouble()/100).toFloat()
                    }
                }
            ) {
                Text("Heal", fontSize = 22.sp)
            }

            Text(textPlayer, fontSize = 22.sp)
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LinearProgressIndicator(
                progress = healthMonster,
                modifier = Modifier
                    .padding(20.dp)
                    .height(15.dp)
                    .size(100.dp),
                color = Color.Black,
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Image(
                painter = painterResource(id = R.drawable.monster),
                contentDescription = "monster",
                Modifier.size(100.dp)
            )

            Text(textMonster, fontSize = 22.sp)
        }
    }
}
