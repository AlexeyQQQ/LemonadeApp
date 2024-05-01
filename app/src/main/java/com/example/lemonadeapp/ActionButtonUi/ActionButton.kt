package com.example.lemonadeapp.ActionButtonUi

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.example.lemonadeapp.Actions
import com.example.lemonadeapp.UiState

class ActionButton : AppCompatButton {

    fun handleAction(viewModel: Actions): UiState = actionButtonUiState.handleAction(viewModel)

    private lateinit var actionButtonUiState: ActionButtonUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    fun updateUiState(outer: ActionButtonUiState) {
        actionButtonUiState = outer
        actionButtonUiState.update(this)
    }

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