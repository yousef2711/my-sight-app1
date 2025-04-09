package com.yousef.mysight00.utils

import android.content.Context
import android.graphics.Color
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.yousef.mysight00.R

fun Context.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    try {
        val toast = Toast.makeText(this, message, length)

        // Try to customize the toast, fall back to regular toast if customization fails
        try {
            val view = toast.view
            view?.background = ContextCompat.getDrawable(this, R.drawable.toast_background)
            val text = view?.findViewById<TextView>(android.R.id.message)
            text?.setTextColor(Color.BLACK)
        } catch (e: Exception) {
            // Customization failed, using default toast
        }

        toast.show()
    } catch (e: Exception) {
        // In case toast creation itself fails
        Toast.makeText(this, message, length).show()
    }
}