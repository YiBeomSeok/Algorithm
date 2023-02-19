package effective_kotlin

data class User(
    val name: String,
    val surname: String
) {
    fun withSurname(surname: String) = User(name, surname)
}

fun main() {
//    val user = User("Maja", "Ma")
//    user = user.withSurname("Moskala")  // But 이 방식은 매우 귀찮

    // 다음과 같은 방법 권장
    val user = User("Maja", "Ma")
    val another = user.copy(surname = "Moskala")
    print(another)
}