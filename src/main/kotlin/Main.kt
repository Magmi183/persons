import data.PersonInMemoryDatabase
import data.PersonRepository
import service.PersonServiceImpl
import utils.PersonValidator
import view.PersonUI

fun main() {
    val repository: PersonRepository = PersonInMemoryDatabase()
    val validator = PersonValidator()
    val service = PersonServiceImpl(repository, validator)

    // Create the UI layer
    val personUI = PersonUI(service, validator)

    // Start the user interface
    personUI.start()
}