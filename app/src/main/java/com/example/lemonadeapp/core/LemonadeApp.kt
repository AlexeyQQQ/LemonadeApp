package com.example.lemonadeapp.core

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.core.di.Core
import com.example.lemonadeapp.core.di.ManageViewModels
import com.example.lemonadeapp.core.di.ProvideViewModel

class LemonadeApp : Application(), ManageViewModels {

    private lateinit var factory: ManageViewModels

    override fun onCreate() {
        super.onCreate()
        factory = ProvideViewModel.Factory(ProvideViewModel.Make(Core(this)))
    }

    override fun clear(clazz: Class<out ViewModel>) {
        factory.clear(clazz)
    }

    override fun <T : ViewModel> viewModel(clazz: Class<T>): T {
        return factory.viewModel(clazz)
    }
}