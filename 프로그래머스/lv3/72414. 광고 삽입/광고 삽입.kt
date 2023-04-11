class Solution {
    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {

        val playTime = getSec(play_time)
        val advTime = getSec(adv_time)

        val sums = LongArray(playTime + 2)

        logs.forEach {
            val log = it.split("-")
            val start = getSec(log[0])
            val end = getSec(log[1])

            sums[start + 1] += 1L
            sums[end + 1] -= 1L
        }

        for(i in 1 until sums.size) {
            sums[i] = sums[i] + sums[i - 1]
        }
        for(i in 1 until sums.size) {
            sums[i] = sums[i] + sums[i - 1]
        }

        var maxTime = 0L
        var maxTimeStart = 0

        for(curSec in 0 .. playTime - advTime) {
            val start = curSec
            val end = curSec + advTime

            if(sums[end] - sums[start] > maxTime) {
                maxTimeStart = start
                maxTime = sums[end] - sums[start]
            }
        }

        return toStringTimeFormat(maxTimeStart)
    }

    private fun getSec(timeString: String): Int {
        val split = timeString.split(":")

        return split[0].toInt() * 3600 + split[1].toInt() * 60 + split[2].toInt()
    }

    private fun toStringTimeFormat(sec: Int): String {
        val h = sec / 3600
        val m = (sec % 3600) / 60
        val s = (sec % 3600) % 60

        return String.format("%02d:%02d:%02d", h, m, s)
    }
}