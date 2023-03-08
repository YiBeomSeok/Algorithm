import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val input = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val sb = StringBuilder()
    for (anInt in solution(n, input)) {
        sb.append(anInt).append(" ")
    }
    print(sb)
}

fun solution(n: Int, intArray: IntArray): IntArray {
    val stack = Stack<Int>()
    val result = IntArray(n) { -1 }
    for (i in intArray.size - 1 downTo 0) {
        if (stack.empty()) {
            stack.push(intArray[i])
        } else {
            val top = stack.peek()

            if (intArray[i] >= top) {
                while (stack.isNotEmpty()) {
                    val nextLast = stack.pop()
                    if (intArray[i] < nextLast) {
                        result[i] = nextLast
                    }
                }
                stack.push(intArray[i])

            } else {
                result[i] = top
                stack.push(intArray[i])
            }
        }
    }
    return result
}
