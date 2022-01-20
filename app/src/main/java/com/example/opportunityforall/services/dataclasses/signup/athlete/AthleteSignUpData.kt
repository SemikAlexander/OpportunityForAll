package com.example.opportunityforall.services.dataclasses.signup.athlete

data class AthleteSignUpData(
    val createdAt: String,
    val email: String,
    val id: String,
    val isEnabled: Boolean,
    val role: String,
    val updatedAt: String,
    val version: Int
)