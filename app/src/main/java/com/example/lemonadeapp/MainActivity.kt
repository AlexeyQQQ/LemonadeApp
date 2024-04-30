package com.example.lemonadeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lemonadeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var uiState: UiState
        val viewModel = (application as LemonadeApp).viewModel

        binding.actionButton.setOnClickListener {
            uiState = binding.actionButton.handleAction(viewModel)
            uiState.update(binding)
        }

        binding.pictureImageButton.setOnClickListener {
            uiState = viewModel.clickOnPicture()
            uiState.update(binding)
        }

        if (savedInstanceState == null) {
            uiState = viewModel.init()
            uiState.update(binding)
        }
    }
}