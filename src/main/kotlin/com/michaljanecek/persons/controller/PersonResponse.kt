package com.michaljanecek.persons.controller

data class PersonResponse(
    val firstName: String,
    val lastName: String,
    val birthNumber: String,
    val age: Int
)