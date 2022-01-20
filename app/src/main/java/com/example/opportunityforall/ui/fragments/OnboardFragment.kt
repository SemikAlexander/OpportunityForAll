package com.example.opportunityforall.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.R.drawable.rounding_active_tab
import com.example.opportunityforall.R.drawable.rounding_default_tab
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.databinding.FragmentOnboardBinding
import com.example.opportunityforall.ui.adapters.ViewPageAdapter

class OnboardFragment : Fragment() {
    private var _binding: FragmentOnboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            val views = listOf(
                view1, view2, view3, view4,
                view5, view6, view7, view8
            )

            viewPager.adapter = ViewPageAdapter(requireContext())
            viewPager.isUserInputEnabled = false

            getStartedButton.setOnClickListener {
                findNavController().navigate(action_onboardFragment_to_loginFragment)
            }

            skipButton.setOnClickListener {
                findNavController().navigate(action_onboardFragment_to_loginFragment)
            }

            nextButton.setOnClickListener {
                if (viewPager.currentItem != 6) {
                    viewPager.currentItem = ++viewPager.currentItem

                    views.forEach {
                        it.background =
                            ContextCompat.getDrawable(requireContext(), rounding_default_tab)
                    }

                    views[viewPager.currentItem].background =
                        ContextCompat.getDrawable(requireContext(), rounding_active_tab)
                } else {
                    nextButton.visibility = View.GONE
                    skipButton.visibility = View.GONE
                    getStartedButton.visibility = View.VISIBLE

                    viewPager.currentItem = ++viewPager.currentItem

                    views.forEach {
                        it.background =
                            ContextCompat.getDrawable(requireContext(), rounding_default_tab)
                    }

                    views[viewPager.currentItem].background =
                        ContextCompat.getDrawable(requireContext(), rounding_active_tab)
                }
            }
        }
    }
}