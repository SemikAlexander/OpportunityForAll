package com.example.opportunityforall.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.R.menu.*
import com.example.opportunityforall.ui.TypeBottomBar.*
import com.example.opportunityforall.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    companion object {
        val isShowBottomBar = MutableLiveData(false)
        val typeBottomBar = MutableLiveData(COMMUNITY)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        isShowBottomBar.observe({lifecycle}, {
            binding.navView.visibility = if (it) View.VISIBLE else View.GONE
        })

        typeBottomBar.observe({lifecycle}, {
            binding.navView.menu.clear()
            binding.navView.inflateMenu(
                if (it == COMMUNITY) com_member_bottom_nav_menu else bottom_nav_menu
            )
        })

        binding.navView.setOnItemSelectedListener {
            when (it.itemId) {
                /* ------ For Student-Athlete ------ */
                request_athlete ->
                    findNavController(binding.navHostFragment.id)
                        .navigate(requestsFragmentAthlete)
                chat_athlete ->
                    findNavController(binding.navHostFragment.id)
                        .navigate(chatsAthleteFragment)
                profile_athlete ->
                    findNavController(binding.navHostFragment.id)
                        .navigate(profileAthleteFragment)

                /* ------ For Community member ------ */

                athlete ->
                    findNavController(binding.navHostFragment.id)
                        .navigate(athletesFragment)
                chat ->
                    findNavController(binding.navHostFragment.id)
                        .navigate(chatsFragment)
                request ->
                    findNavController(binding.navHostFragment.id)
                        .navigate(requestFragmentCommunity)
            }
            true
        }
    }
}