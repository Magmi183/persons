package com.michaljanecek.persons.controller

data class PersonRequest(
    val firstName: String,
    val lastName: String,
    val birthNumber: String
)