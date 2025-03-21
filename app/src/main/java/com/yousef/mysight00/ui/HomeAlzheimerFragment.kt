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
                    R.id.nav_gps -> navigateTo(R.id.action_homeAlzheimerFragment_to_gpsAlzheimerFragmentUnknown)
                    else -> false
                }
            }

            icNotificationComp.setOnClickListener { navigateTo(R.id.action_homeAlzheimerFragment_to_notificationFragment) }
            logoProfileHomeComp.setOnClickListener { navigateTo(R.id.action_homeAlzheimerFragment_to_profileFragment) }
            tvSeeAll.setOnClickListener { navigateTo(R.id.action_homeAlzheimerFragment_to_tasksFragment) }

            listOf(imageCard1Alzh, imageCard2Alzh, imageCard3Alzh, imageCard4Alzh).forEach {
                it.setOnClickListener { navigateTo(R.id.action_homeAlzheimerFragment_to_tasksFragment) }
            }

            icCallBlind.setOnClickListener { navigateTo(R.id.action_homeAlzheimerFragment_to_audioCallFragment) }
            icVideoBlind.setOnClickListener { navigateTo(R.id.action_homeAlzheimerFragment_to_videoCallFragment) }
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
