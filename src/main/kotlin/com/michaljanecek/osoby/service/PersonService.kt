package com.michaljanecek.osoby.service

import com.michaljanecek.osoby.model.BirthNumber
import com.michaljanecek.osoby.model.Person

interface PersonService {
    fun addPerson(firstName: String, lastName: String, birthNumber: BirthNumber) : Boolean
    fun removePerson(birthNumber: BirthNumber) : Boolean
    fun findPerson(birthNumber: BirthNumber): Person?
    fun getAllPersons(): List<Person>
    fun createPopulation()
}
