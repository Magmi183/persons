package com.michaljanecek.osoby.com.michaljanecek.osoby.controller

data class PersonResponse(
    val firstName: String,
    val lastName: String,
    val birthNumber: String,
    val age: Int
)