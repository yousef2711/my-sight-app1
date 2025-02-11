package com.yousef.mysight00.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.yousef.mysight00.R


class OtpVerificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpverification)

        findViewById<Button>(R.id.btnVerify_otp).setOnClickListener {
            startActivity(Intent(this, NewPasswordActivity::class.java))
        }
        findViewById<ImageView>(R.id.btnBack_otp).setOnClickListener {
            startActivity(Intent(this, ForgetPassActivity::class.java))
        }
    }
}