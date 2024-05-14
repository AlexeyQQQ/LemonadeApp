package com.example.lemonadeapp.core.views.picture


import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View


class PictureSavedState : View.BaseSavedState {

    private lateinit var state: PictureUiState

    constructor(superState: Parcelable) : super(superState)

    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            parcelIn.readSerializable(
                PictureUiState::class.java.classLoader,
                PictureUiState::class.java
            ) as PictureUiState
        } else {
            parcelIn.readSerializable() as PictureUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore(): PictureUiState = state

    fun save(uiState: PictureUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<PictureSavedState> {
        override fun createFromParcel(parcel: Parcel): PictureSavedState =
            PictureSavedState(parcel)

        override fun newArray(size: Int): Array<PictureSavedState?> =
            arrayOfNulls(size)
    }
}
