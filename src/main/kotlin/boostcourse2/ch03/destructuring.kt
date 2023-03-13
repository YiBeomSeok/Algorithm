package boostcourse2.ch03

data class Customer(var name: String, var email: String)

fun main() {
    val cus1 = Customer(name = "Beomseok", email = "vv99911@gmail.com")
    val (name, email) = cus1
    println("name = $name, email = $email")

    val cus2 = cus1.copy(name = "Alice")
    println(cus2.toString())
}