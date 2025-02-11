package com.yousef.mysight00.ui

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.yousef.mysight00.R

class NewPasswordActivity : AppCompatActivity() {
    private lateinit var passwordField: EditText
    private lateinit var confirmPasswordField: EditText
    private lateinit var showPasswordCheckbox: CheckBox
    private lateinit var verifyButton: MaterialButton
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_passeord)

        // ربط العناصر الصحيحة
        passwordField = findViewById(R.id.password1_newpass)
        confirmPasswordField = findViewById(R.id.password2_newpass)
        showPasswordCheckbox = findViewById(R.id.showPasswordCheckbox_newpass)
        verifyButton = findViewById(R.id.btnVerify_newpass)
        backButton = findViewById(R.id.backButton_newpass)

        findViewById<ImageView>(R.id.backButton_newpass).setOnClickListener {
            startActivity(Intent(this, OtpVerificationActivity::class.java))
        }

        // تفعيل إظهار/إخفاء كلمة المرور عند الضغط على CheckBox
        showPasswordCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                passwordField.transformationMethod = HideReturnsTransformationMethod.getInstance()
                confirmPasswordField.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                passwordField.transformationMethod = PasswordTransformationMethod.getInstance()
                confirmPasswordField.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }

        // التحقق عند الضغط على زر "Verify"
        verifyButton.setOnClickListener {
            val password = passwordField.text.toString()
            val confirmPassword = confirmPasswordField.text.toString()

            if (password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please enter both fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Password changed successfully!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, SuccesChangePassActivity::class.java))
                finish()
            }
        }

        // زر الرجوع
        backButton.setOnClickListener {
            finish()
        }
    }
}
