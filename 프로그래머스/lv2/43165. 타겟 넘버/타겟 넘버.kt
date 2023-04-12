class Solution {
    private var answer = 0
    
    fun solution(numbers: IntArray, target: Int): Int {
        dfs(0, 0, numbers, target)
        
        return answer
    }
    
    private fun dfs(curIdx: Int, curSum: Int, nums: IntArray, target: Int) {
        if(curIdx == nums.size) {
            if(curSum == target) {
                answer++
            }
        } else {
            dfs(curIdx + 1, curSum + nums[curIdx], nums, target)
            dfs(curIdx + 1, curSum - nums[curIdx], nums, target)
        }
    }
}