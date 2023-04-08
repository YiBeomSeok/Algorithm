import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt() // 보석의 개수
    val k = scanner.nextInt() // 가방의 개수
    val jewelries = mutableListOf<Pair<Int, Int>>() // 보석 정보를 저장하는 리스트
    val bags = mutableListOf<Int>() // 가방 정보를 저장하는 리스트

    for (i in 0 until n) {
        jewelries.add(Pair(scanner.nextInt(), scanner.nextInt()))
    }

    for (i in 0 until k) {
        bags.add(scanner.nextInt())
    }

    jewelries.sortBy { it.first }
    bags.sort() // 가방을 오름차순 정렬

    var answer = 0L // 결과값을 저장하는 변수
    var index = 0 // 보석을 가리키는 인덱스
    val priorityQueue = PriorityQueue<Int>() // 가방에 넣을 수 있는 보석을 저장하는 우선순위 큐

    for (i in 0 until k) {
        while (index < n && jewelries[index].first <= bags[i]) { // 현재 가방에 넣을 수 있는 보석을 모두 우선순위 큐에 추가
            priorityQueue.offer(-jewelries[index].second)
            index++
        }
        if (priorityQueue.isNotEmpty()) { // 가방에 넣을 수 있는 가치가 가장 높은 보석을 꺼내서 결과값에 추가
            answer += -priorityQueue.poll().toLong()
        }
    }

    println(answer)
}
