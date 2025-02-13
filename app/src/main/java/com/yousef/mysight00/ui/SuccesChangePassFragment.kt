package com.yousef.mysight00.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.yousef.mysight00.R

class SuccesChangePassFragment : Fragment() {
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
    }
}
