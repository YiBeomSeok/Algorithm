import kotlin.math.*

class Solution {
    fun solution(numbers: LongArray): IntArray {
        val answer = IntArray(numbers.size)

        numbers.forEachIndexed { index, value ->
            var binaryString = value.toString(2)
            // Calculate the number of nodes in a complete binary tree
            val totalNodes = findTotalNodeCount(binaryString)

            // Pad the binary string with zeros until it reaches the total node count
            while (binaryString.length < totalNodes) {
                binaryString = "0$binaryString"
            }

            answer[index] = canFormBinaryTree('1', binaryString)
        }

        return answer
    }

    private fun findTotalNodeCount(binaryString: String): Int {
        val base = 2.0
        var exponent = 0

        // Find the smallest exponent for which 2^exponent - 1 is greater than the binary string length
        while ((base.pow(++exponent) - 1) < binaryString.length) {
        }

        return (base.pow(exponent) - 1).toInt()
    }


    private fun canFormBinaryTree(parent: Char, binaryString: String): Int {
        if (binaryString.length == 1) {
            return if (binaryString[0] == '1') {
                if (parent == '0') 0
                else 1
            } else 1
        }

        val midIndex = binaryString.length / 2
        val mid = binaryString[midIndex]

        if (mid == '1' && parent == '0') return 0

        val leftSubtree = binaryString.substring(0, midIndex)
        val rightSubtree = binaryString.substring(midIndex + 1, binaryString.length)

        if (canFormBinaryTree(mid, leftSubtree) == 0 || canFormBinaryTree(mid, rightSubtree) == 0) {
            return 0
        }

        return 1
    }
}