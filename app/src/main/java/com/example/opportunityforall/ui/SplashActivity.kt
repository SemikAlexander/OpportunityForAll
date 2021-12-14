package com.example.opportunityforall.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.opportunityforall.databinding.ActivitySplashBinding
import com.example.opportunityforall.startActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch {
            delay(3000)
            startActivity<MainActivity>()
            finish()
        }
    }
}