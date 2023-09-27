package com.xenia.handsheadsschooltest.classes

import com.xenia.handsheadsschooltest.attack_algorithm.attackSuccess
import com.xenia.handsheadsschooltest.exception.CustomException

class Player(
    val name : String
) : Entity() {
    private var numberOfHeal: Int = 4
    private var exception = CustomException()

    fun getNumberOfHeal() : Int {
        return numberOfHeal
    }

    fun playerAttack(
        attacker: Player,
        defender: Monster) : Boolean
    {
        if (attacker.health <= 0) {
            exception.attackingDeadException()
        }
        else if (attackSuccess(attacker.attack, defender.defense)
            && defender.health in 1..100)
        {
            defender.health -= attacker.damage.random()
        }
        return defender.health > 0
    }

    fun healingPlayer(player: Player) {
        if (player.health in 1..99
            && player.numberOfHeal > 0)
        {
            player.health += (((player.health).toDouble()/100)*30).toInt()
            if (player.health > 100) {
                player.health = 100
            }

            player.numberOfHeal--
        } else if (player.numberOfHeal == 0) {
            exception.allHealingAreUsedException()
        }
    }
}