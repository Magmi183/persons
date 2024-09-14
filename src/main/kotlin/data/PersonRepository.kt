package data

import model.BirthNumber
import model.Person


interface PersonRepository {
    fun addPerson(person: Person)
    fun removePerson(birthNumber: BirthNumber)
    fun findPersonByBirthNumber(birthNumber: BirthNumber): Person?
}