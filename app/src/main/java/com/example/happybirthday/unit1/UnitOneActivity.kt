package com.example.happybirthday.unit1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.happybirthday.R

class UnitOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

    }

    /**
     * Method create Dice object and add random number to the screen.
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val imageView: ImageView = findViewById(R.id.imageView2)
        val textView: TextView = findViewById(R.id.textView1)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        imageView.setImageResource(drawableResource)
        textView.setText(R.string.signature_text + diceRoll)
        imageView.contentDescription = diceRoll.toString()
    }
}