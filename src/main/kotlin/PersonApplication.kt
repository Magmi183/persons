

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import view.PersonUI

@SpringBootApplication
open class PersonApplication

fun main(args: Array<String>) {
    runApplication<PersonApplication>(*args)
}