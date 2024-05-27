package com.example.lemonadeapp.load.di

import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.core.di.Core
import com.example.lemonadeapp.core.di.Module
import com.example.lemonadeapp.core.di.ProvideAbstract
import com.example.lemonadeapp.core.di.ProvideViewModel
import com.example.lemonadeapp.load.data.CacheDataSource
import com.example.lemonadeapp.load.data.CloudDataSource
import com.example.lemonadeapp.load.data.LoadRepository
import com.example.lemonadeapp.load.data.MockService
import com.example.lemonadeapp.load.data.NumberService
import com.example.lemonadeapp.load.presentation.LoadViewModel
import com.example.lemonadeapp.load.presentation.RunAsync
import com.example.lemonadeapp.load.presentation.UiObservable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoadModule(private val core: Core) : Module<LoadViewModel> {

    override fun viewModel(): LoadViewModel {
        val cacheDataSource = CacheDataSource.Base(core.requiredClicks)

        val cloudDataSource = CloudDataSource.Base(
            if (core.runUiTest)
                MockService(core.mockCurrentIndex)
            else
                Retrofit.Builder().baseUrl("https://www.randomnumberapi.com/api/v1.0/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(
                        OkHttpClient.Builder()
                            .retryOnConnectionFailure(true)
                            .addInterceptor(HttpLoggingInterceptor().apply {
                                setLevel(HttpLoggingInterceptor.Level.BODY)
                            })
                            .build()
                    )
                    .build()
                    .create(NumberService::class.java)
        )

        return LoadViewModel(
            UiObservable.Base(),
            LoadRepository.Base(core.lastScreen, cacheDataSource, cloudDataSource),
            RunAsync.Base(),
        )
    }
}

class ProvideLoadViewModel(
    core: Core,
    provideOther: ProvideViewModel
) : ProvideAbstract(core, provideOther, LoadViewModel::class.java) {

    override fun module(): Module<out ViewModel> = LoadModule(core)
}