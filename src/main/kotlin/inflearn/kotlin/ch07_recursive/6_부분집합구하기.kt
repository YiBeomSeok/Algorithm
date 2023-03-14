package inflearn.kotlin.ch07_recursive

class SubsetFinder(val n: Int) {
    val check = IntArray(n.plus(1)) { 0 }

    fun dfs(l: Int) { // l = Level
        if (l == n.plus(1)) {
            val builder = StringBuilder()
            for(i in 1 .. n) {
                if(check[i] != 0) builder.append("$i ")
            }
            if(builder.isNotEmpty()) println(builder)
        } else {
            check[l] = 1
            dfs(l.inc())    // 사용 한다
            check[l] = 0
            dfs(l.inc())    // 사용 안 한다
        }
    }
}

fun main() {
    val finder = SubsetFinder(3)
    finder.dfs(1)
}