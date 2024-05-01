package com.example.lemonadeapp

import android.app.Application
import com.example.lemonadeapp.repository.Repository

class LemonadeApp : Application() {

    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(Repository.Base())
    }
}