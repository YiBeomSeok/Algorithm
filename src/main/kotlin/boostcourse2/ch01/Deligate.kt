package boostcourse2.ch01

import kotlin.properties.Delegates

class User {
    var name: String by Delegates.observable("Noname") {
        property, oldValue, newValue ->
        println("prop: $property old: $oldValue, new: $newValue")
    }
}

fun main() {
    val user = User()

    user.name = "Kildong"
    user.name = "Dooly"

    var max: Int by Delegates.vetoable(0) {
        property, oldValue, newValue ->
        newValue > oldValue
    }

    println(max)
    max = 10
    println(max)

    // 이제 기존 값이 새 값보다 크므로 false
    // 따라서 5는 재할당하지 않는다.
    max = 5
    println(max) // 10
}