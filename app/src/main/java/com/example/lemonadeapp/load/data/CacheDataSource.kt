package com.example.lemonadeapp.load.data

import com.example.lemonadeapp.core.data.IntCache

interface CacheDataSource {

    fun save(data: Int)

    fun read(): Int

    class Base(
        private val intCache: IntCache,
    ) : CacheDataSource {

        override fun save(data: Int) {
            intCache.save(data)
        }

        override fun read(): Int {
            return intCache.read()
        }
    }
}
