package com.yousef.mysight00.utils

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class UserPreferences(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("MySightPrefs", AppCompatActivity.MODE_PRIVATE)

    companion object {
        private const val USER_TYPE = "USER_TYPE"
    }

    fun saveUserType(userType: String) {
        sharedPreferences.edit().putString(USER_TYPE, userType).apply()
    }

    fun getUserType(): String? {
        return sharedPreferences.getString(USER_TYPE, null)
    }

    fun clearUserData() {
        sharedPreferences.edit().clear().apply()
    }
}