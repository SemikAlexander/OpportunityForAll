package com.example.opportunityforall.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getDrawable
import androidx.viewpager2.widget.ViewPager2
import com.example.opportunityforall.R
import com.example.opportunityforall.R.drawable.*
import com.example.opportunityforall.adapters.ViewPageAdapter
import com.example.opportunityforall.databinding.ActivityMainBinding
import com.example.opportunityforall.startActivity
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            viewPager.adapter = ViewPageAdapter(this@MainActivity)

            skipButton.setOnClickListener {
                finish()
                startActivity<LoginActivity>()
            }

            getStartedButton.setOnClickListener {
                finish()
                startActivity<LoginActivity>()
            }

            nextButton.setOnClickListener {
                if (viewPager.currentItem != 1) {
                    viewPager.currentItem = ++viewPager.currentItem
                    view2.background = getDrawable(this@MainActivity, roundung_active_tab)
                }
                else {
                    nextButton.visibility = View.INVISIBLE
                    skipButton.visibility = View.INVISIBLE
                    getStartedButton.visibility = View.VISIBLE

                    viewPager.currentItem = ++viewPager.currentItem

                    view3.background = getDrawable(this@MainActivity, roundung_active_tab)
                }
            }
        }
    }
}