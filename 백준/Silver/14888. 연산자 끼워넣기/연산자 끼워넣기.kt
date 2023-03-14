import java.io.*

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()
    val permutation = reader.readLine().split(" ").map { it.toInt() }
    val operators = reader.readLine().split(" ").map { it.toInt() }

    val finder = Finder()
    finder.dfs(n, permutation.toIntArray(), operators.toIntArray(), 0)
    println(finder.max)
    println(finder.min)
}

class Finder {
    val expression = StringBuilder()
    val ops = charArrayOf('+', '-', '*', '/')
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE

    fun dfs(n: Int, permutation: IntArray, operators: IntArray, depth: Int) {
        if (depth == n - 1) {
            with(calculate(permutation, expression.toString())) {
                if(this > max) max = this
                if(this < min) min = this
            }
        } else {
            for (i in 0 until 4) {
                if (operators[i] > 0) {
                    expression.append(ops[i])
                    operators[i]--

                    dfs(n, permutation, operators, depth + 1)

                    expression.setLength(expression.length - 1)
                    operators[i]++
                }
            }
        }
    }

    private fun calculate(permutation: IntArray, expression: String): Int {
        var result = permutation[0]
        for (i in 0 until expression.length) {
            when (expression[i]) {
                '+' -> result += permutation[i + 1]
                '-' -> result -= permutation[i + 1]
                '/' -> result /= permutation[i + 1]
                '*' -> result *= permutation[i + 1]
            }
        }
        return result
    }
}