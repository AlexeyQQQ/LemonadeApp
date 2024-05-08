package com.example.lemonadeapp.presentation.squeezing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lemonadeapp.LemonadeApp
import com.example.lemonadeapp.databinding.FragmentSqueezingBinding
import com.example.lemonadeapp.presentation.lemonade_ready.LemonadeReadyFragment
import com.example.lemonadeapp.presentation.main.Navigation

class SqueezingFragment : Fragment() {

    private var _binding: FragmentSqueezingBinding? = null
    private val binding: FragmentSqueezingBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSqueezingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lateinit var uiState: SqueezingUiState
        val viewModel = (requireActivity().application as LemonadeApp).viewModel

        val showUi: () -> Unit = {
            uiState.update(
                binding.pictureImageButton,
                binding.actionButton,
                binding.hintTextView
            )
        }

        binding.actionButton.setOnClickListener {
            viewModel.exit()
            (requireActivity() as Navigation).navigate(LemonadeReadyFragment())
        }

        binding.pictureImageButton.setOnClickListener {
            uiState = viewModel.clickOnPicture()
            showUi.invoke()
        }

        uiState = viewModel.init(savedInstanceState == null)
        showUi.invoke()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}