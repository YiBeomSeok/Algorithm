import java.util.*

val MAX = 3 // 추가할 가로선의 최대 개수
var N = 0
var M = 0
var H = 0
var ladder = Array(31) { IntArray(11) } // 사다리 정보 저장 배열

fun main() {
    val scanner = Scanner(System.`in`)
    N = scanner.nextInt() // 세로선 개수
    M = scanner.nextInt() // 가로선 개수
    H = scanner.nextInt() // 가로선을 놓을 수 있는 위치 개수
    
    repeat(M) {
        val a = scanner.nextInt()
        val b = scanner.nextInt()
        ladder[a][b] = 1 // 가로선 정보 입력
    }
    
    for (i in 0..MAX) {
        if (findLadder(i, 1, 0)) {
            println(i)
            return
        }
    }
    println(-1)
}

fun findLadder(target: Int, row: Int, count: Int): Boolean {
    if (target == count) { // 목표 개수만큼 가로선을 추가했을 경우
        return isLadderComplete() // 사다리 게임이 모두 성립하는지 검사
    }
    
    for (i in row..H) {
        for (j in 1 until N) {
            if (ladder[i][j] == 0 && ladder[i][j - 1] == 0 && ladder[i][j + 1] == 0) {
                // 가로선을 추가할 수 있는 경우
                ladder[i][j] = 1
                if (findLadder(target, i, count + 1)) { // 가로선을 추가한 경우가 성공할 경우
                    return true
                }
                ladder[i][j] = 0 // 가로선을 추가하지 않은 경우
            }
        }
    }
    return false
}

fun isLadderComplete(): Boolean {
    for (i in 1..N) {
        var current = i
        for (j in 1..H) {
            if (ladder[j][current] == 1) { // 현재 칸에서 가로선이 오른쪽으로 이어지는 경우
                current += 1
            } else if (ladder[j][current - 1] == 1) { // 현재 칸에서 가로선이 왼쪽으로 이어지는 경우
                current -= 1
            }
        }
        if (current != i) { // 현재 칸이 i가 아닌 경우, 사다리 조작 실패
            return false
        }
    }
    return true // 모든 세로선이 자기 자신으로 이어져 있는 경우, 사다리 조작 성공
}
