package com.example.opportunityforall.ui.fragments.athlete.sign_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.databinding.FragmentAthleteVerificationBinding
import com.example.opportunityforall.services.retrofit.API
import com.example.opportunityforall.services.retrofit.dataclasses.error.ErrorResponse
import com.example.opportunityforall.services.retrofit.dataclasses.SignUpAthlete
import com.example.opportunityforall.toast
import com.example.opportunityforall.ui.TypeBottomBar.*
import com.example.opportunityforall.ui.activities.MainActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class VerificationAthleteFragment : Fragment() {

    private var _binding: FragmentAthleteVerificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAthleteVerificationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            cancelAction.setOnClickListener {
                findNavController().popBackStack(loginFragment, false)
            }

            backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            register.setOnClickListener {
                register(
                    SignUpAthlete(
                        firstName = arguments?.getString("firstName").toString(),
                        lastName = arguments?.getString("lastName").toString(),
                        age = arguments?.getString("age").toString(),
                        file = arguments?.getString("file").toString(),
                        sport = arguments?.getString("sport").toString(),
                        homeCity = arguments?.getString("homeCity").toString(),
                        homeState = arguments?.getString("homeState").toString(),
                        academicYear = arguments?.getString("academicYear").toString(),
                        collegeCity = arguments?.getString("collegeCity").toString(),
                        collegeState = arguments?.getString("collegeState").toString(),
                        university = arguments?.getString("university").toString(),
                        minor = arguments?.getString("minor").toString(),
                        major = arguments?.getString("major").toString(),
                        email = arguments?.getString("email").toString(),
                        password = arguments?.getString("password").toString(),
                        verificationEmail = verificationEmailET.text.toString(),
                        verificationName = verificationNameET.text.toString(),
                        verificationLink = verificationLinkET.text.toString()
                    )
                )
            }
        }
    }

    @DelicateCoroutinesApi
    private fun register(signUpAthlete: SignUpAthlete) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val answer = API.api.athleteSignUp(signUpAthlete).execute()
                GlobalScope.launch (Dispatchers.Main) {
                    if (answer.body()?.id != null) {
                        findNavController().navigate(requestsFragmentAthlete)

                        MainActivity.isShowBottomBar.postValue(true)
                        MainActivity.typeBottomBar.postValue(ATHLETE)
                    } else {
                        val gson = Gson()
                        val type = object : TypeToken<ErrorResponse>() {}.type
                        val errorResponse: ErrorResponse? = gson.fromJson(answer.errorBody()!!.charStream(), type)

                        toast(errorResponse!!.message[0])
                    }
                }
            } catch (e: Exception) {
                toast(e.message.toString())
            }
        }
    }
}