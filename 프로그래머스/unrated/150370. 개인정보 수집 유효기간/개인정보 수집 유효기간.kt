import java.util.*

class Solution {
    data class Date(val year: Int, val month: Int, val day: Int)
    
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer = mutableListOf<Int>()
        
        val termMap = HashMap<String, Int>()
        terms.forEach {
            with(it.split(" ")) {
                termMap[this[0]] = this[1].toInt()
            }
        }
        
        val todaySplit = today.split(".")
        val todayDate = Date(todaySplit[0].toInt(), todaySplit[1].toInt(), todaySplit[2].toInt())

        for(i in privacies.indices) {
            val curSplit = privacies[i].split(".", " ")
            val curYear = curSplit[0].toInt()
            val curMonth = curSplit[1].toInt()
            val curDay = curSplit[2].toInt()
            val curTerm = curSplit[3]
            
            val duration = termMap[curTerm]!!
                        
            val tmp = (curMonth - 1) * 28 + curDay - 1 + duration * 28
            val expiredDate = Date(curYear + tmp / MAX_DAY, (tmp % MAX_DAY) / 28 + 1, (tmp % MAX_DAY) % 28 + 1)
            
            println("$expiredDate")
            
            if(expiredDate.year < todayDate.year) answer.add(i + 1)
            else if(expiredDate.year == todayDate.year) {
                if(expiredDate.month < todayDate.month) answer.add(i + 1)
                else if(expiredDate.month == todayDate.month && expiredDate.day <= todayDate.day) {
                    answer.add(i + 1)
                }
            }
        }
        
        
        return answer.toIntArray().apply{ sort() }
    }
    
    companion object {
        const val MAX_DAY = 28 * 12
    }
}