package com.yousef.mysight00.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yousef.mysight00.R
import com.yousef.mysight00.databinding.FragmentHomeCompanionBinding

class HomeCompanionFragment : Fragment() {

    private var _binding: FragmentHomeCompanionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeCompanionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navigationMap = mapOf(
            binding.icNotificationComp to R.id.action_homeCompanionFragment_to_notificationFragment,
            binding.logoProfileHomeComp to R.id.action_homeCompanionFragment_to_profileFragment,
            binding.imageGpsComp to R.id.action_homeCompanionFragment_to_gpsCompanionFragment,
            binding.tvSeeAll to R.id.action_homeCompanionFragment_to_tasksFragment,
            binding.icCallBlind to R.id.action_homeCompanionFragment_to_audioCallFragment,
            binding.icVideoBlind to R.id.action_homeCompanionFragment_to_videoCallFragment
        )

        navigationMap.forEach { (view, destination) ->
            view.setOnClickListener { navigateTo(destination) }
        }

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.historyFragment -> {
                    navigateTo(R.id.action_homeCompanionFragment_to_historyFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateTo(destination: Int) {
        findNavController().navigate(destination)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
