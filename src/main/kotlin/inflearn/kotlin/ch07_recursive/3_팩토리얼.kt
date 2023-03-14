package inflearn.kotlin.ch07_recursive

class FactorialConverter {
    fun dfs(n: Int): Int {
        return if(n == 1) return 1 else n * dfs(n - 1)
    }
}

fun main() {
    val fac = FactorialConverter()
    println(fac.dfs(5))
}