package inflearn2.kotlin.ch05.p5

import java.util.*

class Solution {
    fun solution(students: Array<String>): IntArray {
        val n = students.size
        val answer = IntArray(n)

        val mStudents = mutableListOf<Student>()
        for(i in students.indices) {
            val split = students[i].split(" ")
            mStudents.add(Student(i, split[0], split[1].toInt()))
        }

        mStudents.sort()

        var total = 0
        val teamDamageChecks = HashMap<String, Int>()

        var i = 1
        var j = 0
        while(i < n) {
            while(j < n && mStudents[j].damage < mStudents[i].damage) {
                total += mStudents[j].damage
                teamDamageChecks[mStudents[j].team] = teamDamageChecks.getOrDefault(mStudents[j].team, 0) + mStudents[j].damage
                j++
            }
            answer[mStudents[i].num] = total - teamDamageChecks.getOrDefault(mStudents[i].team, 0)
            i++
        }

        return answer
    }

    class Student(val num: Int, val team: String, val damage: Int) : Comparable<Student>{
        override fun compareTo(other: Student): Int {
            return this.damage - other.damage
        }
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(Arrays.toString(T.solution(arrayOf("a 20", "b 12", "a 10", "c 11", "e 12"))))
    println(Arrays.toString(T.solution(arrayOf("a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"))))
    println(Arrays.toString(T.solution(arrayOf("b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"))))
    println(Arrays.toString(T.solution(arrayOf("a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"))))
}