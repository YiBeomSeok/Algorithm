package coding_interview.bitmask

fun countPairs(n: Int, paired: Int): Int {
    // 기저 사례: 모든 사람이 짝을 이룬 경우
    if (paired == (1 shl n) - 1) {
        return 1
    }

    // 이미 짝이 있는 사람을 찾기 위해 사용
    var first = -1
    for (i in 0 until n) {
        if (paired and (1 shl i) == 0) {
            first = i
            break
        }
    }

    // 기저 사례: 모든 사람이 짝을 이룰 수 없는 경우
    if (first == -1) {
        return 0
    }

    var result = 0
    for (i in first + 1 until n) {
        // 짝이 없는 상태이고, i와 first가 짝이 될 수 있는 경우
        if (paired and (1 shl i) == 0) {
            // i와 first를 짝으로 만들고, 재귀 호출
            result += countPairs(n, paired or (1 shl i) or (1 shl first))
        }
    }
    return result
}

fun main() {
    val n = 4
    println(countPairs(n, 0)) // 출력: 3
}