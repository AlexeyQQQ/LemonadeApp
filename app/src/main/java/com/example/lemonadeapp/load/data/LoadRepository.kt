package com.example.lemonadeapp.load.data

import com.example.lemonadeapp.core.data.StringCache
import com.example.lemonadeapp.load.presentation.LoadScreen

interface LoadRepository {

    fun load(): LoadResult

    fun saveLastScreen()

    class Base(
        private val lastSavedScreen: StringCache,
        private val cacheDataSource: CacheDataSource,
        private val cloudDataSource: CloudDataSource,
    ) : LoadRepository {

        override fun load(): LoadResult {
            return try {
                val data: Int = cloudDataSource.data()
                cacheDataSource.save(data)
                LoadResult.Success
            } catch (e: Exception) {
                LoadResult.Error(e.message ?: "Unknown error in LoadRepository")
            }
        }

        override fun saveLastScreen() {
            LoadScreen::class.java.canonicalName?.let { lastSavedScreen.save(it) }
        }
    }

}