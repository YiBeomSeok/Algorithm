import java.io.*
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
var answer = 0

fun main() {
    val check = IntArray(27) { 0 }
    check[0] = 1
    check['n' - 'a'] = 1
    check['t' - 'a'] = 1
    check['i' - 'a'] = 1
    check['c' - 'a'] = 1

    val split = br.readLine().split(" ")
    val n = split[0].toInt()
    val k = split[1].toInt()

    val words = Array(n) {
        val word = br.readLine()
        word.substring(3, word.length - 4)
    }

    if(k < 5) {
        println(0)
        return
    } else if(k == 26) {
        println(n)
        return
    }

    dfs(words, check, 0, 0, k)

    print(answer)
}

fun dfs(words: Array<String>, check: IntArray, start: Int, depth: Int, k: Int) {
    if(depth == k - 5) {
        var count = 0
        words.forEach { value ->
            var tmp = 0
            for(ch in value) {
                if(check[ch - 'a'] == 0) {
                    tmp++
                    break
                }
            }
            if(tmp == 0) {
                count++
            }
        }
        answer = maxOf(answer, count)
    } else {
        for(i in start until 26) {
            if(check[i] != 1) {
                check[i] = 1
                dfs(words, check, i + 1, depth + 1, k)
                check[i] = 0
            }
        }
    }
}