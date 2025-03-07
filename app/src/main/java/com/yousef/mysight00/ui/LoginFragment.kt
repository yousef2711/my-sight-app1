package com.yousef.mysight00.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yousef.mysight00.R
import com.yousef.mysight00.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        binding.btnSignupLog.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_registerCompFragment)
        }

        binding.tvForgetPassLogin.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_forgetPassFragment)
        }

        binding.btnLoginLogin.setOnClickListener {
            val email = binding.emailLogin.text.toString().trim()
            val password = binding.passwordLogin.text.toString().trim()

            if (email == "companion@gmail.com" && password == "123456") {
                navController.navigate(R.id.action_loginFragment_to_homeCompanionFragment)
            } else if (email == "alzhaimer@gmail.com" && password == "123456") {
                navController.navigate(R.id.action_loginFragment_to_homeAlzheimerFragment)
            } else if (email == "blind@gmail.com" && password == "123456") {
                navController.navigate(R.id.action_loginFragment_to_homeBlindFragment)
            } else {
                Toast.makeText(requireContext(), "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
