package com.xenia.handsheadsschooltest.attack_algorithm

fun attackSuccess(attack: Int, protection: Int) : Boolean{
    val attackModifier: Int = getAttackModifier(attack, protection)

    for (i in 1..attackModifier) {
        val digit : Int = (1..6).random() // get random digit from dice
        if (digit == 5 || digit == 6) return true
    }
    return false
}

fun getAttackModifier(attack: Int, protection: Int): Int {
    if (attack < protection) return 0 // attack is blocked
    return attack - protection + 1
}
