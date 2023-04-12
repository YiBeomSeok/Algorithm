import java.util.*
import kotlin.math.*

class Solution {
    class Point(val y: Int, val x: Int, val route: String)
    
    val dy = intArrayOf(-1, 0, 1, 0)
    val dx = intArrayOf(0, 1, 0, -1)
    val dc = arrayOf("u", "r", "d", "l")
    
    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        var answer: String = "z"
        
        val goalY = r - 1
        val goalX = c - 1
        
        if( (k - (abs(y - 1 - goalX) + abs(x - 1 - goalY))) % 2 == 1) return "impossible"
        
        val pq = PriorityQueue<Point>( compareBy<Point> { it.route }.thenByDescending { it.route.length })
        pq.offer(Point(x - 1, y - 1, ""))
        
        while(pq.isNotEmpty()) {
            val curPoint = pq.poll()
            
            if(curPoint.route.length == k) {
                if(curPoint.y == goalY && curPoint.x == goalX) {
                    return curPoint.route
                }
            } else {
                for(dir in 0 until 4) {
                    val nY = curPoint.y + dy[dir]
                    val nX = curPoint.x + dx[dir]
                        
                    if(nY in 0 until n && nX in 0 until m) {
                        val nRoute = "${curPoint.route}${dc[dir]}"
                        
                        if(nRoute.length > k) continue
                        if(abs(nX - goalX) + abs(nY - goalY) > k - nRoute.length) continue
                        
                        pq.offer(Point(nY, nX, nRoute))
                    }
                }
            }    
        }
        
        return "impossible"
    }
}