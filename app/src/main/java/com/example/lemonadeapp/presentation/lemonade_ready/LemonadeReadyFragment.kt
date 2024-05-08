package com.example.lemonadeapp.presentation.lemonade_ready

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lemonadeapp.databinding.FragmentLemonadeReadyBinding
import com.example.lemonadeapp.presentation.finish_game.FinishGameFragment
import com.example.lemonadeapp.presentation.main.Navigation

class LemonadeReadyFragment : Fragment() {

    private var _binding: FragmentLemonadeReadyBinding? = null
    private val binding: FragmentLemonadeReadyBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLemonadeReadyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionButton.setOnClickListener {
            (requireActivity() as Navigation).navigate(FinishGameFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}