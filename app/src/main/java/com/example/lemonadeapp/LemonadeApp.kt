package com.example.lemonadeapp

import android.app.Application
import android.content.Context
import com.example.lemonadeapp.data.repository.IntCache
import com.example.lemonadeapp.data.repository.PermanentStorage
import com.example.lemonadeapp.data.repository.Repository
import com.example.lemonadeapp.presentation.MainViewModel

class LemonadeApp : Application() {

    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()

        val permanentStorage = PermanentStorage.Base(
            getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        )

        viewModel = MainViewModel(
            Repository.Base(
                IntCache.Base(
                    permanentStorage,
                    "key",
                    0
                )
            )
        )
    }
}