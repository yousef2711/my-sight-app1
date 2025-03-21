package com.yousef.mysight00.ui

import android.os.Bundle
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

        // زر الرجوع للصفحة السابقة
        binding.arrowBackPatientForm.setOnClickListener {
            findNavController().navigateUp()
        }

        // زر الانتقال إلى صفحة تسجيل الدخول
        binding.btnDonePatientForm.setOnClickListener {
            findNavController().navigate(R.id.action_formCompFragment3_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
