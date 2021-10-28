package com.learndev.loginmvvm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.learndev.loginmvvm.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val editTextEmail = binding.inputEmail.text.toString()
            val editTextPassword = binding.inputPassword.text.toString()
            val result = viewModel.login(editTextEmail, editTextPassword, this)
            if (result) {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            } else {
                Log.e("Error ini mah", result.toString())
            }
        }
    }
}