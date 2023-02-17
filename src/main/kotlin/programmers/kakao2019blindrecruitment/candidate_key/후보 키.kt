package programmers.kakao2019blindrecruitment.candidate_key

class Solution {
    val keyMap: MutableMap<String, MutableSet<String>> = mutableMapOf()

    fun solution(relation: Array<Array<String>>): Int {

        // key로 만들 수 있는 튜플들 저장
        // repeat 함수는 어떤 문자열을 주어진 횟수만큼 반복하거나 어떤 함수를 주어진 횟수만큼 반복한다.
        repeat(relation.size) { combine(relation, it, 0, "", "") }

        // 유일성을 만족시키는 후보키들
        val candidates = keyMap.filter { it.value.size == relation.size }.toSortedMap(compareBy<String> { it.length }.thenBy { it })

        val answer = mutableListOf<String>()

        // 각 후보키가 최소성을 만족하는지 확인
        for (key in candidates.keys) {
            val keyCount = key.length

            answer.add(key)

            for (candidate in answer) {
                if (candidate.length >= keyCount) break
                else if (!isMinimal(key, candidate)) {
                    // 최소성을 만족하지 않는 경우 삭제
                    answer.remove(key)
                    break
                }
            }
        }

        return answer.size
    }

    // 후보키 조합 함수
    private fun combine(relation: Array<Array<String>>, n: Int, key: Int, keySet: String, tuple: String) {

        if (key == relation[0].size && tuple.isNotEmpty()) {
            val tuples = keyMap.getOrDefault(keySet, mutableSetOf())
            tuples.add(tuple)
            keyMap[keySet] = tuples
        }

        if (relation[0].size == key) return

        combine(relation, n, key+1, keySet+key, tuple+relation[n][key])
        combine(relation, n, key+1, keySet, tuple)
    }

    // 최소성 검사 함수
    private fun isMinimal(key: String, candidate: String): Boolean {
        var count = 0

        // candidate의 모든 key들이 key에 포함되는지 확인
        for (c in candidate) {
            if (key.contains(c)) count++
        }

        return count != candidate.length
    }
}

fun main() {

}