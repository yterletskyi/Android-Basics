package com.example.happybirthday.unit2


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthday.R
import com.example.happybirthday.databinding.ActivityMain5Binding
import java.text.NumberFormat

class UnitTwoActivity : AppCompatActivity() {

    lateinit var binding: ActivityMain5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateTips.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val textValue = binding.costOfService.text.toString()
        val cost = textValue.toDoubleOrNull()
        val tipsPercentage = when (binding.tipsOptions.checkedRadioButtonId) {
            R.id.twenty_percent_option -> 0.20
            R.id.eighteen_percent_option -> 0.18
            R.id.fifteen_percent_option -> 0.15
            else -> throw IllegalArgumentException("unsupported id : ${binding.tipsOptions.checkedRadioButtonId}")
        }
        if (cost == null) {
            binding.tipsResult.text = ""
            return
        }
        var tips = cost * tipsPercentage
        if (binding.roundUpSwitch.isChecked) {
            tips = kotlin.math.ceil(tips)
        }
        val formattedTips = NumberFormat.getCurrencyInstance().format(tips)
        binding.tipsResult.text = getString(R.string.tips_result, formattedTips)
    }
}

