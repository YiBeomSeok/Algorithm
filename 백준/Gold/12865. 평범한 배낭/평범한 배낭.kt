import kotlin.math.max

data class Item(val weight: Int, val value: Int)

fun main() {
    val (n, maxWeight) = readLine()!!.split(" ").map { it.toInt() }
    val items = Array<Item>(n + 1) { Item(0, 0) }

    repeat(n) {
        val (weight, value) = readLine()!!.split(" ").map { num -> num.toInt() }
        items[it + 1] = Item(weight, value)
    }
    items.sortBy { it.weight }

    val dp = Array<IntArray>(n + 1) { IntArray(maxWeight + 1) { 0 } }

    for (i in 1..n) {
        for (w in 1..maxWeight) {
            val currentItem = items[i]
            val weight = currentItem.weight
            val value = currentItem.value

            dp[i][w] = dp[i - 1][w]

            if (w >= weight) {
                dp[i][w] = max(dp[i][w], dp[i - 1][w - weight] + value)
            }
        }
    }

    print(dp[n][maxWeight])
}
