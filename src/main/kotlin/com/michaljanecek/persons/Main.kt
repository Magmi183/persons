package com.michaljanecek.persons

import com.michaljanecek.persons.data.PersonInMemoryDatabase
import com.michaljanecek.persons.data.PersonRepository
import com.michaljanecek.persons.service.PersonServiceImpl
import com.michaljanecek.persons.utils.PersonValidator
import com.michaljanecek.persons.view.PersonUI

fun main() {
    val repository: PersonRepository = PersonInMemoryDatabase()
    val validator = PersonValidator()
    val service = PersonServiceImpl(repository, validator)

    val personUI = PersonUI(service, validator)

    personUI.start()
}