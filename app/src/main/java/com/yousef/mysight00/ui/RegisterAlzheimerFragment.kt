package com.yousef.mysight00.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yousef.mysight00.databinding.FragmentRegisterAlzheimerBinding

class RegisterAlzheimerFragment : Fragment() {

    private var _binding: FragmentRegisterAlzheimerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterAlzheimerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validateInputs()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        binding.nameRegisAlz.addTextChangedListener(textWatcher)
        binding.emailRegisAlz.addTextChangedListener(textWatcher)
        binding.passwordRegisAlz.addTextChangedListener(textWatcher)
        binding.ageRegisAlz3.addTextChangedListener(textWatcher)
        binding.phNumRegisAlz.addTextChangedListener(textWatcher)

        binding.btnRegisterRegisAlz3.isEnabled = false
    }

    private fun validateInputs() {
        val name = binding.nameRegisAlz.text.toString().trim()
        val email = binding.emailRegisAlz.text.toString().trim()
        val password = binding.passwordRegisAlz.text.toString().trim()
        val phone = binding.phNumRegisAlz.text.toString().trim()
        val age = binding.ageRegisAlz3.text.toString().trim()

        val isNameValid = name.split(" ").size >= 2
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length >= 6
        val isPhoneValid = phone.length == 11 && phone.all { it.isDigit() }
        val isAgeValid = age.isNotEmpty()

        binding.btnRegisterRegisAlz3.isEnabled =
            isNameValid && isEmailValid && isPasswordValid && isPhoneValid && isAgeValid
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
