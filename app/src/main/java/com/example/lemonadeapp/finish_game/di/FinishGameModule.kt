package com.example.lemonadeapp.finish_game.di

import com.example.lemonadeapp.core.di.Core
import com.example.lemonadeapp.core.di.Module
import com.example.lemonadeapp.core.di.ProvideAbstract
import com.example.lemonadeapp.core.di.ProvideViewModel
import com.example.lemonadeapp.finish_game.data.FinishGameRepository
import com.example.lemonadeapp.finish_game.presentation.FinishGameViewModel

class FinishGameModule(private val core: Core) : Module<FinishGameViewModel> {

    override fun viewModel(): FinishGameViewModel {
        return FinishGameViewModel(
            FinishGameRepository.Base(core.lastScreen)
        )
    }
}

class ProvideFinishGameViewModel(
    core: Core,
    provideOther: ProvideViewModel
) : ProvideAbstract(core, provideOther, FinishGameViewModel::class.java) {

    override fun module() = FinishGameModule(core)
}