import java.util.*

class Solution {
    
    val courseMenu = HashMap<String, Int>()
    val newMenus = TreeSet<String>()
    lateinit var maxCount: IntArray
    
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        maxCount = IntArray(course.size)
        
        orders.forEach {
            val sb = StringBuilder()
            for(ch in it.toCharArray().sorted()) {
                sb.append(ch)
            }
            dfs(sb.toString(), "", 0, 0, course, 0)
        }
        
        courseMenu.forEach {
            for(i in course.indices) {
                if(it.key.length == course[i] && it.value == maxCount[i] && it.value > 1) newMenus.add(it.key)
            }
        }
        
        return newMenus.toTypedArray().apply { sort() }
    }
    
    private fun dfs(originOrder: String, curOrder: String, start: Int, depth: Int, course: IntArray, offset: Int) {
        if(course[offset] > originOrder.length) return
        
        var nextOffset = offset
        
        if(depth == course[offset]) {
            nextOffset++
            with(courseMenu.getOrDefault(curOrder, 0) + 1) {
                maxCount[offset] = maxOf(maxCount[offset], this)
                courseMenu[curOrder] = this
            }
            
            if(nextOffset == course.size) return
        }
       
        for(i in start until originOrder.length) {
            dfs(originOrder, "$curOrder${originOrder[i]}", i + 1, depth + 1, course, nextOffset)
        }
    }
}