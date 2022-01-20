package com.example.opportunityforall.services.dataclasses.location.city.cities_in_state

data class CitiesInState(
    val cities: List<City>,
    val id: Int,
    val institutions: List<Institution>,
    val name: String,
    val postal: String
)