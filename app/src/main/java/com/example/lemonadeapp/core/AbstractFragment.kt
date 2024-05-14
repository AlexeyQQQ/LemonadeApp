package com.example.lemonadeapp.core

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.lemonadeapp.R

abstract class AbstractFragment(
    @DrawableRes private val imageResId: Int,
    @StringRes private val buttonTextResId: Int,
    @StringRes private val hintResId: Int,
) : Fragment(R.layout.fragment_abstract) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val image = view.findViewById<ImageButton>(R.id.pictureImageButton)
        image.setImageResource(imageResId)

        val button = view.findViewById<Button>(R.id.actionButton)
        button.setText(buttonTextResId)

        button.setOnClickListener {
            navigation(requireActivity())
        }

        val hint = view.findViewById<TextView>(R.id.hintTextView)
        hint.setText(hintResId)

        saveLastScreen(requireActivity())
    }

    protected abstract fun nextFragment(): Fragment

    protected abstract fun navigation(activity: FragmentActivity)

    protected abstract fun saveLastScreen(activity: FragmentActivity)
}