package coding_interview.bitmask

fun countSwitches(n: Int, k: Int, state: Int): Int {
    var switches = 0
    var current = state

    for (i in 0 until n) {
        if (current and (1 shl i) == 0) { // 전구가 꺼져 있는 경우
            if (i + k > n) { // K개의 연속된 전구를 교체할 수 없는 경우
                return -1
            }
            switches++
            for (j in i until i + k) {
                current = current xor (1 shl j) // 전구의 상태를 바꿈
            }
        }
    }
    return switches
}

fun main() {
    val n = 5
    val k = 2
    val initialState = "01001".toInt(2) // 꺼진 상태를 나타내는 문자열을 정수로 변환

    println(countSwitches(n, k, initialState)) // 출력: 2
}