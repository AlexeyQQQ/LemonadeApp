package com.example.lemonadeapp.repository

interface Repository {

    fun increment()

    fun isMax(): Boolean

    fun reset()

    class Base(
        private val counterOfClicks: IntCache,
    ) : Repository {

        override fun increment() {
            val current = counterOfClicks.read()
            val new = current + 1
            counterOfClicks.save(new)
        }

        override fun isMax(): Boolean {
            return counterOfClicks.read() == 5
        }

        override fun reset() {
            counterOfClicks.save(0)
        }
    }
}
