import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt() // 문제의 수
    val m = scanner.nextInt() // 정보의 개수
    val problemMap = HashMap<Int, MutableList<Int>>() // 문제 정보를 저장하는 맵
    val problemDegree = IntArray(n + 1) { 0 } // 각 문제의 진입 차수를 저장하는 배열
    
    for (i in 1..n) {
        problemMap[i] = ArrayList()
    }
    
    for (i in 0 until m) {
        val a = scanner.nextInt()
        val b = scanner.nextInt()
        problemMap[a]?.add(b)
        problemDegree[b]++
    }
    
    val priorityQueue = PriorityQueue<Int>() // 우선순위 큐
    val answerList = ArrayList<Int>() // 정답 리스트
    
    for (i in 1..n) {
        if (problemDegree[i] == 0) { // 진입 차수가 0인 문제를 우선순위 큐에 추가
            priorityQueue.offer(i)
        }
    }
    
    while (priorityQueue.isNotEmpty()) {
        val currentProblem = priorityQueue.poll()
        answerList.add(currentProblem)
        for (nextProblem in problemMap[currentProblem]!!) {
            problemDegree[nextProblem]--
            if (problemDegree[nextProblem] == 0) { // 진입 차수가 0이 되면 우선순위 큐에 추가
                priorityQueue.offer(nextProblem)
            }
        }
    }
    
    for (i in answerList) {
        print("$i ")
    }
}
