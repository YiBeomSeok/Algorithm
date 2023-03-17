package inflearn.kotlin.ch08

import java.io.*
import java.util.*

/**
 * 추측하지 못 해서 푼 방식
 */
class Solution8 {

    lateinit var permutation: IntArray
    lateinit var check: Array<Boolean>
    lateinit var permutationAnswer: IntArray

    var find = false

    fun solution(n: Int, f: Int): IntArray {

        permutation = IntArray(n) { 0 }
        permutationAnswer = IntArray( n ) { 0 }
        check = Array(n + 1) { false }

        dfs(n, f, 0)

        return permutationAnswer
    }

    fun dfs(n: Int, f: Int, depth: Int) {
        if(find) return

        if(depth == n) {
            if(calculate() == f) {
                permutationAnswer = permutation.clone()
                find = true
            }
        } else {
            for(i in 1 .. n) {
                if(check[i]) continue

                permutation[depth] = i
                check[i] = true
                dfs(n, f, depth + 1)
                check[i] = false
            }
        }
    }

    private fun calculate(): Int {
        val deque = ArrayDeque<Int>()
        for(num in permutation) {
            deque.addLast(num)
        }

        while(deque.size > 1) {
            val amount = deque.size
            for(i in 0 until amount) {
                val first = deque.removeFirst()
                if(i < amount - 1) {
                    deque.addLast(first + deque.peekFirst())
                }
            }
        }

        return deque.first()
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val f = st.nextToken().toInt()

    val sol = Solution8()

    val ans = sol.solution(n, f)

    for(a in ans) {
        print("$a ")
    }
}