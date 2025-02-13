package com.yousef.mysight00.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yousef.mysight00.R
import com.yousef.mysight00.databinding.FragmentOtpverificationBinding

class OtpVerificationFragment : Fragment() {

    private var _binding: FragmentOtpverificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtpverificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnVerifyOtp.setOnClickListener {
            findNavController().navigate(R.id.action_otpVerificationFragment_to_newPasswordFragment)
        }

        binding.btnBackOtp.setOnClickListener {
            findNavController().navigate(R.id.action_otpVerificationFragment_to_forgetPassFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
