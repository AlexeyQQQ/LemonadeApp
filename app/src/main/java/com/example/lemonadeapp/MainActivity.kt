package com.example.lemonadeapp

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lemonadeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var uiState: UiState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = (application as LemonadeApp).viewModel

        binding.actionButton.setOnClickListener {
            uiState = uiState.handleAction(viewModel)
            uiState.update(binding)
        }

        binding.pictureImageButton.setOnClickListener {
            uiState = viewModel.clickOnPicture()
            uiState.update(binding)
        }

        uiState = if (savedInstanceState == null) {
            viewModel.init()
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                savedInstanceState.getSerializable(STATE_KEY, UiState::class.java) as UiState
            } else {
                savedInstanceState.getSerializable(STATE_KEY) as UiState
            }
        }
        uiState.update(binding)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(STATE_KEY, uiState)
    }

    companion object {
        private const val STATE_KEY = "uiStateKey"
    }
}