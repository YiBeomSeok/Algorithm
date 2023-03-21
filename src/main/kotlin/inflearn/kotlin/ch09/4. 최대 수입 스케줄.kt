package inflearn.kotlin.ch09

import java.io.*
import java.util.*

class Lecture(val fee: Int, val deadline: Int): Comparable<Lecture> {

    override fun compareTo(other: Lecture): Int {
        return other.deadline - this.deadline
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val offers = Array<Lecture>(n) {
        val st = StringTokenizer(br.readLine())
        Lecture(st.nextToken().toInt(), st.nextToken().toInt())
    }

    offers.sort()

    val maxDeadline = offers[0].deadline
    var answer = 0
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    var j = 0
    for(i in maxDeadline downTo 1) {
        while(j < n) {
            if(offers[j].deadline < i) break
            pq.offer(offers[j].fee)
            j++
        }
        if(pq.isNotEmpty()) answer += pq.poll()
    }
    println(answer)
}