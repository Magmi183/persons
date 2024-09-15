package com.michaljanecek.osoby

import com.michaljanecek.osoby.data.PersonInMemoryDatabase
import com.michaljanecek.osoby.data.PersonRepository
import com.michaljanecek.osoby.service.PersonServiceImpl
import com.michaljanecek.osoby.utils.PersonValidator
import com.michaljanecek.osoby.view.PersonUI

fun main() {
    val repository: PersonRepository = PersonInMemoryDatabase()
    val validator = PersonValidator()
    val service = PersonServiceImpl(repository, validator)

    val personUI = PersonUI(service, validator)

    personUI.start()
}