class Solution {
    var limitShot = 0
    
    lateinit var apeachInfo: IntArray
    lateinit var needShotInfo: IntArray
    
    var distMax = -1
    lateinit var lionInfoMax: IntArray
    
    fun solution(n: Int, info: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        
        this.limitShot = n
        this.apeachInfo = info
        this.needShotInfo = info.clone()
        for(i in 0 until 11) {
            needShotInfo[i] += 1
        }
        
        val lionInfoCurrent = IntArray(11) { 0 }
        lionInfoMax = intArrayOf(-1)
        
        dfs(0, lionInfoCurrent, 0)
        
        return lionInfoMax
    }
    
    private fun dfs(countShot: Int, lionInfoCurrent: IntArray, depth: Int) {
        if(countShot > limitShot) return

        if(depth == 11) {
            val lionInfoFinal = lionInfoCurrent.clone()
            val remainsArrow = limitShot - countShot
            
            lionInfoFinal[10] += remainsArrow
            
            var apeachScore = 0
            var lionScore = 0

            for(i in 0 until 11) {
                if(apeachInfo[i] == 0 && lionInfoFinal[i] == 0) continue
                
                if(apeachInfo[i] >= lionInfoFinal[i]) {
                    apeachScore += 10 - i    
                } else {
                    lionScore += 10 - i
                }
            }
            
            val dist = lionScore - apeachScore
            
            if(dist > 0 && dist > distMax) {
                distMax = dist
                lionInfoMax = lionInfoFinal
            } else if(dist > 0 && dist == distMax) {
                for(i in 10 downTo 0) {
                    if(lionInfoFinal[i] > lionInfoMax[i]) {
                        lionInfoMax = lionInfoFinal
                        break
                    } else if (lionInfoFinal[i] < lionInfoMax[i]) {
                        break
                    }
                }
            }
        } else {
            lionInfoCurrent[depth] += needShotInfo[depth]
            dfs(countShot + needShotInfo[depth], lionInfoCurrent , depth + 1)
            lionInfoCurrent[depth] -= needShotInfo[depth]
            dfs(countShot, lionInfoCurrent, depth + 1)
        }
    }
}