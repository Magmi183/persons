package com.michaljanecek.osoby.service

import com.michaljanecek.osoby.data.PersonRepository
import com.michaljanecek.osoby.model.BirthNumber
import com.michaljanecek.osoby.model.Person
import com.michaljanecek.osoby.utils.PersonValidator
import kotlin.random.Random

class PersonServiceImpl(
    private val repository: PersonRepository,
    private val validator: PersonValidator
) : PersonService {

    init {
        createPopulation()
    }

    override fun addPerson(firstName: String, lastName: String, birthNumber: BirthNumber) {
        val validationErrors = mutableListOf<String>()

        if (!validator.validateFirstName(firstName)) {
            validationErrors.add("First name must not be empty.")
        }
        if (!validator.validateLastName(lastName)) {
            validationErrors.add("Last name must not be empty.")
        }
        if (!validator.validateBirthNumber(birthNumber.birthNumber)) {
            validationErrors.add("Invalid birth number format.")
        }

        if (validationErrors.isNotEmpty()) {
            throw IllegalArgumentException(validationErrors.joinToString(", "))
        }

        val person = Person(firstName, lastName, birthNumber)
        repository.addPerson(person)
    }

    override fun removePerson(birthNumber: BirthNumber) {
        repository.removePerson(birthNumber)
    }

    override fun findPerson(birthNumber: BirthNumber): Person? {
        return repository.findPersonByBirthNumber(birthNumber)
    }

    override fun createPopulation() {
        val firstNames =
            listOf("John", "Jane", "Michael", "Sarah", "David", "Emily", "Robert", "Olivia", "Chris", "Sophia")
        val lastNames =
            listOf("Doe", "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Martinez", "Davis", "Rodriguez")

        repeat(1000) {
            val firstName = firstNames.random()
            val lastName = lastNames.random()

            // Generate a random valid birth number in the format YYMMDDXXXX
            val year = Random.nextInt(70, 99).toString().padStart(2, '0')
            val month = Random.nextInt(1, 12).toString().padStart(2, '0')
            val day = Random.nextInt(1, 28).toString().padStart(2, '0')
            val serial = Random.nextInt(1000, 9999).toString()

            val birthNumber = BirthNumber("$year$month$day$serial")

            val person = Person(firstName, lastName, birthNumber)

            repository.addPerson(person)
        }
    }
}
