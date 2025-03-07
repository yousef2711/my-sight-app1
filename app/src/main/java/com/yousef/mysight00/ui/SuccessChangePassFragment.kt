package com.yousef.mysight00.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yousef.mysight00.R

class SuccessChangePassFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_succes_change_pass, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val successPopup: ImageView = view.findViewById(R.id.successPopup)
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.success_popup_animation)
        successPopup.startAnimation(animation)

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_successChangePassFragment_to_loginFragment)
        }, 2500)
    }
}
