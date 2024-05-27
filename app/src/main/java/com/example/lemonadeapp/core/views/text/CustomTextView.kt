package com.example.lemonadeapp.core.views.text

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.StringRes
import com.google.android.material.textview.MaterialTextView

class CustomTextView : MaterialTextView, UpdateTextView {

    override fun updateText(resId: Int) {
        setText(resId)
    }

    override fun updateText(resId: Int, requiredClicks: Int) {
        val text = context.getString(resId, requiredClicks)
        setText(text)
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
    fun updateText(@StringRes resId: Int, requiredClicks: Int)
}