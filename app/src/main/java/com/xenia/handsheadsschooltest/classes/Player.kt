package com.xenia.handsheadsschooltest.classes

import com.xenia.handsheadsschooltest.attack_algorithm.attackSuccess

class Player(
    val name : String
) : Entity() {
    private var numberOfHeal: Int = 4

    fun getNumberOfHeal() : Int {
        return numberOfHeal
    }

    fun playerAttack(
        attacker: Player,
        protector: Monster) : Boolean
    {
        if (attackSuccess(attacker.attack, protector.protection)
            && protector.health in 1..100)
        {
            protector.health -= attacker.damage.random()
        }
        return protector.health > 0
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
        }
    }
}