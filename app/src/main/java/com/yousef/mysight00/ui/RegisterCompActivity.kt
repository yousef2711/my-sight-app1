package com.yousef.mysight00.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.yousef.mysight00.R

class RegisterCompActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_comp)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, RegisterBlindActivity::class.java))
            finish()
        }, 5000) // تأخير 10 ثوانٍ قبل الانتقال إلى الشاشة التالية
    }
}
