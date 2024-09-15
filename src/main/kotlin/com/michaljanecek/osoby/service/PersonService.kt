package com.michaljanecek.osoby.service

import com.michaljanecek.osoby.model.BirthNumber
import com.michaljanecek.osoby.model.Person

interface PersonService {
    fun addPerson(firstName: String, lastName: String, birthNumber: BirthNumber)
    fun removePerson(birthNumber: BirthNumber)
    fun findPerson(birthNumber: BirthNumber): Person?
    fun createPopulation()
}
