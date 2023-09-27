package com.xenia.handsheadsschooltest.classes

import com.xenia.handsheadsschooltest.attack_algorithm.attackSuccess
import com.xenia.handsheadsschooltest.exception.CustomException

class Monster : Entity() {
    private var exception = CustomException()

    fun monsterAttack(
        attacker: Monster,
        defender: Player) : Boolean
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
}