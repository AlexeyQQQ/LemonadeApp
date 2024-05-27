package com.example.lemonadeapp.squeezing.di

import com.example.lemonadeapp.core.di.Core
import com.example.lemonadeapp.core.di.Module
import com.example.lemonadeapp.core.di.ProvideAbstract
import com.example.lemonadeapp.core.di.ProvideViewModel
import com.example.lemonadeapp.load.data.CacheDataSource
import com.example.lemonadeapp.squeezing.data.SqueezingRepository
import com.example.lemonadeapp.squeezing.presentation.SqueezingViewModel

class SqueezingModule(private val core: Core) : Module<SqueezingViewModel> {

    override fun viewModel(): SqueezingViewModel {
        val cacheDataSource = CacheDataSource.Base(core.requiredClicks)
        return SqueezingViewModel(
            SqueezingRepository.Base(core.counterOfClicks, core.lastScreen, cacheDataSource)
        )
    }
}

class ProvideSqueezingViewModel(
    core: Core,
    provideOther: ProvideViewModel
) : ProvideAbstract(core, provideOther, SqueezingViewModel::class.java) {

    override fun module() = SqueezingModule(core)
}
