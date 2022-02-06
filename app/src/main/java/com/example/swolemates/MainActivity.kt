package com.example.swolemates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var model: SwoleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        model = ViewModelProvider(this).get(SwoleViewModel::class.java)
        setContentView(R.layout.activity_main)
    }
}