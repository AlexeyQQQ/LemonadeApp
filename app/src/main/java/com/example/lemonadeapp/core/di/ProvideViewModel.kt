package com.example.lemonadeapp.core.di

import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.finish_game.di.ProvideFinishGameViewModel
import com.example.lemonadeapp.lemonade_ready.di.ProvideLemonadeReadyViewModel
import com.example.lemonadeapp.load.di.ProvideLoadViewModel
import com.example.lemonadeapp.main.di.ProvideMainViewModel
import com.example.lemonadeapp.new_game.di.ProvideNewGameViewModel
import com.example.lemonadeapp.squeezing.di.ProvideSqueezingViewModel

interface ProvideViewModel {

    fun <T : ViewModel> viewModel(clazz: Class<T>): T

    @Suppress("UNCHECKED_CAST")
    class Factory(
        private val make: ProvideViewModel,
    ) : ManageViewModels {

        private val mutableMap = mutableMapOf<Class<out ViewModel>, ViewModel?>()

        override fun clear(clazz: Class<out ViewModel>) {
            mutableMap[clazz] = null
        }

        override fun <T : ViewModel> viewModel(clazz: Class<T>): T {
            return if (mutableMap[clazz] == null) {
                val viewModel = make.viewModel(clazz)
                mutableMap[clazz] = viewModel
                viewModel
            } else {
                mutableMap[clazz] as T
            }
        }
    }

    class Make(core: Core) : ProvideViewModel {

        private val chain: ProvideViewModel

        init {
            var temp: ProvideViewModel = Error()
            temp = ProvideFinishGameViewModel(core, temp)
            temp = ProvideNewGameViewModel(core, temp)
            temp = ProvideSqueezingViewModel(core, temp)
            temp = ProvideLoadViewModel(core, temp)
            temp = ProvideLemonadeReadyViewModel(core, temp)
            chain = ProvideMainViewModel(core, temp)
        }

        override fun <T : ViewModel> viewModel(clazz: Class<T>): T {
            return chain.viewModel(clazz)
        }
    }
}