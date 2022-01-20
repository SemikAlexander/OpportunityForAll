package com.example.opportunityforall.services.retrofit.dataclasses

import com.google.gson.annotations.SerializedName

data class SignUpAthlete(
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("age") val age: String,
    @SerializedName("file") val file: String,
    @SerializedName("sport") val sport: String,
    @SerializedName("homeCity") val homeCity: String,
    @SerializedName("homeState") val homeState: String,
    @SerializedName("academicYear") val academicYear: String,
    @SerializedName("collegeCity") val collegeCity: String,
    @SerializedName("collegeState") val collegeState: String,
    @SerializedName("university") val university: String,
    @SerializedName("minor") val minor: String,
    @SerializedName("major") val major: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("verificationEmail") val verificationEmail: String,
    @SerializedName("verificationName") val verificationName: String,
    @SerializedName("verificationLink") val verificationLink: String,
)