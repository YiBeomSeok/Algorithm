package programmers

class Solution148653 {
    var calCount = 0
    private var origin: Int = 0

    fun solution(storey: Int): Int {
        origin = storey

        while (origin != 0) {
            val now = origin % 10
            origin /= 10
            if (validateCase1(now) || validateCase2(now, origin)) {
                origin += 1
                processB(now)
            } else
                processA(now)
        }
        return calCount
    }

    private fun validateCase1(now: Int): Boolean {
        if (isUpperThan(now, STANDARD))
            return true
        return false
    }

    private fun validateCase2(now: Int, origin: Int): Boolean {
        if (now == 5 && origin % 10 >= 5) return true
        return false
    }

    private fun isUpperThan(anInt: Int, other: Int): Boolean {
        if (anInt >= other) return true
        return false
    }

    private fun processA(anInt: Int) {
        var now = anInt
        while (now != 0) {
            now -= 1
            calCount += 1
        }
    }

    private fun processB(anInt: Int) {
        var now = anInt
        while (now != 10) {
            now += 1
            calCount += 1
        }
    }

    companion object {
        const val STANDARD = 6
    }
}

fun main() {
    for (i in 0..9999) {
        val s = Solution148653()
        s.solution(i)
        println("storey = $i, result = ${s.calCount}")
    }
}