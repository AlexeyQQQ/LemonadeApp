package com.example.lemonadeapp.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.lemonadeapp.R
import com.example.lemonadeapp.presentation.main.Navigation

abstract class AbstractFragment(
    @DrawableRes private val imageResId: Int,
    @StringRes private val buttonTextResId: Int,
    @StringRes private val hintTextResId: Int
) : Fragment(R.layout.fragment_abstract) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image = view.findViewById<ImageButton>(R.id.pictureImageButton)
        image.setImageResource(imageResId)

        val button = view.findViewById<Button>(R.id.actionButton)
        button.setText(buttonTextResId)
        button.setOnClickListener {
            (requireActivity() as Navigation).navigate(nextFragment())
        }

        val hint = view.findViewById<TextView>(R.id.hintTextView)
        hint.setText(hintTextResId)
    }

    protected abstract fun nextFragment(): Fragment
}