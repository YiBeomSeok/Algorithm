import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var N = br.readLine().toInt()
    var input = IntArray(N + 1)
    var index = IntArray(N + 1)
    var LIS = mutableListOf<Int>()

    val st = StringTokenizer(br.readLine())
    for (i in 1..N) {
        input[i] = st.nextToken().toInt()
    }

    if (N == 1) {
        bw.write("1\n${input[1]}")
        bw.flush()
        bw.close()
        br.close()
        return
    }

    LIS.add(input[1])
    index[1] = 0

    for (i in 2..N) {
        if (input[i] > LIS.last()) {
            LIS.add(input[i])
            index[i] = LIS.size - 1
        } else {
            binarySearch(i, LIS, input, index)
        }
    }

    val sb = StringBuilder()
    sb.append("${LIS.size}\n")
    val stack = Stack<Int>()
    var findId = LIS.size - 1
    for (i in N downTo 1) {
        if (index[i] == findId) {
            findId--
            stack.push(input[i])
        }
    }
    while (!stack.isEmpty()) {
        sb.append("${stack.pop()} ")
    }
    bw.write(sb.toString())

    bw.flush()
    bw.close()
    br.close()
}

fun binarySearch(id: Int, LIS: MutableList<Int>, input: IntArray, index: IntArray) {
    var start = 0
    var end = LIS.size - 1

    while (start < end) {
        val mid = (start + end) / 2
        if (LIS[mid] >= input[id]) {
            end = mid
        } else {
            start = mid + 1
        }
    }
    LIS[start] = input[id]
    index[id] = start
}
