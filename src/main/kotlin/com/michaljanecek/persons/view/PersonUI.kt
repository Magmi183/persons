package com.michaljanecek.persons.view

import com.michaljanecek.persons.service.PersonServiceImpl
import com.michaljanecek.persons.model.BirthNumber
import com.michaljanecek.persons.utils.PersonValidator
import java.util.*

class PersonUI(
    private val service: PersonServiceImpl,
    private val validator: PersonValidator
) {
    private val scanner = Scanner(System.`in`)

    companion object {
        const val MENU_PROMPT = "1. Add person\n2. Remove person\n3. Find person\n4. Exit"
        const val INVALID_OPTION_MESSAGE = "Invalid option. Please try again."
        const val ADD_SUCCESS_MESSAGE = "Person added successfully."
        const val REMOVE_SUCCESS_MESSAGE = "Person removed successfully."
        const val FIND_NOT_FOUND_MESSAGE = "Person not found."
        const val FIRST_NAME_PROMPT = "Enter first name:"
        const val LAST_NAME_PROMPT = "Enter last name:"
        const val BIRTH_NUMBER_PROMPT = "Enter birth number (YYMMDDXXXX or YYMMDD/XXXX):"
        const val FIRST_NAME_ERROR = "First name must not be empty."
        const val LAST_NAME_ERROR = "Last name must not be empty."
        const val BIRTH_NUMBER_ERROR = "Invalid birth number format."
        const val REMOVE_BIRTH_NUMBER_PROMPT = "Enter birth number of the person to remove:"
        const val FIND_BIRTH_NUMBER_PROMPT = "Enter birth number of the person to find:"
    }

    fun start() {
        while (true) {
            println(MENU_PROMPT)
            when (scanner.nextInt()) {
                1 -> addPersonFlow()
                2 -> removePersonFlow()
                3 -> findPersonFlow()
                4 -> {
                    println("Exiting...")
                    return
                }

                else -> println(INVALID_OPTION_MESSAGE)
            }
        }
    }

    private fun addPersonFlow() {
        scanner.nextLine()
        val firstName = getInput(FIRST_NAME_PROMPT, FIRST_NAME_ERROR) { validator.validateFirstName(it) }
        val lastName = getInput(LAST_NAME_PROMPT, LAST_NAME_ERROR) { validator.validateLastName(it) }
        val birthNumber =
            BirthNumber(getInput(BIRTH_NUMBER_PROMPT, BIRTH_NUMBER_ERROR) { validator.validateBirthNumber(it) })

        try {
            service.addPerson(firstName, lastName, birthNumber)
            println(ADD_SUCCESS_MESSAGE)
        } catch (e: IllegalArgumentException) {
            println("Error adding person: ${e.message}")
        }
    }

    private fun removePersonFlow() {
        scanner.nextLine()
        val birthNumber =
            BirthNumber(getInput(REMOVE_BIRTH_NUMBER_PROMPT, BIRTH_NUMBER_ERROR) { validator.validateBirthNumber(it) })
        try {
            service.removePerson(birthNumber)
            println(REMOVE_SUCCESS_MESSAGE)
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
        }
    }

    private fun findPersonFlow() {
        scanner.nextLine()
        val birthNumber =
            BirthNumber(getInput(FIND_BIRTH_NUMBER_PROMPT, BIRTH_NUMBER_ERROR) { validator.validateBirthNumber(it) })
        try {
            val person = service.findPerson(birthNumber)
            println("Found person:\n $person")
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
        }
    }

    private fun getInput(fieldName: String, errorMessage: String, validation: (String) -> Boolean): String {
        var isValid = false
        var input: String
        do {
            println(fieldName)
            input = scanner.nextLine()
            if (validation(input)) {
                isValid = true
            } else {
                println(errorMessage)
            }
        } while (!isValid)
        return input
    }
}
