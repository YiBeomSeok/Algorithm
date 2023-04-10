class Stage(val number: Int, var fail: Int, var success: Int, var rate: Double)

class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = intArrayOf()
        
        val allStage = Array(N) { Stage(it + 1, 0, 0, 0.0) }
        
        stages.forEach {
            for(i in 0 until it - 1) {
                allStage[i].success++
            }
            if(it <= N) {
                allStage[it - 1].fail++
            }
        }
        
        allStage.forEach { 
            val tryCount = it.fail + it.success
            it.rate = if(tryCount == 0) 0.0 else it.fail.toDouble() / tryCount.toDouble()
        }
        answer = allStage.sortedByDescending { it.rate }.map { it.number }.toIntArray()
        
        return answer
    }
}