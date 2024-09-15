package com.michaljanecek.persons.data

import com.michaljanecek.persons.model.BirthNumber
import com.michaljanecek.persons.model.Person


interface PersonRepository {
    fun addPerson(person: Person)
    fun removePerson(birthNumber: BirthNumber)
    fun findPersonByBirthNumber(birthNumber: BirthNumber): Person?
}