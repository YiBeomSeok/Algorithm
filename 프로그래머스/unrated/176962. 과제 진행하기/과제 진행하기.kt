import java.util.*

class Subject(val name: String, var time: Int)

class Solution {
    fun solution(plans: Array<Array<String>>): Array<String> {
        val answer = mutableListOf<String>()
        var count = 0
        
        
        plans.sortBy { it[1] }
        
        val stack = Stack<Subject>()
        var prev = plans[0]
        for(i in 1 until plans.size) {
            val prevStartTime = getMinute(prev[1])
            val prevEndTime = prevStartTime + prev[2].toInt()
            
            val cur = plans[i]
            val curStartTime = getMinute(cur[1])
            
            var diff = curStartTime - prevEndTime
            if(diff >= 0) {
                answer.add(prev[0])
                
                while(stack.isNotEmpty()) {
                    val pausedSubject = stack.pop()
                    if(pausedSubject.time >= diff) {
                        pausedSubject.time -= diff
                        diff = 0
                        if(pausedSubject.time > 0)
                            stack.push(pausedSubject)
                        else
                            answer.add(pausedSubject.name)
                        
                        break
                    } else {
                        diff -= pausedSubject.time
                        answer.add(pausedSubject.name)
                    }
                }
            } else {
                stack.push(Subject(prev[0], -diff))
            }
            
            prev = cur
        }
        answer.add(prev[0])
        
        while(stack.isNotEmpty()) {
            answer.add(stack.pop().name)
        }
        
        return answer.toTypedArray()
    }
    
    private fun getMinute(t: String): Int {
        val hm = t.split(":").map { it.toInt() }
        
        return hm[0] * 60 + hm[1]
    }
}