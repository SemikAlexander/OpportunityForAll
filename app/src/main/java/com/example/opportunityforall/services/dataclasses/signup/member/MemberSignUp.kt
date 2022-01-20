package com.example.opportunityforall.services.dataclasses.signup.member

data class MemberSignUp(
    val auth: Auth,
    val city: String,
    val createdAt: String,
    val id: String,
    val isEnabled: Boolean,
    val name: String,
    val phoneNumber: String,
    val photo: Any,
    val state: String,
    val updatedAt: String,
    val user: MemberSignUpData,
    val version: Int
)