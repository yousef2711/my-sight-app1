package com.yousef.mysight00.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.yousef.mysight00.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide() // إخفاء الـ Action Bar
        setContentView(R.layout.activity_splash) // تعيين شاشة السبلاتش

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish() // إنهاء الـ SplashActivity بعد الانتقال
        }, 3000) // مدة عرض السبلاتش
    }
}
