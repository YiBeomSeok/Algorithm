import kotlin.math.pow

class Solution {

    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
        val answer = IntArray(balls.size)

        val border = Point(m, n)
        val start = Point(startX, startY)

        for (i in balls.indices) {
            val ball = balls[i]

            val transBall = symmetricTransposition(border, start, Point(ball[0], ball[1]))

            var minDistance = Int.MAX_VALUE
            for (point in transBall) {
                val dis = calculationDistance(start, point)

                minDistance = minOf(minDistance, dis)
            }

            answer[i] = minDistance
        }

        return answer
    }

    private fun symmetricTransposition(bord: Point, start: Point, ball: Point): List<Point> {
        val syms = mutableListOf<Point>()

        // 4 개의 방향으로 대칭이동
        // 선 대칭일 때, 벽보다 공에 먼저 맞는 경우 제외
        if (!(start.x == ball.x && start.y > ball.y)) syms.add(Point(ball.x, ball.y * -1))
        if (!(start.x == ball.x && start.y < ball.y)) syms.add(Point(ball.x, bord.y + (bord.y - ball.y)))
        if (!(start.y == ball.y && start.x < ball.x)) syms.add(Point(bord.x + (bord.x - ball.x), ball.y))
        if (!(start.y == ball.y && start.x > ball.x)) syms.add(Point(ball.x * -1, ball.y))

        return syms
    }

    private fun calculationDistance(start: Point, ball: Point): Int {
        val bigX = maxOf(start.x, ball.x)
        val smallX = minOf(start.x, ball.x)
        val bigY = maxOf(start.y, ball.y)
        val smallY = minOf(start.y, ball.y)

        return ((bigX - smallX).toDouble().pow(2) + (bigY - smallY).toDouble().pow(2)).toInt()
    }

    private data class Point(val x: Int, val y: Int)
}
