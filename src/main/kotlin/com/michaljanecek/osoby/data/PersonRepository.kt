package com.michaljanecek.osoby.data

import com.michaljanecek.osoby.model.BirthNumber
import com.michaljanecek.osoby.model.Person


interface PersonRepository {
    fun addPerson(person: Person)
    fun removePerson(birthNumber: BirthNumber)
    fun findPersonByBirthNumber(birthNumber: BirthNumber): Person?
    fun getAllPersons(): List<Person>
}