package com.example.lemonadeapp

interface Repository {

    fun increaseCounter(): CheckResult

    class Base : Repository {
        private var counterOfClicks: Int = 0

        override fun increaseCounter(): CheckResult {
            counterOfClicks++
            return if (counterOfClicks < 5) {
                CheckResult.Increment
            } else {
                counterOfClicks = 0
                CheckResult.ResetCounter
            }
        }
    }
}
