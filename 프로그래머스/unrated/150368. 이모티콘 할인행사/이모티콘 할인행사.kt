class Solution {
    private var resultSellCount = 0
    private var resultTotalPrice = 0
    private lateinit var emoticons: IntArray
    private lateinit var users: Array<IntArray>
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        this.emoticons = emoticons
        this.users = users

        val rates = IntArray(emoticons.size)
        permutation(10, 40, rates, 0)

        return intArrayOf(resultSellCount, resultTotalPrice)
    }

    private fun permutation(minRate: Int, maxRate: Int, discountRates: IntArray, depth: Int) {
        if (depth == discountRates.size) {
            val discounted = IntArray(emoticons.size)

            var caseBuyCount = 0
            var caseBuyPrice = 0

            for (i in discountRates.indices)
                discounted[i] = emoticons[i] * (100 - discountRates[i]) / 100

            for (userIndex in users.indices) {
                val curUser = users[userIndex]
                var curUsersBuyPrice = 0

                for (rateIndex in discountRates.indices) {
                    if (discountRates[rateIndex] >= curUser[0]) {
                        curUsersBuyPrice += discounted[rateIndex]
                    }
                }

                if (curUsersBuyPrice >= curUser[1]) {
                    caseBuyCount += 1
                } else {
                    caseBuyPrice += curUsersBuyPrice
                }
            }

            if (caseBuyCount > resultSellCount) {
                resultSellCount = caseBuyCount
                resultTotalPrice = caseBuyPrice
            } else if (caseBuyCount == resultSellCount) {
                if (caseBuyPrice > resultTotalPrice) {
                    resultTotalPrice = caseBuyPrice
                }
            }
        } else for (i in minRate..maxRate step 10) {
            discountRates[depth] = i
            permutation(minRate, maxRate, discountRates, depth + 1)
        }
    }
}