package model

import java.time.LocalDate

data class BirthNumber(val birthNumber: String) {

    private val normalized by lazy {
        normalize(birthNumber)
    }

    val birthDate: LocalDate by lazy {
        val year = normalized.substring(0, 2).toInt()
        val month = normalized.substring(2, 4).toInt()
        val day = normalized.substring(4, 6).toInt()

        // Handle the century assumption (e.g., '99' -> 1999, '01' -> 2001)
        val fullYear = if (year > LocalDate.now().year % 100) 1900 + year else 2000 + year

        LocalDate.of(fullYear, month, day)
    }

    // Helper function to normalize birth number by removing slashes
    private fun normalize(birthNumber: String): String {
        return birthNumber.replace("/", "")
    }

    override fun toString(): String {
        return normalized
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BirthNumber) return false

        return normalized == other.normalized
    }

    override fun hashCode(): Int {
        return normalized.hashCode()
    }
}
