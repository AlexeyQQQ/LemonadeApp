package com.example.lemonadeapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lemonadeapp.LemonadeApp
import com.example.lemonadeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var uiState: UiState
        val viewModel = (application as LemonadeApp).viewModel

        val showUi: () -> Unit = {
            uiState.update(
                binding.pictureImageButton,
                binding.actionButton,
                binding.hintTextView
            )
        }

        binding.actionButton.setOnClickListener {
            uiState = binding.actionButton.handleAction(viewModel)
            showUi.invoke()
        }

        binding.pictureImageButton.setOnClickListener {
            uiState = viewModel.clickOnPicture()
            showUi.invoke()
        }

        uiState = viewModel.init(savedInstanceState == null)
        showUi.invoke()
    }
}