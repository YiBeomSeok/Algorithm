fun lis(arr: IntArray): Pair<Int, IntArray> {
    val n = arr.size
    val dp = IntArray(n)
    val prev = IntArray(n) { -1 }
    var len = 1

    for (i in 1 until n) {
        if (arr[i] < arr[dp[0]]) {
            dp[0] = i
        } else if (arr[i] > arr[dp[len - 1]]) {
            prev[i] = dp[len - 1]
            dp[len++] = i
        } else {
            var lo = 0
            var hi = len - 1
            while (lo < hi) {
                val mid = (lo + hi) / 2
                if (arr[dp[mid]] < arr[i]) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }
            prev[i] = dp[lo - 1]
            dp[lo] = i
        }
    }
    val lis = mutableListOf<Int>()
    var i = dp[len - 1]
    while (i != -1) {
        lis.add(arr[i])
        i = prev[i]
    }
    lis.reverse()
    return Pair(len, lis.toIntArray())
}

fun main() {
    val arr1 = intArrayOf(3, 2, 6, 4, 5, 1)
    val arr2 = intArrayOf(1, 2, 3, 4, 5)
    val arr3 = intArrayOf(5, 4, 3, 2, 1)
    val arr4 = intArrayOf(10, 22, 9, 33, 21, 50, 41, 60, 80)

    val (lis1Length, lis1Array) = lis(arr1)
    val (lis2Length, lis2Array) = lis(arr2)
    val (lis3Length, lis3Array) = lis(arr3)
    val (lis4Length, lis4Array) = lis(arr4)

    assert(lis1Length == 3)
    assert(lis1Array.contentEquals(intArrayOf(2, 4, 5)))

    assert(lis2Length == 5)
    assert(lis2Array.contentEquals(intArrayOf(1, 2, 3, 4, 5)))

    assert(lis3Length == 1)
    assert(lis3Array.contentEquals(intArrayOf(5)))

    assert(lis4Length == 6)
    assert(lis4Array.contentEquals(intArrayOf(10, 22, 33, 50, 60, 80)))

    println("All tests passed!")
}
