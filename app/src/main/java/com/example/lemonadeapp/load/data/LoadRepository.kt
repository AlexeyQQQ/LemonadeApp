package com.example.lemonadeapp.load.data

interface LoadRepository {

    fun load(): LoadResult

    fun saveLastScreen()

}