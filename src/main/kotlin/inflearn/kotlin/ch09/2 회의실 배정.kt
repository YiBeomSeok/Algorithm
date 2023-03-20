package inflearn.kotlin.ch09

import java.io.*
import java.util.*

class Conference(val start: Int, val end: Int): Comparable<Conference> {

    override fun compareTo(other: Conference): Int {
        return this.end - other.end
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val conferences = Array(n) {
        val st = StringTokenizer(br.readLine())
        Conference(st.nextToken().toInt(), st.nextToken().toInt())
    }.apply {
        sort()
    }

    var count = 1
    var end = conferences[0].end
    for(i in 1 until n) {
        if(conferences[i].start >= end) {
            end = conferences[i].end
            count++
        }
    }

    println(count)
}