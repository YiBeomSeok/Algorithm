package inflearn.kotlin.ch09

import java.io.*
import java.util.*

class Finder(
    val n: Int,
    val m: Int,
    private val pairs: Array<IntArray>,
) {
    private val group = IntArray(n + 1) { it }

    init {
        for(i in 0 until m) {
            val first = pairs[i][0]
            val second = pairs[i][1]
            union(first, second)
        }
    }

    private fun find(f: Int): Int {
        return if (f == group[f]) f
        else {
            group[f] = find(group[f])
            return group[f]
        }
    }

    private fun union(f1: Int, f2: Int) {
        val find1 = find(f1)
        val find2 = find(f2)
        if(find1 != find2) group[find1] = find2
    }

    fun isFriend(f1: Int, f2: Int): Boolean {
        val find1 = find(f1)
        val find2 = find(f2)
        return find1 == find2
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer

    st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val pairs = Array(m) {
        st = StringTokenizer(br.readLine())
        intArrayOf(st.nextToken().toInt(), st.nextToken().toInt())
    }

    st = StringTokenizer(br.readLine())
    val f1 = st.nextToken().toInt()
    val f2 = st.nextToken().toInt()

    val finder = Finder(n, m, pairs)
    if (finder.isFriend(f1, f2))
        print("YES")
    else
        print("NO")
}