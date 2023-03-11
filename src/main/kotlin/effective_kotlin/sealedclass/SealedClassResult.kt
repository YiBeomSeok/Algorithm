package effective_kotlin.sealedclass

sealed class Result<out T>
class Success<out T>(val result: T): Result<T>()
class Failure(val throwable: Throwable): Result<Nothing>()

// sealed class
sealed class Cat
class BlueCat : Cat()
class RedCat : Cat()
class GreenCat : Cat()
class WhiteCat : Cat()

fun main() {
    val cat: Cat = BlueCat()
    val result = when(cat) {
        is BlueCat -> "blue"
        is RedCat -> "red"
        is GreenCat -> "green"
        is WhiteCat -> "white"
    }

    println(result)
}