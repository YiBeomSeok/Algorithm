
class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var lastBoxIndex = findLastIndex(n - 1, deliveries)
        var lastPickupIndex = findLastIndex(n - 1, pickups)
        var lastIndex = lastBoxIndex.coerceAtLeast(lastPickupIndex)
        var totalDistance = 0L

        while (lastIndex > -1) {
            var box = cap
            var space = cap
            var i = lastBoxIndex
            while (i >= 0 && box > 0) {
                // 배달품 전해주는중
                while (deliveries[i] > 0 && box > 0) {
                    deliveries[i]--
                    box--
                }
                i--
            }
            var j = lastPickupIndex
            while (j >= 0 && space > 0) {
                while (pickups[j] > 0 && space > 0) {
                    pickups[j]--
                    space--
                }
                j--
            }
            totalDistance += (lastIndex + 1) * 2
            lastBoxIndex = findLastIndex(lastBoxIndex, deliveries)
            lastPickupIndex = findLastIndex(lastPickupIndex, pickups)
            lastIndex = lastBoxIndex.coerceAtLeast(lastPickupIndex)
        }
        return totalDistance
    }

    private fun findLastIndex(index: Int, intArray: IntArray): Int {
        for (i in index downTo 0) {
            if (intArray[i] > 0) return i
        }
        return -1
    }
}