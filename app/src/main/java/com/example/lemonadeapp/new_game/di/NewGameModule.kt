package com.example.lemonadeapp.new_game.di

import com.example.lemonadeapp.core.di.Core
import com.example.lemonadeapp.core.di.Module
import com.example.lemonadeapp.core.di.ProvideAbstract
import com.example.lemonadeapp.core.di.ProvideViewModel
import com.example.lemonadeapp.new_game.data.NewGameRepository
import com.example.lemonadeapp.new_game.presentation.NewGameViewModel

class NewGameModule(private val core: Core) : Module<NewGameViewModel> {

    override fun viewModel(): NewGameViewModel {
        return NewGameViewModel(
            NewGameRepository.Base(core.lastScreen)
        )
    }
}

class ProvideNewGameViewModel(
    core: Core,
    provideOther: ProvideViewModel
) : ProvideAbstract(core, provideOther, NewGameViewModel::class.java) {

    override fun module() = NewGameModule(core)
}