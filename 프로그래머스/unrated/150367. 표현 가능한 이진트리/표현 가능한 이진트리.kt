import java.util.*
import kotlin.math.*

class Solution {
    fun solution(numbers: LongArray): IntArray {
        val answer = IntArray(numbers.size)

        numbers.forEachIndexed { index, value ->
            var bin = value.toString(2)
            // 포화 이진트리의 노드 개수
            val allNodeCount = findAllNodeCount(bin)
            while(bin.length < allNodeCount) {
                bin = "0$bin"
            }
            answer[index] = canMakeBinaryTree('1', bin)
        }

        return answer
    }

    private fun findAllNodeCount(bin: String): Int {
        val base = 2.0
        var x = 1
        var count = (base.pow(x) - 1)
        while(bin.length > count) {
            count = (base.pow(++x) - 1)
        }
        return count.toInt()
    }

    private fun canMakeBinaryTree(parent: Char, bin: String): Int {
        if(bin.length == 1) {
            if(bin[0] == '1') {
                if(parent == '0') return 0
                else return 1
            } else return 1
        }
        val midIndex = bin.length / 2
        val mid = bin[midIndex]
        
        if(mid == '1' && parent == '0') return 0
        
        if(canMakeBinaryTree(mid, bin.substring(0, midIndex)) == 0 || canMakeBinaryTree(mid, bin.substring(midIndex + 1, bin.length)) == 0) {
            return 0
        }
        
        return 1
    }
}