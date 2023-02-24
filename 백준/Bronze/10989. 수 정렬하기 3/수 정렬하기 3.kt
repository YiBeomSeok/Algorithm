import java.io.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = IntArray(n)
    var i = 0
    while (i < n) {
        val line = br.readLine()
        if (line != null) {
            list[i] = line.toInt()
            i++
        }
    }
    list.sort()
    val sb = StringBuilder()

    for (i in 0 until n) {
        sb.append(list[i]).append('\n')
    }
    print(sb)
}
