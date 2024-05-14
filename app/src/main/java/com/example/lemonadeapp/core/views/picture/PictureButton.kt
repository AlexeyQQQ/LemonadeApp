package com.example.lemonadeapp.core.views.picture

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageButton

class PictureButton : AppCompatImageButton, UpdatePictureButton {

    private lateinit var pictureUiState: PictureUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun updateUiState(outer: PictureUiState) {
        pictureUiState = outer
        pictureUiState.update(this)
    }

    override fun updateUi(clickable: Boolean, imageResource: Int) {
        isClickable = clickable
        setImageResource(imageResource)
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = PictureSavedState(it)
            state.save(pictureUiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as PictureSavedState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }
}

interface UpdatePictureButton {

    fun updateUiState(outer: PictureUiState)

    fun updateUi(clickable: Boolean, @DrawableRes imageResource: Int)
}