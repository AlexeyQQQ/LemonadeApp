package com.example.lemonadeapp.main.di

import com.example.lemonadeapp.core.di.Core
import com.example.lemonadeapp.core.di.Module
import com.example.lemonadeapp.core.di.ProvideAbstract
import com.example.lemonadeapp.core.di.ProvideViewModel
import com.example.lemonadeapp.main.data.MainRepository
import com.example.lemonadeapp.main.presentation.MainViewModel

class MainModule(private val core: Core) : Module<MainViewModel> {

    override fun viewModel(): MainViewModel {
        return MainViewModel(MainRepository.Base(core.lastScreen))
    }
}

class ProvideMainViewModel(
    core: Core,
    provideOther: ProvideViewModel
) : ProvideAbstract(core, provideOther, MainViewModel::class.java) {

    override fun module() = MainModule(core)
}
