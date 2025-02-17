package com.example.dictionary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dictionary.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.apply {
            registerButton.setOnClickListener {
                val username = usernameEditText.text.toString()
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val confirmPassword = confirmPasswordEditText.text.toString()

                if (validateInput(username, email, password, confirmPassword)) {
                    performRegister(username, email, password)
                }
            }

            loginLink.setOnClickListener {
                // Giriş sayfasına geri dön
                findNavController().navigateUp()
            }
        }
    }

    private fun validateInput(
        username: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        var isValid = true

        if (username.isEmpty()) {
            binding.usernameInputLayout.error = "Kullanıcı adı gerekli"
            isValid = false
        } else {
            binding.usernameInputLayout.error = null
        }

        if (email.isEmpty()) {
            binding.emailInputLayout.error = "E-posta adresi gerekli"
            isValid = false
        } else {
            binding.emailInputLayout.error = null
        }

        if (password.isEmpty()) {
            binding.passwordInputLayout.error = "Şifre gerekli"
            isValid = false
        } else {
            binding.passwordInputLayout.error = null
        }

        if (confirmPassword.isEmpty()) {
            binding.confirmPasswordInputLayout.error = "Şifre tekrarı gerekli"
            isValid = false
        } else if (password != confirmPassword) {
            binding.confirmPasswordInputLayout.error = "Şifreler eşleşmiyor"
            isValid = false
        } else {
            binding.confirmPasswordInputLayout.error = null
        }

        return isValid
    }

    private fun performRegister(username: String, email: String, password: String) {
        // Kayıt işlemleri burada yapılacak
        Toast.makeText(context, "Kayıt işlemi başlatılıyor...", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 