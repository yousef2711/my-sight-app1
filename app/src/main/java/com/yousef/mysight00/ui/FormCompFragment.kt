package com.yousef.mysight00.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yousef.mysight00.R
import com.yousef.mysight00.databinding.FragmentFormCompBinding


class FormCompFragment : Fragment() {

    private var _binding: FragmentFormCompBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormCompBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupValidation()

        binding.arrowBackPatientForm.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnDonePatientForm.setOnClickListener {
            findNavController().navigate(R.id.action_form_to_login)
        }
    }

    private fun setupValidation() {
        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validateFields()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        binding.namePatientForm.addTextChangedListener(textWatcher)
        binding.emailPatientForm.addTextChangedListener(textWatcher)
    }

    private fun validateFields() {
        val name = binding.namePatientForm.text.toString().trim()
        val relationship = binding.emailPatientForm.text.toString().trim()

        val isNotEmpty = name.isNotEmpty() && relationship.isNotEmpty()

        binding.btnDonePatientForm.isEnabled = isNotEmpty
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
