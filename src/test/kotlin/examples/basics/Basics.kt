package examples.basics

val foo = "Fred"   // String type inferred, immutable

var bar = "Betty"  // String type inferred, mutable, non-nullable

var baz: String? = "Wilma" // String type, mutable, nullable

fun helloWorld1(s: String): Unit {
    println(s)
}

fun helloWorld2(s: String) = println(s)

fun add1(a: Int, b: Int): Int {
    return a + b
}

fun add2(a: Int, b: Int) = a + b  // return type of Int is inferred

fun renderGreeting1(friendly: Boolean): String {
    return if (friendly) {
        "Hello!"
    } else {
        "Go Away!"
    }
}

fun renderGreeting2(friendly: Boolean) = if (friendly) "Hello!" else "Go Away!"

fun calculateLastName(firstName: String): String {
    return when(firstName) {
        "Fred", "Wilma" -> "Flintstone"
        "Barney", "Betty" -> "Rubble"
        else -> { // can be a code block
            return "Unknown"
        }
    }
}

fun renderLifeStage1(age: Int): String {
    return when(age) {
        in 0..12 -> "Child"
        in 13..19 -> "Teenager"
        else -> "Adult"
    }
}

fun renderLifeStage2(age: Int): String {
    return when {
        age < 13 -> "Child"
        age in 13..19 -> "Teenager"
        else -> "Adult"
    }
}

object FearlessLeader {
    val firstName = "Gregg"
    val lastName = "Gallant"
}

class MyCalculator1 (val firstName: String, val lastName: String) {
    fun getFullName() = firstName + " " + lastName
}

interface Friendly {
    fun sayHello(): String

    fun isFriendly() = true
}

class MyCalculator2 (val firstName: String, val lastName: String) : Friendly {
    override fun sayHello(): String {
        return "Hi!  My name is " + fullName
    }

    val fullName: String
        get() = firstName + " " + lastName  // a "getter" in Kotlin
}

sealed class Animal(val name: String)
class Dog(name: String, val akcNumber: Int) : Animal(name)
class Cat(name: String, val cfaNumber: Int) : Animal(name)

fun speak(animal: Animal): String {
    return when (animal) {
        is Dog -> "Bark"
        is Cat -> "Meow"
    // no otherwise/else!
    }
}

fun Animal.speakex(): String {
    return when (this) {
        is Dog -> "Bark! My name is $name and my number is $akcNumber"
        is Cat -> "Meow! My name is $name and my number is $cfaNumber"
    }
}

var myDog = Dog("Bob Barker", 22)
var talk2 = speak(myDog)
var talk1 = myDog.speakex()


class Address(val line1: String, val line2: String? = null)
class Person(val name: String, val homeAddress: Address, val workAddress: Address? = null)

val bob = Person(homeAddress = Address("Main Street"), name = "Bob")
val bobsWorkAddress1: String? = bob.workAddress?.line2 // type can be inferred
val bobsWorkAddress2: String = bob.workAddress?.line2 ?: "" // type can be inferred

val bobString1 = "My name is ${bob.name}, my home address is ${bob.homeAddress.line1}"

val bobString2 = """|My name is "${bob.name}"
    |               |  My home address is ${bob.homeAddress.line1}"""
                 .trimMargin("|")


class BankAccount (var balance: Double = 0.0){
    operator fun plusAssign(amount: Double) {  // overloads +=
        balance += amount
    }

    infix fun deposit(amount: Double) {
        balance += amount
    }

    infix fun `!&%`(amount: Double) {
        balance -= amount
    }
}

val myAccount = BankAccount()

fun deposit(account: BankAccount, amount: Double) {
    account deposit amount
    account `!&%` 33.0
}

fun BankAccount.deposit2(amount: Double) {
    this += amount
}

fun getAString(person: Person?): String {
    return person?.workAddress?.line2?.trim() ?: ""
}

fun `👍`() = println("Fred")

fun tryIt() {
    `👍`()
}
