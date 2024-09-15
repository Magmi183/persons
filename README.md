# Person Management Application

This is a simple Kotlin-based application that allows you to manage persons with birth numbers. 
It uses an in-memory database to store and manipulate person data.

## Architecture

The application is structured into several components:

- **Main.kt**: The entry point of the application.
- **Person.kt**: The data model representing a person with fields like first name, last name, and birth number.
- **BirthNumber.kt**: Represents a birth number, with additional logic.
- **PersonServiceImpl.kt**: Implements the business logic for adding, removing, and finding persons.
- **PersonRepository.kt**: Defines the contract for a repository handling person storage.
- **PersonInMemoryDatabase.kt**: An in-memory implementation of the `PersonRepository`.
- **PersonValidator.kt**: Contains validation logic for person details.
- **PersonUI.kt**: A simple UI class for representing the person data visually and interacting with the user.

