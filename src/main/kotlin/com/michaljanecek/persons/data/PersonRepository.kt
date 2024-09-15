package com.michaljanecek.persons.data

import com.michaljanecek.persons.model.BirthNumber
import com.michaljanecek.persons.model.Person


interface PersonRepository {
    fun addPerson(person: Person) : Boolean
    fun removePerson(birthNumber: BirthNumber) : Boolean
    fun findPersonByBirthNumber(birthNumber: BirthNumber): Person?
    fun getAllPersons(): List<Person>
}