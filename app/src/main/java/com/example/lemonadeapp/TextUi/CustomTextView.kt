package com.example.lemonadeapp.TextUi

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textview.MaterialTextView

class CustomTextView : MaterialTextView, UpdateTextView {

    private lateinit var textUiState: TextUiState

    override fun updateUiState(outer: TextUiState) {
        textUiState = outer
        textUiState.update(this)
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )
}

interface UpdateTextView {

    fun updateUiState(outer: TextUiState)
}