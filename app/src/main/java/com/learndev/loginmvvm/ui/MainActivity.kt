package com.learndev.loginmvvm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.learndev.loginmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(com.learndev.loginmvvm.ui.MainViewModel::class.java)
        setContentView(binding.root)
        val isLogin = viewModel.checkUserLogin(this)
        if (isLogin) {
            onResume()
        } else {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        binding.text.text = viewModel.counter.toString()

        binding.button.setOnClickListener {
            viewModel.increment()
            binding.text.text = viewModel.counter.toString()
        }
    }
}