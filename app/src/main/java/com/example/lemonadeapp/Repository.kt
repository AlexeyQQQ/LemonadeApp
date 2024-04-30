package com.example.lemonadeapp

interface Repository {

    fun increment()

    fun isMax(): Boolean

    fun reset()

    class Base : Repository {
        private var counterOfClicks: Int = 0

        override fun increment() {
            counterOfClicks++
        }

        override fun isMax(): Boolean {
            return counterOfClicks == 5
        }

        override fun reset() {
            counterOfClicks = 0
        }
    }
}
