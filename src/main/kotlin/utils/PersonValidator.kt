package utils


class PersonValidator {

    fun validateFirstName(firstName: String): Boolean {
        return firstName.isNotEmpty()
    }

    fun validateLastName(lastName: String): Boolean {
        return lastName.isNotEmpty()
    }

    // Method to validate the birth number format (YYMMDDXXXX or YYMMDD/XXXX)
    fun validateBirthNumber(birthNumber: String): Boolean {
        return birthNumber.matches(Regex("^\\d{6}/?\\d{4}$"))
    }

}
