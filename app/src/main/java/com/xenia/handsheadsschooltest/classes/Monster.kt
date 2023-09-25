package com.xenia.handsheadsschooltest.classes

import com.xenia.handsheadsschooltest.attack_algorithm.attackSuccess

class Monster : Entity() {
    fun monsterAttack(
        attacker: Monster,
        protector: Player) : Boolean
    {
        if (attackSuccess(attacker.attack, protector.protection)
            && protector.health in 1..100)
        {
            protector.health -= attacker.damage.random()
        }
        return protector.health > 0
    }
}