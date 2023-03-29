class Solution {
    fun solution(fruit: Array<IntArray>): Int {
        var answer = 0
        val n = fruit.size
        val check = IntArray(n)

        for (i in 0 until n) {
            if(check[i] == 1) continue

            // i의 최소 과일이 무엇인지 확인
            //
            // i의 최소값이 1개인지 확인
            var iMinIndex = 0
            for(iSub in 1 until 3) {
                if(fruit[i][iSub] < fruit[i][iMinIndex]) {
                    iMinIndex = iSub
                }
            }
            var isUnique = 0
            for(iSub in 0 until 3) {
                if(fruit[i][iSub] == fruit[i][iMinIndex]) {
                    isUnique++
                }
            }
            if(isUnique > 1) {
                answer += fruit[i][iMinIndex]
                check[i]++
                continue
            }

            for (j in i + 1 until n) {
                if(check[j] == 1) continue
                if(check[i] == 1) break

                // j의 최소 과일이 무엇인지 확인
                //
                // j의 최소값이 1개인지 확인
                var jMinIndex = 0
                for(jSub in 1 until 3) {
                    if(fruit[j][jSub] < fruit[j][jMinIndex]) {
                        jMinIndex = jSub
                    }
                }
                isUnique = 0
                for(jSub in 0 until 3) {
                    if(fruit[j][jSub] == fruit[j][jMinIndex]) {
                        isUnique++
                    }
                }
                if(isUnique > 1) {
                    answer += fruit[j][jMinIndex]
                    check[j]++
                    continue
                }

                // i의 최소 과일과 j의 최소 과일이 다른지 확인
                if(iMinIndex == jMinIndex) continue

                // 교환 해보기
                fruit[i][jMinIndex]--
                fruit[i][iMinIndex]++
                fruit[j][iMinIndex]--
                fruit[j][jMinIndex]++

                // 교환 후
                // i의 현재 최소값을 확인해서 원래 최소값보다 증가했는지 확인
                // j의 현재 최소값을 확인해서 원래 최소값보다 증가했는지 확인
                if(fruit[i][jMinIndex] < fruit[i][iMinIndex] ||
                    fruit[j][iMinIndex] < fruit[j][jMinIndex]) {
                    fruit[i][jMinIndex]++
                    fruit[i][iMinIndex]--
                    fruit[j][iMinIndex]++
                    fruit[j][jMinIndex]--

                    continue
                }

                answer += fruit[i][iMinIndex] + fruit[j][jMinIndex]
                check[i] = 1
                check[j] = 1
            }

            if(check[i] == 0) {
                answer += fruit[i][iMinIndex]
            }
            check[i] = 1
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf(
                intArrayOf(10, 20, 30),
                intArrayOf(12, 15, 20),
                intArrayOf(20, 12, 15),
                intArrayOf(15, 20, 10),
                intArrayOf(10, 15, 10)
            )
        )
    )
    println(T.solution(arrayOf(intArrayOf(10, 9, 11), intArrayOf(15, 20, 25))))
    println(
        T.solution(
            arrayOf(
                intArrayOf(0, 3, 27),
                intArrayOf(20, 5, 5),
                intArrayOf(19, 5, 6),
                intArrayOf(10, 10, 10),
                intArrayOf(15, 10, 5),
                intArrayOf(3, 7, 20)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(3, 7, 20),
                intArrayOf(10, 15, 5),
                intArrayOf(19, 5, 6),
                intArrayOf(10, 10, 10),
                intArrayOf(15, 10, 5),
                intArrayOf(3, 7, 20),
                intArrayOf(12, 12, 6),
                intArrayOf(10, 20, 0),
                intArrayOf(5, 10, 15)
            )
        )
    )
}