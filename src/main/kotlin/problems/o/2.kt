package problems.o

const val KOR = 1
const val USA = 2

class Solution {

    val stockMarket = HashMap<String, Int>()
    val coRisingCount = HashMap<String, HashMap<String, Int>>()

    fun solution(kor: Array<String>, usa: Array<String>, incs: Array<String>): Int {
        var answer = 0

        kor.forEach {
            stockMarket[it] = KOR
        }
        usa.forEach {
            stockMarket[it] = USA
        }

        incs.forEach {
            val stocks = it.split(" ")

            val korStocks = mutableListOf<String>()
            val usaStocks = mutableListOf<String>()
            for (stock in stocks) {
                when (stockMarket[stock]) {
                    KOR -> korStocks.add(stock)
                    USA -> usaStocks.add(stock)
                }
            }

            usaStocks.forEach { usaStock ->
                for (korStock in korStocks) {
                    coRisingCount[korStock] = coRisingCount.getOrDefault(korStock, HashMap()).apply {
                        val count = this.getOrDefault(usaStock, 0) + 1
                        answer = maxOf(answer, count)
                        this[usaStock] = count
                    }
                }
            }
        }

        return answer
    }
}

fun main() {
    val kor = arrayOf("SK", "LG", "KT")
    val usa = arrayOf("IBM", "GOOGL")
    val incs = arrayOf("GOOGL IBM SK", "SK LG", "IBM LG")
    val solution = Solution()
    val result = solution.solution(kor, usa, incs)
    println(result)
}