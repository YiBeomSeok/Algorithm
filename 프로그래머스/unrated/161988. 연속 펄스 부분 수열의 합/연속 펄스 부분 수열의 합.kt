class Solution {
    fun solution(sequence: IntArray): Long {
        val pulse1 = IntArray(sequence.size) { if (it % 2 == 0) 1 else -1 }
        val pulse2 = IntArray(sequence.size) { if (it % 2 == 0) -1 else 1 }

        val maxSum1 = maxPulseSubarraySum(sequence, pulse1)
        val maxSum2 = maxPulseSubarraySum(sequence, pulse2)

        return maxOf(maxSum1, maxSum2)
    }

    private fun maxPulseSubarraySum(sequence: IntArray, pulse: IntArray): Long {
        var maxSoFar = Long.MIN_VALUE
        var maxEndingHere = 0L

        for (i in sequence.indices) {
            maxEndingHere += (sequence[i] * pulse[i])
            maxSoFar = maxOf(maxSoFar, maxEndingHere)
            maxEndingHere = maxOf(maxEndingHere, 0L)
        }

        return maxSoFar
    }
}
