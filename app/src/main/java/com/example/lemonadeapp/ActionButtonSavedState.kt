package com.example.lemonadeapp

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View

class ActionButtonSavedState : View.BaseSavedState {

    private lateinit var state: ActionButtonUiState

    constructor(superState: Parcelable) : super(superState)

    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            parcelIn.readSerializable(
                ActionButtonUiState::class.java.classLoader,
                ActionButtonUiState::class.java
            ) as ActionButtonUiState
        } else {
            parcelIn.readSerializable() as ActionButtonUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore(): ActionButtonUiState = state

    fun save(uiState: ActionButtonUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<ActionButtonSavedState> {
        override fun createFromParcel(parcel: Parcel): ActionButtonSavedState =
            ActionButtonSavedState(parcel)

        override fun newArray(size: Int): Array<ActionButtonSavedState?> =
            arrayOfNulls(size)
    }
}