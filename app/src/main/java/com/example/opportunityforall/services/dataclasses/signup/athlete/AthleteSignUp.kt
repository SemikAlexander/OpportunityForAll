package com.example.opportunityforall.services.dataclasses.signup.athlete

data class AthleteSignUp(
    val academicYear: String,
    val age: String,
    val auth: Auth,
    val collegeCity: String,
    val collegeState: String,
    val createdAt: String,
    val firstName: String,
    val homeCity: String,
    val homeState: String,
    val id: String,
    val isEnabled: Boolean,
    val lastName: String,
    val major: Any,
    val minor: Any,
    val photo: Any,
    val sport: String,
    val university: String,
    val updatedAt: String,
    val user: AthleteSignUpData,
    val verificationEmail: Any,
    val verificationLink: Any,
    val verificationName: Any,
    val verificationStatus: String,
    val version: Int
)