package com.example.happybirthday.unit1

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}