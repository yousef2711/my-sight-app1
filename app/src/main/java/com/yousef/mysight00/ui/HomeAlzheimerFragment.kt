package com.yousef.mysight00.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yousef.mysight00.R
import com.yousef.mysight00.databinding.FragmentHomeAlzheimerBinding

class HomeAlzheimerFragment : Fragment(R.layout.fragment_home_alzheimer) {

    private var _binding: FragmentHomeAlzheimerBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeAlzheimerBinding.bind(view)

        binding.apply {
            bottomNavigationView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_gps -> {navigateTo(R.id.action_home_to_gps)
                        true }
                    R.id.nav_calls -> { navigateTo(R.id.action_home_to_audio_call)
                    true }
                    R.id.nav_task -> { navigateTo(R.id.action_home_to_tasks)
                    true }
                    else -> false
                }
            }

            icNotificationComp.setOnClickListener { navigateTo(R.id.action_home_to_notification) }
            logoProfileHomeComp.setOnClickListener { navigateTo(R.id.action_home_to_profile) }
            tvSeeAll.setOnClickListener { navigateTo(R.id.action_home_to_tasks) }

            listOf(imageCard1Alzh, imageCard2Alzh, imageCard3Alzh, imageCard4Alzh).forEach {
                it.setOnClickListener { navigateTo(R.id.action_home_to_tasks) }
            }

            icCallBlind.setOnClickListener { navigateTo(R.id.action_home_to_audio_call) }
            icVideoBlind.setOnClickListener { navigateTo(R.id.action_home_to_video_call) }
        }
    }

    private fun navigateTo(actionId: Int): Boolean {
        findNavController().navigate(actionId)
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
