package com.example.opportunityforall.services.retrofit.dataclasses

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

data class SignUpCommunity(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("name") val name: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("file") val file: String
)
