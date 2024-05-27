package com.example.lemonadeapp.load.presentation

interface UpdateUi {

    fun updateUiState(uiState: LoadUiState)
}

interface UpdateObserver {

    fun updateObserver(observer: (LoadUiState) -> Unit)

    fun clearObserver()
}

interface UiObservable : UpdateUi, UpdateObserver