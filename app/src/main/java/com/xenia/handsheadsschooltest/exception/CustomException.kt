package com.xenia.handsheadsschooltest.exception

class CustomException() : Exception() {

    fun allHealingAreUsedException() {
        throw  Exception("All healing attempts have already been used")
    }

    fun attackParamException() {
        throw  Exception("Params \"attack\" must be in the range [ 1; 30 ]")
    }

    fun defenseParamException() {
        throw  Exception("Params \"defense\" must be in the range [ 1; 30 ]")
    }

    fun attackingDeadException() {
        throw  Exception("Dead creature is trying to attack")
    }

    fun attackingWhenGameOverException() {
        throw  Exception("Creature is trying to attack when game is over")
    }

    fun fullHealthException() {
        throw  Exception("Player is completely healthy, it don't need healing")
    }
}