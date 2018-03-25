package examples.basics

import org.assertj.core.api.Assertions.*
import org.junit.Test

class `Lambda Tests` {

    @Test
    fun `crazy method name`() {
        val myAccount = BankAccount()

        myAccount deposit 22.00
        myAccount `!&%` 33.0

        assertThat(myAccount.balance).isEqualTo(-11.00)
    }

    @Test
    fun `simple lambda`() {
        val names = listOf("Fred", "Wilma", "Barney", "Betty")

        var str = names.filter({ s -> s.startsWith("B") })
                .joinToString(",")
        assertThat(str).isEqualTo("Barney,Betty")
    }

    @Test
    fun `lambda with it`() {
        val names = listOf("Fred", "Wilma", "Barney", "Betty")

        var str = names.filter({ it.startsWith("B") })
                .joinToString(",")
        assertThat(str).isEqualTo("Barney,Betty")
    }

    @Test
    fun `lambda pipeline`() {
        val names = listOf("Fred", "Wilma", "Barney", "Betty")

        var str = names.filter({ it.startsWith("B") })
                .map({ it.toUpperCase() })
                .joinToString(",")
        assertThat(str).isEqualTo("BARNEY,BETTY")
    }

    @Test
    fun `lambda combination functions`() {
        val names = listOf("Fred", "Wilma", "Barney", "Betty")

        var str = names.filter({ it.startsWith("B") })
                .joinToString(",", transform = { it.toUpperCase() })
        assertThat(str).isEqualTo("BARNEY,BETTY")
    }

    @Test
    fun `lambda outside parenthesis`() {
        val names = listOf("Fred", "Wilma", "Barney", "Betty")

        var str = names.filter { it.startsWith("B") }
                .map { it.toUpperCase() }
                .joinToString(",")
        assertThat(str).isEqualTo("BARNEY,BETTY")
    }

    @Test
    fun `method references`() {
        val names = listOf("Fred", "Wilma", "Barney", "Betty")

        var str = names.filter { it.startsWith("B") }
                .map(String::toUpperCase)
                .joinToString(",")
        assertThat(str).isEqualTo("BARNEY,BETTY")
    }

    @Test
    fun `function variables and local functions`() {
        val upperCase = { s: String -> s.toUpperCase() }
        fun String.startsWithB() = startsWith("B")

        val names = listOf("Fred", "Wilma", "Barney", "Betty")

        var str = names.filter { it.startsWithB() }
                .map { upperCase(it) }
                .joinToString(",")
        assertThat(str).isEqualTo("BARNEY,BETTY")
    }

    @Test
    fun `higher order functions`() {
        val names = listOf("Fred", "Wilma", "Barney", "Betty")

        var str = names.filter { it.startsWith("B") }
                .map(upperCaseIt())
                .joinToString(",")
        assertThat(str).isEqualTo("BARNEY,BETTY")
    }

    private fun upperCaseIt(): (String) -> String = { it.toUpperCase() }
    private fun upperCaseIt2() = { s: String -> s.toUpperCase() }  // using inferred type
}