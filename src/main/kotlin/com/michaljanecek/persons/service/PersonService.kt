package com.michaljanecek.persons.service

import com.michaljanecek.persons.model.BirthNumber
import com.michaljanecek.persons.model.Person

interface PersonService {
    fun addPerson(firstName: String, lastName: String, birthNumber: BirthNumber)
    fun removePerson(birthNumber: BirthNumber)
    fun findPerson(birthNumber: BirthNumber): Person?
    fun createPopulation()
}
