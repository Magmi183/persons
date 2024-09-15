package com.michaljanecek.persons.service

import com.michaljanecek.persons.model.BirthNumber
import com.michaljanecek.persons.model.Person

interface PersonService {
    fun addPerson(firstName: String, lastName: String, birthNumber: BirthNumber) : Boolean
    fun removePerson(birthNumber: BirthNumber) : Boolean
    fun findPerson(birthNumber: BirthNumber): Person?
    fun getAllPersons(): List<Person>
    fun createPopulation()
}
