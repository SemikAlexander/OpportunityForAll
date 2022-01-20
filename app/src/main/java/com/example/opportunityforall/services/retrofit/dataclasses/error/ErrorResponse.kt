package com.example.opportunityforall.services.retrofit.dataclasses.error

data class ErrorResponse(
    val error: String,
    val message: List<String>,
    val statusCode: Int
)