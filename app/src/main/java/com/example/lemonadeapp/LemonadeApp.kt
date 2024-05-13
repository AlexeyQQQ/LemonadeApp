package com.example.lemonadeapp

import android.app.Application
import android.content.Context
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

class LemonadeApp : Application() {

    lateinit var mainViewModel: MainViewModel
    lateinit var newGameViewModel: NewGameViewModel
    lateinit var squeezingViewModel: SqueezingViewModel
    lateinit var lemonadeReadyViewModel: LemonadeReadyViewModel
    lateinit var finishGameViewModel: FinishGameViewModel

    override fun onCreate() {
        super.onCreate()

        val sharedPreferences =
            getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)

        val intPermanentStorage = IntPermanentStorage.Base(sharedPreferences)
        val stringPermanentStorage = StringPermanentStorage.Base(sharedPreferences)

        val counterOfClicks = IntCache.Base(intPermanentStorage, COUNTER_KEY, 0)
        val lastScreen =
            StringCache.Base(
                stringPermanentStorage,
                LAST_SCREEN_KEY,
                NewGameScreen::class.java.canonicalName!!
            )

        mainViewModel = MainViewModel(
            MainRepository.Base(lastScreen)
        )
        newGameViewModel = NewGameViewModel(
            NewGameRepository.Base(lastScreen)
        )
        squeezingViewModel = SqueezingViewModel(
            SqueezingRepository.Base(counterOfClicks, lastScreen)
        )
        lemonadeReadyViewModel = LemonadeReadyViewModel(
            LemonadeReadyRepository.Base(lastScreen)
        )
        finishGameViewModel = FinishGameViewModel(
            FinishGameRepository.Base(lastScreen)
        )
    }

    companion object {
        private const val COUNTER_KEY = "counter_key"
        private const val LAST_SCREEN_KEY = "last_screen_key"
    }
}