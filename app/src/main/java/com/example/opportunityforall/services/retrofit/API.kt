package com.example.opportunityforall.services.retrofit

import com.example.opportunityforall.services.retrofit.dataclasses.LoginUser
import com.example.opportunityforall.services.dataclasses.login.UserLoginData
import com.example.opportunityforall.services.retrofit.dataclasses.SignUpAthlete
import com.example.opportunityforall.services.retrofit.dataclasses.SignUpCommunity
import retrofit2.Call
import retrofit2.create
import retrofit2.http.*

interface API {
    @Headers("Content-Type: application/json")
    @POST("auth/login")
    fun login(
        @Body body: LoginUser
    ) : Call<UserLoginData>

    @POST("athletes/signup")
    fun athleteSignUp(
        @Body body: SignUpAthlete
    ) : Call<com.example.opportunityforall.services.dataclasses.signup.athlete.AthleteSignUpData>

    @POST("members/signup")
    fun memberSignUp(
        @Body body: SignUpCommunity
    ) : Call<com.example.opportunityforall.services.dataclasses.signup.member.MemberSignUpData>

    companion object {
        val api by lazy { retrofit.create<API>() }
    }
}