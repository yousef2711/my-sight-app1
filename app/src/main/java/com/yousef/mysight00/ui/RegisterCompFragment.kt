package com.yousef.mysight00.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yousef.mysight00.databinding.FragmentRegisterCompBinding

class RegisterCompFragment : Fragment() {

    private var _binding: FragmentRegisterCompBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterCompBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupValidation()
    }

    private fun setupValidation() {
        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validateFields()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        binding.nameRegisComp.addTextChangedListener(textWatcher)
        binding.emailRegisComp.addTextChangedListener(textWatcher)
        binding.passwordRegisComp.addTextChangedListener(textWatcher)
        binding.ageRegisComp.addTextChangedListener(textWatcher)
        binding.phNumRegisComp.addTextChangedListener(textWatcher)
    }

    private fun validateFields() {
        val name = binding.nameRegisComp.text.toString().trim()
        val email = binding.emailRegisComp.text.toString().trim()
        val password = binding.passwordRegisComp.text.toString().trim()
        val age = binding.ageRegisComp.text.toString().trim()
        val phone = binding.phNumRegisComp.text.toString().trim()

        val isNameValid = name.split(" ").size >= 2
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length >= 6
        val isAgeValid = age.isNotEmpty()
        val isPhoneValid = phone.length == 11 && phone.all { it.isDigit() }

        val isFormValid = isNameValid && isEmailValid && isPasswordValid && isAgeValid && isPhoneValid

        binding.btnRegisComp.isEnabled = isFormValid
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
