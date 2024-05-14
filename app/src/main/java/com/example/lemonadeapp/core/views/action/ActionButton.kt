package com.example.lemonadeapp.core.views.action

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatButton

class ActionButton : AppCompatButton, UpdateActionButton {

    private lateinit var actionButtonUiState: ActionButtonUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun updateUiState(outer: ActionButtonUiState) {
        actionButtonUiState = outer
        actionButtonUiState.update(this)
    }

    override fun updateText(@StringRes textId: Int) {
        setText(textId)
    }

    override fun updateEnabled(enabled: Boolean) {
        isEnabled = enabled
    }

//    fun handleAction(viewModel: Actions): UiState = actionButtonUiState.handleAction(viewModel)

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = ActionButtonSavedState(it)
            state.save(actionButtonUiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as ActionButtonSavedState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }
}

interface UpdateActionButton {

    fun updateUiState(outer: ActionButtonUiState)

    fun updateText(@StringRes textId: Int)
    fun updateEnabled(enabled: Boolean)
}