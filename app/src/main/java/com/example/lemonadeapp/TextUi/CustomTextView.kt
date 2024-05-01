package com.example.lemonadeapp.TextUi

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.StringRes
import com.google.android.material.textview.MaterialTextView

class CustomTextView : MaterialTextView, UpdateTextView {

    override fun updateText(resId: Int) {
        setText(resId)
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

    fun updateText(@StringRes resId: Int)
}