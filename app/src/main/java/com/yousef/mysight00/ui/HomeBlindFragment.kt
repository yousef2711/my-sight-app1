package com.yousef.mysight00.ui

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yousef.mysight00.R
import com.yousef.mysight00.databinding.FragmentHomeBlindBinding

class HomeBlindFragment : Fragment() {

    private var _binding: FragmentHomeBlindBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBlindBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            // OnClickListeners for each element
            logoProfileHomeBlind.setOnClickListener { navigateTo(R.id.action_homeBlindFragment_to_profileFragment) }
            icNotificationBlind.setOnClickListener { navigateTo(R.id.action_homeBlindFragment_to_notificationFragment) }
            icCameraBlind.setOnClickListener { openCamera() }
            icCallBlind.setOnClickListener { navigateTo(R.id.action_homeBlindFragment_to_audioCallFragment) }
            icVideoBlind.setOnClickListener { navigateTo(R.id.action_homeBlindFragment_to_videoCallFragment) }

            // BottomNavigationView interaction
            bottomNavigationViewBlind.setOnItemSelectedListener { item ->
                when (item.itemId) {

                    R.id.nav_gps -> {
                        navigateTo(R.id.action_homeBlindFragment_to_gpsBlindFragment)
                        true
                    }
                    else -> false
                }
            }
        }
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(cameraIntent)
    }

    private fun navigateTo(actionId: Int) {
        findNavController().navigate(actionId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
