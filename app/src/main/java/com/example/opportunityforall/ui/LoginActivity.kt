package com.example.opportunityforall.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.opportunityforall.databinding.ActivityLoginBinding
import com.example.opportunityforall.startActivity

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            signUpButton.setOnClickListener { startActivity<SignUpActivity>() }
        }
    }
}