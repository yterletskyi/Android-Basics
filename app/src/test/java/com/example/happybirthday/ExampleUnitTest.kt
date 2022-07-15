package com.example.happybirthday

import com.example.happybirthday.unit1.Dice
import junit.framework.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun generate_numbers() {
        val dice = Dice(6)
        val numberResult = dice.roll()
        assertTrue("Number between 1 and 6", numberResult in 1..6)
    }
}