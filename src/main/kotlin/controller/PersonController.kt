package controller

import model.BirthNumber
import model.Person
import org.springframework.http.ResponseEntity
import service.PersonServiceImpl
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/person")
class PersonController(
    private val personService: PersonServiceImpl
) {

    @GetMapping
    fun getAllPersons(): ResponseEntity<List<PersonResponse>> {
        val persons = personService.getAllPersons()
        val personResponses = persons.map {
            PersonResponse(it.firstName, it.lastName, it.birthNumber.toString())
        }
        return ResponseEntity.ok(personResponses)
    }

    @PostMapping
    fun addPerson(@RequestBody personRequest: PersonRequest): String {
        personService.addPerson(personRequest.firstName, personRequest.lastName, BirthNumber(personRequest.birthNumber))
        return "Person added successfully."
    }

    @GetMapping("/{birthNumber}")
    fun findPerson(@PathVariable birthNumber: String): PersonResponse? {
        val person = personService.findPerson(BirthNumber(birthNumber))
        return person?.let { PersonResponse(it.firstName, it.lastName, it.birthNumber.toString()) }
    }

    @DeleteMapping("/{birthNumber}")
    fun removePerson(@PathVariable birthNumber: String): String {
        personService.removePerson(BirthNumber(birthNumber))
        return "Person removed successfully."
    }
}
