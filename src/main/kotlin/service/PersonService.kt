package service

import model.BirthNumber
import model.Person

interface PersonService {
    fun addPerson(firstName: String, lastName: String, birthNumber: BirthNumber)
    fun removePerson(birthNumber: BirthNumber)
    fun findPerson(birthNumber: BirthNumber): Person?
    fun createPopulation()
}
