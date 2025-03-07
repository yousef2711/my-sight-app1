package com.yousef.mysight00.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yousef.mysight00.R
import com.yousef.mysight00.databinding.FragmentRegisterBlindBinding

class RegisterBlindFragment : Fragment() {

    private var _binding: FragmentRegisterBlindBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBlindBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegisBlind.setOnClickListener {
            if (validateInputs()) {
                Toast.makeText(requireContext(), "Registration Successful!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_registerBlindFragment_to_loginFragment)
            }
        }
        binding.arrowBackRegisBlind.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun validateInputs(): Boolean {
        val name = binding.nameRegisBlind.text.toString().trim()
        val email = binding.emailRegisBlind.text.toString().trim()
        val password = binding.passwordRegisBlind.text.toString().trim()
        val age = binding.ageRegisBlind.text.toString().trim()
        val phone = binding.phNumRegisBlind.text.toString().trim()

        if (name.isEmpty()) {
            binding.nameRegisBlind.error = "Please enter your name"
            return false
        }
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailRegisBlind.error = "Enter a valid email"
            return false
        }
        if (password.length < 6) {
            binding.passwordRegisBlind.error = "Password must be at least 6 characters"
            return false
        }
        if (age.isEmpty() || age.toIntOrNull() == null || age.toInt() < 1) {
            binding.ageRegisBlind.error = "Enter a valid age"
            return false
        }
        if (phone.length != 11) {
            binding.phNumRegisBlind.error = "Enter a valid 11-digit phone number"
            return false
        }
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
