package inflearn.kotlin.ch01

object `1_12 암호` {
    fun solution(n: Int, s: String): String? {
        val answer = StringBuilder()

        var str = s.map { if(it == '#') '1' else '0' }.joinToString("")
        while (str.isNotEmpty()) {
            val now = str.substring(0, 7)
            str = str.substring(7)
            val ch = now.toInt(2).toChar()
            answer.append(ch)
        }
        return answer.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val n = readln().toInt()
        val s = readln()
        println(solution(n, s))
    }
}