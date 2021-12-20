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
import com.example.opportunityforall.ui.adapters.ViewPageAdapter
import com.example.opportunityforall.databinding.FragmentOnboardBinding

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
            viewPager.adapter = ViewPageAdapter(requireContext())

            getStartedButton.setOnClickListener {
                findNavController().navigate(R.id.action_onboardFragment_to_loginFragment)
            }

            skipButton.setOnClickListener {
                findNavController().navigate(R.id.action_onboardFragment_to_loginFragment)
            }

            nextButton.setOnClickListener {
                if (viewPager.currentItem != 1) {
                    viewPager.currentItem = ++viewPager.currentItem
                    view2.background =
                        ContextCompat.getDrawable(requireContext(), rounding_active_tab)
                }
                else {
                    nextButton.visibility = View.INVISIBLE
                    skipButton.visibility = View.INVISIBLE
                    getStartedButton.visibility = View.VISIBLE

                    viewPager.currentItem = ++viewPager.currentItem

                    view3.background =
                        ContextCompat.getDrawable(requireContext(), rounding_active_tab)
                }
            }
        }
    }
}