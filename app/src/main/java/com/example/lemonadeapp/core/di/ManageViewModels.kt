package com.example.lemonadeapp.core.di

import androidx.lifecycle.ViewModel

interface ManageViewModels : ClearViewModel, ProvideViewModel

interface ClearViewModel {

    fun clear(clazz: Class<out ViewModel>)
}