package inflearn.kotlin.ch07_recursive

class Fib {
    private val memo = IntArray(101) { -1 }.apply { this[0] = 0 }
    fun dfs(n: Int): Int {
        return when (n) {
            1 -> 1
            2 -> 1
            else -> {
                val lt = if (memo[n - 2] != 0) memo[n - 2] else dfs(n - 2)
                val rt = if (memo[n - 1] != 0) memo[n - 1] else dfs(n - 1)
                lt + rt
            }
        }
    }
}

class Fib2 {
    private val memo = IntArray(101) { -1 }.apply { this[0] = 0 }
    fun dfs(n: Int): Int {
        return if (memo[n] > 0) {
            memo[n]
        } else if (n == 1) {
            1
        } else if (n == 2) {
            1
        } else dfs(n - 2) + dfs(n - 1)
    }
}

fun main() {
    val fib = Fib()
    val n = 45
    for (i in 1..n) {
        print("${fib.dfs(i)} ")
    }
}