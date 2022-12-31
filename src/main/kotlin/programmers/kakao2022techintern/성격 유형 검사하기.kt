package programmers.kakao2022techintern

enum class MyType(val code: String) {
    TYPE_R("R"), TYPE_T("T"), TYPE_C("C"), TYPE_F("F"), TYPE_J("J"), TYPE_M("M"), TYPE_A("A"), TYPE_N("N");
}

class Survey() {
    private val scoreOfTypes = mutableMapOf<String, Int>().apply {
        this[MyType.TYPE_R.code] = 0; this[MyType.TYPE_T.code] = 0
        this[MyType.TYPE_C.code] = 0; this[MyType.TYPE_F.code] = 0
        this[MyType.TYPE_J.code] = 0; this[MyType.TYPE_M.code] = 0
        this[MyType.TYPE_A.code] = 0; this[MyType.TYPE_N.code] = 0
    }

    private fun add(choice: Int, surveyElement: String) {
        if (isAgree(choice)) scoreOfTypes[surveyElement[1].toString()] =
            scoreOfTypes[surveyElement[1].toString()]!! + (choice - 4)
        else scoreOfTypes[surveyElement[0].toString()] =
            scoreOfTypes[surveyElement[0].toString()]!! + (4 - choice)
    }

    fun getResult(survey: Array<String>, choices: IntArray): String {
        val sb = StringBuilder()
        for (idx in choices.indices) {
            add(choices[idx], survey[idx])
        }
        if (scoreOfTypes[MyType.TYPE_R.code]!! >= scoreOfTypes[MyType.TYPE_T.code]!!)
            sb.append("R")
        else
            sb.append("T")

        if (scoreOfTypes[MyType.TYPE_C.code]!! >= scoreOfTypes[MyType.TYPE_F.code]!!)
            sb.append("C")
        else
            sb.append("F")

        if (scoreOfTypes[MyType.TYPE_J.code]!! >= scoreOfTypes[MyType.TYPE_M.code]!!)
            sb.append("J")
        else
            sb.append("M")

        if (scoreOfTypes[MyType.TYPE_A.code]!! >= scoreOfTypes[MyType.TYPE_N.code]!!)
            sb.append("A")
        else
            sb.append("N")

        return sb.toString()
    }

    // 비동의인지 동의인지 판별, 4인 경우 모르겠음이니 이 함수를 호출하지 말 것
    private fun isAgree(choice: Int): Boolean {
        if (choice < 4) return false
        return true
    }
}

class Solution118666 {

    fun solution(survey: Array<String>, choices: IntArray): String {
        val s = Survey()
        return s.getResult(survey, choices)
    }
}

fun main() {
    val solution118666 = Solution118666()

    println(
        solution118666.solution(
            arrayOf("AN", "CF", "MJ", "RT", "NA"), intArrayOf(5, 3, 2, 7, 5)
        )
    )
}