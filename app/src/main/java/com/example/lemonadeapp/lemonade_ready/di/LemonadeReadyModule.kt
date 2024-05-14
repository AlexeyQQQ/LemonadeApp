package com.example.lemonadeapp.lemonade_ready.di

import com.example.lemonadeapp.core.di.Core
import com.example.lemonadeapp.core.di.Module
import com.example.lemonadeapp.core.di.ProvideAbstract
import com.example.lemonadeapp.core.di.ProvideViewModel
import com.example.lemonadeapp.lemonade_ready.data.LemonadeReadyRepository
import com.example.lemonadeapp.lemonade_ready.presentation.LemonadeReadyViewModel

class LemonadeReadyModule(private val core: Core) : Module<LemonadeReadyViewModel> {

    override fun viewModel(): LemonadeReadyViewModel {
        return LemonadeReadyViewModel(
            LemonadeReadyRepository.Base(core.lastScreen)
        )
    }
}

class ProvideLemonadeReadyViewModel(
    core: Core,
    provideOther: ProvideViewModel
) : ProvideAbstract(core, provideOther, LemonadeReadyViewModel::class.java) {

    override fun module() = LemonadeReadyModule(core)
}