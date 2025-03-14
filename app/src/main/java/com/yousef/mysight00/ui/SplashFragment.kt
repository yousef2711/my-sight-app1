package com.yousef.mysight00.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yousef.mysight00.R

class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            if (isAdded) {  // تأكد أن الـ Fragment لا يزال مرتبطًا بـ Activity
                try {
                    findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                } catch (e: Exception) {
                    e.printStackTrace() // طباعة الخطأ في Logcat إذا حدث
                }
            }
        }, 3000)
    }
}
