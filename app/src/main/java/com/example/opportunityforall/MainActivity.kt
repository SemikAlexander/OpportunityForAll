package com.example.opportunityforall

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.opportunityforall.adapters.ViewPageAdapter
import com.example.opportunityforall.databinding.ActivityMainBinding
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

            TabLayoutMediator(tabDots, viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->

            }).attach()

            nextButton.setOnClickListener {
                if (viewPager.currentItem != 1)
                    viewPager.currentItem = ++viewPager.currentItem
                else {
                    nextButton.visibility = View.INVISIBLE
                    skipButton.visibility = View.INVISIBLE
                    getStartedButton.visibility = View.VISIBLE
                    viewPager.currentItem = ++viewPager.currentItem
                }
            }

            viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                }
            })
        }
    }
}