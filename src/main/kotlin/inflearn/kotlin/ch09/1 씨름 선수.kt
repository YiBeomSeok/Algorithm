package inflearn.kotlin.ch09

import java.io.*
import java.util.*

class Register(val height: Int, val weight: Int) : Comparable<Register> {

    override fun compareTo(other: Register): Int {
        return other.height - this.height
    }
}

class Solution1(val n: Int, val registers: List<List<Int>>){
    fun solve(): Int {
        var answer = 0

        val sorted = mutableListOf<Register>()
        registers.forEach {
            sorted.add(Register(it[0], it[1]))
        }
        sorted.sort()

        var max = sorted[0].weight
        sorted.forEach {
            if(it.weight > max) {
                max = it.weight
                answer++
            }
        }
        return sorted.size
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val registers = List(n) { _ ->
        br.readLine().split(" ").map{ it.toInt() }
    }

    print(Solution1(n, registers).solve())
}
