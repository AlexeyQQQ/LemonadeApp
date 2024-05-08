package com.example.lemonadeapp.presentation.new_game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lemonadeapp.databinding.FragmentNewGameBinding
import com.example.lemonadeapp.presentation.main.Navigation
import com.example.lemonadeapp.presentation.squeezing.SqueezingFragment

class NewGameFragment : Fragment() {

    private var _binding: FragmentNewGameBinding? = null
    private val binding: FragmentNewGameBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionButton.setOnClickListener {
            (requireActivity() as Navigation).navigate(SqueezingFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}