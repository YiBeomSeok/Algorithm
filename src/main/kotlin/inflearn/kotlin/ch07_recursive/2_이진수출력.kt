package inflearn.kotlin.ch07_recursive

class ConverterToBin {
    fun dfs(n: Int) {
        if (n == 0) return
        else {
            dfs(n / 2)
            print("${n%2} ")
        }
    }
}

fun main() {
    val converter = ConverterToBin()

    converter.dfs(11)
}