package com.yousef.mysight00.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yousef.mysight00.R


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.btn_signup_log).setOnClickListener {
            startActivity(Intent(this, RegisterCompActivity::class.java))
        }

        findViewById<TextView>(R.id.tvForgetPass_login).setOnClickListener {
            startActivity(Intent(this, ForgetPassActivity::class.java))
        }
    }
}