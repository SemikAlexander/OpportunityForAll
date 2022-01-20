package com.example.opportunityforall.services.retrofit.dataclasses.error

data class ErrorLogin(
    val error: String,
    val message: String,
    val statusCode: Int
)