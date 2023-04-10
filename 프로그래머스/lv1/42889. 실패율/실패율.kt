class Stage(val number: Int, var fail: Int, var success: Int) {
    val rate: Float
    get() = if(fail + success == 0) 0.0f else fail.toFloat() / (fail.toFloat() + success.toFloat())
}

class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = intArrayOf()
        
        val allStage = Array(N) { Stage(it + 1, 0, 0) }
        
        stages.forEach {
            for(i in 0 until it - 1) {
                allStage[i].success++
            }
            if(it <= N) {
                allStage[it - 1].fail++
            }
        }
        
        return allStage.sortedByDescending { it.rate }.map { it.number }.toIntArray()
    }
}