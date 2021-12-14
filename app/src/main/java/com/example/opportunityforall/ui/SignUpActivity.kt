package com.example.opportunityforall.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.example.opportunityforall.R
import com.example.opportunityforall.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            studentAthlete.setOnClickListener {
                choiceType(studentAthlete, community)
            }

            community.setOnClickListener {
                choiceType(community, studentAthlete)
            }
        }
    }

    private fun choiceType(linear1: LinearLayout, linear2: LinearLayout) {
        linear1.background =
            ContextCompat.getDrawable(this@SignUpActivity, R.drawable.rounding_choise_active)

        linear2.background =
            ContextCompat.getDrawable(this@SignUpActivity, R.drawable.rounding_choise_default)

        binding.nextButton.isEnabled = true
    }
}