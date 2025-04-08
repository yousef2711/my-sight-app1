package com.yousef.mysight00.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yousef.mysight00.R
import com.yousef.mysight00.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply {
            btnSignupLog.setOnClickListener {
                navigateToRegister()
            }

            tvForgetPassLogin.setOnClickListener {
                navigateToForgetPassword()
            }

            btnLoginLogin.setOnClickListener {
                handleLogin()
            }
        }
    }

    private fun navigateToRegister() {
        try {
            findNavController().navigate(R.id.action_login_to_register)
        } catch (e: Exception) {
            showErrorToast("حدث خطأ أثناء الانتقال إلى صفحة التسجيل")
        }
    }

    private fun navigateToForgetPassword() {
        try {
            findNavController().navigate(R.id.action_login_to_forget_password)
        } catch (e: Exception) {
            showErrorToast("حدث خطأ أثناء الانتقال إلى صفحة نسيان كلمة المرور")
        }
    }

    private fun handleLogin() {
        val email = binding.emailLogin.text.toString().trim()
        val password = binding.passwordLogin.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            showErrorToast("الرجاء إدخال البريد الإلكتروني وكلمة المرور")
            return
        }

        try {
            when {
                email == "companion@gmail.com" && password == "123456" -> {
                    storeUserType("Companion")
                    navigateToCompanion()
                }
                email == "alzhaimer@gmail.com" && password == "123456" -> {
                    storeUserType("Alzheimer")
                    navigateToAlzheimer()
                }
                email == "blind@gmail.com" && password == "123456" -> {
                    storeUserType("Blind")
                    navigateToBlind()
                }
                else -> {
                    showErrorToast("البريد الإلكتروني أو كلمة المرور غير صحيحة")
                }
            }
        } catch (e: Exception) {
            showErrorToast("حدث خطأ أثناء تسجيل الدخول")
        }
    }

    private fun navigateToCompanion() {
        try {
            findNavController().navigate(R.id.action_login_to_companion)
        } catch (e: Exception) {
            showErrorToast("حدث خطأ أثناء الانتقال إلى صفحة المرافق")
        }
    }

    private fun navigateToAlzheimer() {
        try {
            findNavController().navigate(R.id.action_login_to_alzheimer)
        } catch (e: Exception) {
            showErrorToast("حدث خطأ أثناء الانتقال إلى صفحة مريض الزهايمر")
        }
    }

    private fun navigateToBlind() {
        try {
            findNavController().navigate(R.id.action_login_to_blind)
        } catch (e: Exception) {
            showErrorToast("حدث خطأ أثناء الانتقال إلى صفحة المكفوف")
        }
    }

    private fun storeUserType(userType: String) {
        try {
            val sharedPref = requireActivity().getSharedPreferences("MySightPrefs", AppCompatActivity.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("USER_TYPE", userType)
                apply()
            }
        } catch (e: Exception) {
            showErrorToast("حدث خطأ أثناء حفظ نوع المستخدم")
        }
    }

    private fun showErrorToast(message: String) {
        try {
            val toast = Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
            val view = toast.view

            view?.background = ContextCompat.getDrawable(requireContext(), R.drawable.toast_background)

            val text = view?.findViewById<TextView>(android.R.id.message)
            text?.setTextColor(Color.BLACK)

            toast.show()
        } catch (e: Exception) {
            // Fallback to simple toast if custom toast fails
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
