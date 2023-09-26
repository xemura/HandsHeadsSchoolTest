package com.xenia.handsheadsschooltest.classes

import com.xenia.handsheadsschooltest.attack_algorithm.attackSuccess

class Monster : Entity() {
    fun monsterAttack(
        attacker: Monster,
        defender: Player) : Boolean
    {
        if (attackSuccess(attacker.attack, defender.defense)
            && defender.health in 1..100)
        {
            defender.health -= attacker.damage.random()
        }
        return defender.health > 0
    }
}