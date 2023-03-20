package inflearn.kotlin.ch09

import java.io.*
import java.util.*

class Time(val time: Int, var state: Char) : Comparable<Time> {
    override fun compareTo(other: Time): Int {
        if(this.time == other.time) {
            return this.state - other.state
        }
        return this.time - other.time
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val schedules = mutableListOf<Time>()
    repeat(n) {
        val st = StringTokenizer(br.readLine())
        schedules.add(Time(st.nextToken().toInt(), 's'))
        schedules.add(Time(st.nextToken().toInt(), 'e'))
    }
    schedules.sort()

    var cnt = 0
    var answer = 0
    schedules.forEach {
        if(it.state == 's') {
            cnt++
            if(cnt > answer) answer = cnt
        }
        else if(it.state == 'e') {
            cnt--
        }
    }

    print(answer)
}