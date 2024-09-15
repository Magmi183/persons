package com.michaljanecek.osoby


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
open class PersonApplication

fun main(args: Array<String>) {
    runApplication<PersonApplication>(*args)
}