package com.yousef.mysight00.ui

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yousef.mysight00.R
import com.yousef.mysight00.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private var isCompanionSelected = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupValidation()
        setupNavigation()
        selectCompanion()
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

        val isNotEmpty = name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && age.isNotEmpty() && phone.isNotEmpty()

        val isNameValid = name.split(" ").size >= 2
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length >= 6
        val isAgeValid = age.isNotEmpty() && age.toIntOrNull() != null && age.toInt() > 0
        val isPhoneValid = phone.length == 11 && phone.all { it.isDigit() }

        val isFormValid = isNotEmpty && isNameValid && isEmailValid && isPasswordValid && isAgeValid && isPhoneValid

        binding.btnRegisComp.isEnabled = isFormValid
    }

    private fun setupNavigation() {
        binding.btnblindRegisComp.setOnClickListener {
            selectBlind()
        }

        binding.btnalzheimerRegisComp.setOnClickListener {
            selectAlzheimer()
        }

        binding.btncompanionRegisComp.setOnClickListener {
            selectCompanion()
        }

        binding.btnRegisComp.setOnClickListener {
            if (isCompanionSelected) {
                findNavController().navigate(R.id.action_register_to_form)
            } else {
                findNavController().navigate(R.id.action_register_to_login)
            }
        }

        binding.btnLoginRegisComp.setOnClickListener {
            findNavController().navigate(R.id.action_register_to_login)
        }
        binding.arrowBackRegisComp.setOnClickListener {
            findNavController().navigate(R.id.action_register_to_login)
        }
        binding.logTextRegisComp.setOnClickListener {
            findNavController().navigate(R.id.action_register_to_login)
        }
    }

    private fun selectBlind() {
        resetButtons()
        binding.btnblindRegisComp.setBackgroundColor(Color.parseColor("#007AFF"))
        binding.btnblindRegisComp.setTextColor(Color.WHITE)
        isCompanionSelected = false
    }

    private fun selectAlzheimer() {
        resetButtons()
        binding.btnalzheimerRegisComp.setBackgroundColor(Color.parseColor("#007AFF"))
        binding.btnalzheimerRegisComp.setTextColor(Color.WHITE)
        isCompanionSelected = false
    }

    private fun selectCompanion() {
        resetButtons()
        binding.btncompanionRegisComp.setBackgroundColor(Color.parseColor("#007AFF"))
        binding.btncompanionRegisComp.setTextColor(Color.WHITE)
        isCompanionSelected = true
    }

    private fun resetButtons() {
        binding.btnblindRegisComp.setBackgroundColor(Color.WHITE)
        binding.btnblindRegisComp.setTextColor(Color.BLACK)

        binding.btnalzheimerRegisComp.setBackgroundColor(Color.WHITE)
        binding.btnalzheimerRegisComp.setTextColor(Color.BLACK)

        binding.btncompanionRegisComp.setBackgroundColor(Color.WHITE)
        binding.btncompanionRegisComp.setTextColor(Color.BLACK)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
