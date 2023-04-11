class Solution {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer: Int = 0
        var totalPickCount = 0
        picks.forEach { totalPickCount += it }
        val canMineMinerals = if (totalPickCount * 5 < minerals.size) {
            minerals.dropLast(minerals.size - totalPickCount * 5).toTypedArray()
        } else minerals
        val infos = mutableListOf<IntArray>()

        var left = 0
        var right = 5
        loop@ while (true) {
            val info = IntArray(3)
            infos.add(info)

            while (left < right) {
                when (canMineMinerals[left]) {
                    "diamond" -> {
                        info[0] += 1
                        info[1] += 5
                        info[2] += 25
                    }

                    "iron" -> {
                        info[0] += 1
                        info[1] += 1
                        info[2] += 5
                    }

                    "stone" -> {
                        info[0] += 1
                        info[1] += 1
                        info[2] += 1
                    }
                }
                left++
                if (left == canMineMinerals.size)
                    break@loop
            }
            right += 5
        }

        infos.sortWith(compareByDescending<IntArray> { it[2] }.thenBy { it[1] }.thenBy { it[0] })

        infos.forEach {
            for (pickIndex in picks.indices) {
                if (picks[pickIndex] > 0) {
                    answer += it[pickIndex]
                    picks[pickIndex]--
                    break
                }
            }
        }

        return answer
    }
}