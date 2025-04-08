package com.yousef.mysight00.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.yousef.mysight00.R
import com.yousef.mysight00.databinding.FragmentVideoCallBinding

class VideoCallFragment : Fragment() {

    private var _binding: FragmentVideoCallBinding? = null
    private val binding get() = _binding!!

    private var isChanged = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoCallBinding.inflate(inflater, container, false)

        binding.btnChange.setOnClickListener {
            toggleButtonStyle()
        }

        return binding.root
    }

    private fun toggleButtonStyle() {
        isChanged = !isChanged

        if (isChanged) {
            binding.btnChange.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.btnChange.setIconTintResource(R.color.black)
        } else {
            binding.btnChange.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.dark))
            binding.btnChange.setIconTintResource(R.color.white)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
