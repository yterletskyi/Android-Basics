package com.example.happybirthday.unit4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthday.R

/**
 * MainActivity sets the content view activity_main, a fragment container that contains
 * overviewFragment.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
    }
}