package com.example.lemonadeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lemonadeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = MainViewModel()

        binding.actionButton.setOnClickListener {
            val uiState = viewModel.handleAction()     //????????
            uiState.update(binding)
        }

        binding.pictureImageButton.setOnClickListener {
            val uiState = viewModel.clickOnPicture()
            uiState.update(binding)
        }

        val uiState = viewModel.init()
        uiState.update(binding)
    }
}