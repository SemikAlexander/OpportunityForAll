package com.example.opportunityforall.services.dataclasses.location.state

data class State(
    val count: Int,
    val `data`: List<Data>,
    val page: Int,
    val pageCount: Int,
    val total: Int
)