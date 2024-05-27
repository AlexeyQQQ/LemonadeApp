package com.example.lemonadeapp.load.data

import com.example.lemonadeapp.core.data.IntCache

interface CacheDataSource {

    fun save(data: Int)

    fun read(): Int

    class Base(
        private val stringCache: IntCache,
    ) : CacheDataSource {

        override fun save(data: Int) {
            stringCache.save(data)
        }

        override fun read(): Int {
            return stringCache.read()
        }
    }
}
