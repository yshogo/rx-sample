package com.example.rx_sample.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.rx_sample.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = MainViewModel()
        viewModel.getHackerNews()
    }
}
