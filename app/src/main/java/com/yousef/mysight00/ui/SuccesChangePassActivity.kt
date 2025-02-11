package com.yousef.mysight00.ui

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.yousef.mysight00.R

class SuccesChangePassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_succes_change_pass)

        val successPopup: ImageView = findViewById(R.id.successPopup)

        val animation = AnimationUtils.loadAnimation(this, R.anim.success_popup_animation)

        successPopup.startAnimation(animation)
    }
}