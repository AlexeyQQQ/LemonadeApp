package com.example.lemonadeapp.data

import android.content.SharedPreferences

interface StringCache {

    fun save(value: String)

    fun read(): String

    class Base(
        private val permanentStorage: StringPermanentStorage,
        private val key: String,
        private val default: String,
    ) : StringCache {

        override fun save(value: String) {
            permanentStorage.save(key, value)
        }

        override fun read(): String {
            return permanentStorage.read(key, default)
        }
    }
}


interface StringPermanentStorage {

    fun save(key: String, value: String)

    fun read(key: String, default: String): String

    class Base(
        private val sharedPreferences: SharedPreferences
    ) : StringPermanentStorage {

        override fun save(key: String, value: String) {
            sharedPreferences.edit().putString(key, value).apply()
        }

        override fun read(key: String, default: String): String {
            return sharedPreferences.getString(key, default) ?: default
        }
    }
}