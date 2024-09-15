package com.michaljanecek.persons.data

import com.michaljanecek.persons.model.BirthNumber
import com.michaljanecek.persons.model.Person
import org.springframework.stereotype.Repository

@Repository
class PersonInMemoryDatabase : PersonRepository {
    private val personStorage = mutableMapOf<BirthNumber, Person>()

    override fun addPerson(person: Person): Boolean {
        return if (!personStorage.containsKey(person.birthNumber)) {
            personStorage[person.birthNumber] = person
            true // Person added successfully
        } else {
            false // Person already exists
        }
    }

    override fun removePerson(birthNumber: BirthNumber): Boolean {
        return if (personStorage.containsKey(birthNumber)) {
            personStorage.remove(birthNumber)
            true // Person removed successfully
        } else {
            false // Person not found
        }
    }

    // Returns the person if found, null otherwise
    override fun findPersonByBirthNumber(birthNumber: BirthNumber): Person? {
        return personStorage[birthNumber]
    }

    // Returns a list of all persons
    override fun getAllPersons(): List<Person> {
        return personStorage.values.toList()
    }
}