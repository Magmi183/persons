package com.michaljanecek.osoby.controller

import com.michaljanecek.osoby.com.michaljanecek.osoby.controller.PersonRequest
import com.michaljanecek.osoby.com.michaljanecek.osoby.controller.PersonResponse
import com.michaljanecek.osoby.model.BirthNumber
import com.michaljanecek.osoby.service.PersonServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/person")
class PersonController(
    private val personService: PersonServiceImpl
) {

    // Get all persons
    @GetMapping
    fun getAllPersons(): ResponseEntity<List<PersonResponse>> {
        val persons = personService.getAllPersons()
        val personResponses = persons.map {
            PersonResponse(it.firstName, it.lastName, it.birthNumber.toString(), it.age)
        }
        return ResponseEntity.ok(personResponses)
    }

    // Add a new person
    @PostMapping
    fun addPerson(@RequestBody personRequest: PersonRequest): ResponseEntity<String> {
        val added = personService.addPerson(
            personRequest.firstName,
            personRequest.lastName,
            BirthNumber(personRequest.birthNumber)
        )

        return if (added) {
            ResponseEntity.status(HttpStatus.CREATED).body("Person added successfully.")
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Person with birth number already exists.")
        }
    }

    // Find a person by birth number
    @GetMapping("/{birthNumber}")
    fun findPerson(@PathVariable birthNumber: String): ResponseEntity<String> {
        val person = personService.findPerson(BirthNumber(birthNumber))
        return if (person != null) {
            ResponseEntity.ok("Person found: ${person.firstName} ${person.lastName}")
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found.")
        }
    }

    // Remove a person by birth number
    @DeleteMapping("/{birthNumber}")
    fun removePerson(@PathVariable birthNumber: String): ResponseEntity<String> {
        val removed = personService.removePerson(BirthNumber(birthNumber))
        return if (removed) {
            ResponseEntity.ok("Person removed successfully.")
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found.")
        }
    }
}
