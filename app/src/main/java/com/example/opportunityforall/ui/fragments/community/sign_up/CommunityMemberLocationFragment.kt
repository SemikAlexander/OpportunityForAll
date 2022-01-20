package com.example.opportunityforall.ui.fragments.community.sign_up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.databinding.FragmentCommunityMemberLocationBinding
import com.example.opportunityforall.services.retrofit.API
import com.example.opportunityforall.services.retrofit.dataclasses.error.ErrorResponse
import com.example.opportunityforall.services.retrofit.dataclasses.SignUpCommunity
import com.example.opportunityforall.toast
import com.example.opportunityforall.ui.TypeBottomBar.*
import com.example.opportunityforall.ui.activities.MainActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CommunityMemberLocationFragment : Fragment() {

    private var _binding: FragmentCommunityMemberLocationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommunityMemberLocationBinding.inflate(layoutInflater)
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

            registerButton.setOnClickListener {
                register(
                    SignUpCommunity(
                        name = arguments?.getString("name").toString(),
                        email = arguments?.getString("email").toString(),
                        password = arguments?.getString("password").toString(),
                        phoneNumber = arguments?.getString("phoneNumber").toString(),
                        city = cityET.text.toString(),
                        state = stateET.text.toString(),
                        file = arguments?.getString("uri").toString()
                    )
                )
            }
        }
    }

    @DelicateCoroutinesApi
    private fun register(signUpCommunity: SignUpCommunity) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val answer = API.api.memberSignUp(signUpCommunity).execute()
                GlobalScope.launch (Dispatchers.Main) {
                    if (answer.body()?.id != null) {
                        findNavController().navigate(athletesFragment)

                        MainActivity.isShowBottomBar.postValue(true)
                        MainActivity.typeBottomBar.postValue(COMMUNITY)
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