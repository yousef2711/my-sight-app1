package com.yousef.mysight00.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yousef.mysight00.R
import com.yousef.mysight00.databinding.FragmentRegisterAlzheimerBinding
import com.yousef.mysight00.databinding.FragmentRegisterBlindBinding

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

        // تأخير الانتقال التلقائي لمدة 2.5 ثانية (2500 مللي ثانية)
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_registerAlzheimerFragment_to_registerBlindFragment)
        }, 2500)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

