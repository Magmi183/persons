package com.michaljanecek.osoby.model

import java.time.LocalDate
import java.time.Period

data class Person(val firstName: String, val lastName: String, val birthNumber: BirthNumber) {

    // Calculate age based on birth number
    private val age: Int by lazy {
        val birthDate = birthNumber.birthDate
        val currentDate = LocalDate.now()
        Period.between(birthDate, currentDate).years
    }

    override fun toString(): String {
        return """
            Name: $firstName $lastName
            Birth Number: $birthNumber
            Age: $age years
        """
    }
}


