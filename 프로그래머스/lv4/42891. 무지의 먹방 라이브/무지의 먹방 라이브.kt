class Solution {
    fun solution(food_times: IntArray, k: Long): Int {
        val sortedTimes = food_times.copyOf(food_times.size + 1).apply { sort() }
        
        var rest = food_times.size
        var totalTime = k
        
        for (i in 1 until sortedTimes.size) {
            val time = rest.toLong() * (sortedTimes[i] - sortedTimes[i - 1]).toLong()
            if (totalTime < time) {
                val idx = totalTime % rest
                var cnt = 0L
                for (j in food_times.indices) {
                    if (food_times[j] >= sortedTimes[i]) {
                        if (cnt == idx) return j + 1
                        cnt++
                    }
                }
            } else {
                totalTime -= time
                rest--
            }
        }

        return -1
    }
}