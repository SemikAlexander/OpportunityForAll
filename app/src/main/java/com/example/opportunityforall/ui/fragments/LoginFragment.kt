package com.example.opportunityforall.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.databinding.FragmentLoginBinding
import com.example.opportunityforall.services.retrofit.dataclasses.LoginUser
import com.example.opportunityforall.services.retrofit.API
import com.example.opportunityforall.services.retrofit.dataclasses.error.ErrorLogin
import com.example.opportunityforall.services.retrofit.dataclasses.error.ErrorResponse
import com.example.opportunityforall.toast
import com.example.opportunityforall.ui.TypeBottomBar.*
import com.example.opportunityforall.ui.activities.MainActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MainActivity.isShowBottomBar.postValue(false)

        binding.run {
            signUpButton.setOnClickListener {
                findNavController().navigate(action_loginFragment_to_signUpFragment)
            }

            login.setOnClickListener {
                loginUser(email.text.toString(), password.text.toString())
            }
        }
    }

    @DelicateCoroutinesApi
    fun loginUser(email: String, password: String) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val answer = API.api.login(
                    LoginUser(
                        email = email,
                        password = password
                    )
                ).execute()
                launch(Dispatchers.Main) {
                    when (answer.body()?.user?.role) {
                        "athlete" -> {
                            findNavController().navigate(action_loginFragment_to_requestsFragmentAthlete)

                            MainActivity.isShowBottomBar.postValue(true)
                            MainActivity.typeBottomBar.postValue(ATHLETE)
                        }
                        "member" -> {
                            findNavController().navigate(action_loginFragment_to_athletesFragment)

                            MainActivity.isShowBottomBar.postValue(true)
                            MainActivity.typeBottomBar.postValue(COMMUNITY)
                        }
                        else -> {
                            val type = object : TypeToken<ErrorLogin>() {}.type
                            val errorResponse: ErrorLogin? =
                                Gson().fromJson(answer.errorBody()!!.charStream(), type)

                            toast(errorResponse!!.message)
                        }
                    }
                }
            } catch (e: Exception) {
                launch(Dispatchers.Main) {
                    e.message?.let { toast(it) }
                }
            }
        }
    }
}