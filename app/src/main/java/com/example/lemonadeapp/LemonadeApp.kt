package com.example.lemonadeapp

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.data.IntCache
import com.example.lemonadeapp.data.IntPermanentStorage
import com.example.lemonadeapp.data.SqueezingRepository
import com.example.lemonadeapp.data.StringCache
import com.example.lemonadeapp.data.StringPermanentStorage
import com.example.lemonadeapp.presentation.finish_game.FinishGameRepository
import com.example.lemonadeapp.presentation.finish_game.FinishGameViewModel
import com.example.lemonadeapp.presentation.lemonade_ready.LemonadeReadyRepository
import com.example.lemonadeapp.presentation.lemonade_ready.LemonadeReadyViewModel
import com.example.lemonadeapp.presentation.main.MainRepository
import com.example.lemonadeapp.presentation.main.MainViewModel
import com.example.lemonadeapp.presentation.new_game.NewGameRepository
import com.example.lemonadeapp.presentation.new_game.NewGameScreen
import com.example.lemonadeapp.presentation.new_game.NewGameViewModel
import com.example.lemonadeapp.presentation.squeezing.SqueezingViewModel

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

class Core(context: Context) {

    val counterOfClicks: IntCache
    val lastScreen: StringCache

    init {
        val sharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

        val intPermanentStorage = IntPermanentStorage.Base(sharedPreferences)
        val stringPermanentStorage = StringPermanentStorage.Base(sharedPreferences)

        counterOfClicks = IntCache.Base(intPermanentStorage, COUNTER_KEY, 0)
        lastScreen =
            StringCache.Base(
                stringPermanentStorage,
                LAST_SCREEN_KEY,
                NewGameScreen::class.java.canonicalName!!
            )
    }

    companion object {
        private const val COUNTER_KEY = "counter_key"
        private const val LAST_SCREEN_KEY = "last_screen_key"
    }
}

interface ClearViewModel {

    fun clear(clazz: Class<out ViewModel>)
}

interface ManageViewModels : ClearViewModel, ProvideViewModel

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

    @Suppress("UNCHECKED_CAST")
    class Make(private val core: Core) : ProvideViewModel {

        override fun <T : ViewModel> viewModel(clazz: Class<T>): T = with(core) {
            return when (clazz) {
                MainViewModel::class.java -> MainViewModel(
                    MainRepository.Base(lastScreen)
                )

                NewGameViewModel::class.java -> NewGameViewModel(
                    NewGameRepository.Base(lastScreen)
                )

                SqueezingViewModel::class.java -> SqueezingViewModel(
                    SqueezingRepository.Base(counterOfClicks, lastScreen)
                )

                LemonadeReadyViewModel::class.java -> LemonadeReadyViewModel(
                    LemonadeReadyRepository.Base(lastScreen)
                )

                FinishGameViewModel::class.java -> FinishGameViewModel(
                    FinishGameRepository.Base(lastScreen)
                )

                else -> throw IllegalStateException("unknown viewModel $clazz go and add it to ProvideViewModel.Make")
            } as T
        }
    }
}