package com.example.lemonadeapp

import android.app.Application

class LemonadeApp : Application() {

    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(Repository.Base())
    }
}