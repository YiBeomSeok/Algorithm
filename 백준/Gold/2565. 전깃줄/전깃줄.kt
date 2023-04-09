import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt() // 전깃줄의 개수
    val lines = Array(n) { IntArray(2) } // 전깃줄 정보를 저장하는 배열
    
    for (i in 0 until n) {
        lines[i][0] = scanner.nextInt() // A 전봇대 위치
        lines[i][1] = scanner.nextInt() // B 전봇대 위치
    }
    
    Arrays.sort(lines, compareBy { it[0] }) // A 전봇대 위치를 기준으로 오름차순 정렬
    
    val lis = IntArray(n) { 1 } // LIS 배열 초기화
    for (i in 1 until n) {
        for (j in 0 until i) {
            if (lines[i][1] > lines[j][1]) { // B 전봇대 위치가 증가하는 경우
                lis[i] = maxOf(lis[i], lis[j] + 1) // LIS 값 갱신
            }
        }
    }
    
    println(n - lis.max()!!) // 제거할 전깃줄의 최소 개수 출력
}
