package com.yousef.mysight00.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yousef.mysight00.R


class ForgetPassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pass)

        findViewById<TextView>(R.id.txtCancel_forget).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        findViewById<Button>(R.id.btnDone_forget).setOnClickListener {
            startActivity(Intent(this, OtpVerificationActivity::class.java))
        }
    }
}