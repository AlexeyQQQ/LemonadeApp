package com.example.lemonadeapp.data.repository

import android.content.SharedPreferences

interface IntCache {

    fun save(value: Int)

    fun read(): Int

    class Base(
        private val permanentStorage: PermanentStorage,
        private val key: String,
        private val default: Int,
    ) : IntCache {

        override fun save(value: Int) {
            permanentStorage.save(key, value)
        }

        override fun read(): Int {
            return permanentStorage.read(key, default)
        }
    }
}


interface PermanentStorage {

    fun save(key: String, value: Int)

    fun read(key: String, default: Int): Int

    class Base(
        private val sharedPreferences: SharedPreferences
    ) : PermanentStorage {

        override fun save(key: String, value: Int) {
            sharedPreferences.edit().putInt(key, value).apply()
        }

        override fun read(key: String, default: Int): Int {
            return sharedPreferences.getInt(key, default)
        }
    }
}