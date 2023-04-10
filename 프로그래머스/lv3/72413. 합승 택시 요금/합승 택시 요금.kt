class Solution {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        val INF = Int.MAX_VALUE / 3 - 1

        // 인접 행렬 초기화
        val dist = Array(n + 1) { IntArray(n + 1) { INF } }
        for (i in 1..n) {
            dist[i][i] = 0
        }
        fares.forEach { (u, v, w) ->
            dist[u][v] = w
            dist[v][u] = w
        }

        // 플로이드-와샬 알고리즘
        for (k in 1..n) {
            for (i in 1..n) {
                for (j in 1..n) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j]
                    }
                }
            }
        }

        // 출발점에서 A, B 지점으로 따로 갈 때의 요금
        var answer = dist[s][a] + dist[s][b]

        // 출발점에서 중간 지점을 거쳐 A, B 지점으로 같이 갈 때의 요금
        for (i in 1..n) {
            answer = minOf(answer, dist[s][i] + dist[i][a] + dist[i][b])
        }

        return answer
    }
}