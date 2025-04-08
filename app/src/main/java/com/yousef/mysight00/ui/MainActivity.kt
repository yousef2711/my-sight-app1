package com.yousef.mysight00.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.yousef.mysight00.R
import com.yousef.mysight00.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
        private const val PREFS_NAME = "MySightPrefs"
        private const val KEY_USER_TYPE = "userType"
        
        const val USER_TYPE_COMPANION = "Companion"
        const val USER_TYPE_ALZHEIMER = "Alzheimer"
        const val USER_TYPE_BLIND = "Blind"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        try {
            hideSystemUI()

            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            setupNavigation()
        } catch (e: Exception) {
            Log.e(TAG, "Error in onCreate: ${e.message}")
        }
    }

    private fun setupNavigation() {
        try {
            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
                ?: throw IllegalStateException("NavHostFragment not found")

            navController = navHostFragment.navController
            val userType = getUserType()
            setNavigationGraph(userType)
        } catch (e: Exception) {
            Log.e(TAG, "Navigation setup error: ${e.message}")

            navController.setGraph(R.navigation.auth_nav_graph)
            navController.navigate(R.id.splashFragment)
        }
    }

    private fun setNavigationGraph(userType: String) {
        when (userType) {
            USER_TYPE_COMPANION -> {
                navController.setGraph(R.navigation.companion_nav_graph)
                navController.navigate(R.id.homeCompanionFragment)
            }
            USER_TYPE_ALZHEIMER -> {
                navController.setGraph(R.navigation.alzheimer_nav_graph)
                navController.navigate(R.id.homeAlzheimerFragment)
            }
            USER_TYPE_BLIND -> {
                navController.setGraph(R.navigation.blind_nav_graph)
                navController.navigate(R.id.homeBlindFragment)
            }
            else -> {
                navController.setGraph(R.navigation.auth_nav_graph)
                navController.navigate(R.id.splashFragment)
            }
        }
    }

    private fun getUserType(): String {
        return getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .getString(KEY_USER_TYPE, "") ?: ""
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    override fun onBackPressed() {
        val currentDestination = navController.currentDestination?.id
        if (currentDestination == R.id.homeCompanionFragment ||
            currentDestination == R.id.homeAlzheimerFragment ||
            currentDestination == R.id.homeBlindFragment) {
            return
        }
        super.onBackPressed()
    }

    override fun onResume() {
        super.onResume()
        hideSystemUI()
    }
}
