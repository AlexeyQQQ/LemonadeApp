package com.example.lemonadeapp.presentation.finish_game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lemonadeapp.databinding.FragmentFinishGameBinding
import com.example.lemonadeapp.presentation.main.Navigation
import com.example.lemonadeapp.presentation.new_game.NewGameFragment

class FinishGameFragment : Fragment() {

    private var _binding: FragmentFinishGameBinding? = null
    private val binding: FragmentFinishGameBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFinishGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionButton.setOnClickListener {
            (requireActivity() as Navigation).navigate(NewGameFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}