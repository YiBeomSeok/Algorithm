import java.util.*
import kotlin.Comparator

var maxSum = 0
val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
val dy = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)

data class Shark(var x: Int, var y: Int, var dir: Int, var eatSum: Int)
data class Fish(var x: Int, var y: Int, val id: Int, var dir: Int, var isAlive: Boolean)

fun main() {
    val br = System.`in`.bufferedReader()

    val arr = Array(4) { IntArray(4) }
    val fishes = mutableListOf<Fish>()

    // input
    repeat(4) { i ->
        val st = StringTokenizer(br.readLine())
        repeat(4) { j ->
            val id = st.nextToken().toInt()
            val dir = st.nextToken().toInt() - 1
            fishes.add(Fish(i, j, id, dir, true))
            arr[i][j] = id
        }
    }

    // 물고기는 작은 순서부터 이동해야 하기 때문에 미리 정렬해둠
    fishes.sortWith(Comparator { o1, o2 -> o1.id - o2.id })

    // 상어는 (0, 0) 물고기를 먹고 시작하며 위치는 -1 로 표현
    val f = fishes[arr[0][0] - 1]
    val shark = Shark(0, 0, f.dir, f.id)
    f.isAlive = false
    arr[0][0] = -1

    // solution
    dfs(arr, shark, fishes)
    println(maxSum)
}

fun dfs(arr: Array<IntArray>, shark: Shark, fishes: MutableList<Fish>) {
    // 잡아먹은 양의 최대값 구하기
    if (maxSum < shark.eatSum) {
        maxSum = shark.eatSum
    }

    // 모든 물고기 순서대로 이동
    fishes.forEach { moveFish(it, arr, fishes) }

    for (dist in 1..3) {
        val nx = shark.x + dx[shark.dir] * dist
        val ny = shark.y + dy[shark.dir] * dist

        if (nx in 0..3 && 0 <= ny && ny < 4 && arr[nx][ny] > 0) {
            // 물고기 잡아먹고 dfs
            val arrCopies = Array(arr.size) { arr[it].copyOf() }
            val fishCopies = fishes.map { Fish(it.x, it.y, it.id, it.dir, it.isAlive) }.toMutableList()

            arrCopies[shark.x][shark.y] = 0
            val f = fishCopies[arr[nx][ny] - 1]
            val newShark = Shark(f.x, f.y, f.dir, shark.eatSum + f.id)
            f.isAlive = false
            arrCopies[f.x][f.y] = -1

            dfs(arrCopies, newShark, fishCopies)
        }
    }
}

fun moveFish(fish: Fish, arr: Array<IntArray>, fishes: MutableList<Fish>) {
    if (!fish.isAlive) return

    for (i in 0..7) {
        val nextDir = (fish.dir + i) % 8
        val nx = fish.x + dx[nextDir]
        val ny = fish.y + dy[nextDir]

        if (nx in 0..3 && 0 <= ny && ny < 4 && arr[nx][ny] > -1) {
            arr[fish.x][fish.y] = 0

            if (arr[nx][ny] == 0) {
                fish.x = nx
                fish.y = ny
            } else {
                val temp = fishes[arr[nx][ny] - 1]
                temp.x = fish.x
                temp.y = fish.y
                arr[fish.x][fish.y] = temp.id

                fish.x = nx
                fish.y = ny
            }

            arr[nx][ny] = fish.id
            fish.dir = nextDir
            return
        }
    }
}
