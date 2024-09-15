package com.michaljanecek.osoby.data

import com.michaljanecek.osoby.model.BirthNumber
import com.michaljanecek.osoby.model.Person
import org.springframework.stereotype.Repository

@Repository
class PersonInMemoryDatabase : PersonRepository {
    private val personStorage = mutableMapOf<BirthNumber, Person>()

    override fun addPerson(person: Person) {
        // Check if a person with the same birth number already exists
        if (personStorage.containsKey(person.birthNumber)) {
            throw IllegalArgumentException("Person with birth number ${person.birthNumber} already exists.")
        }
        personStorage[person.birthNumber] = person
    }

    override fun removePerson(birthNumber: BirthNumber) {
        // Check if the person exists before trying to remove
        if (!personStorage.containsKey(birthNumber)) {
            throw IllegalArgumentException("No person found with birth number $birthNumber.")
        }
        personStorage.remove(birthNumber)
    }

    override fun findPersonByBirthNumber(birthNumber: BirthNumber): Person? {
        if (!personStorage.containsKey(birthNumber)) {
            throw IllegalArgumentException("No person found with birth number $birthNumber.")
        }
        return personStorage[birthNumber]
    }

    override fun getAllPersons(): List<Person> {
        return personStorage.values.toList()
    }
}
