package coding_interview.problem

class StringContractionChecker {
    fun contractString(str: String): String {
        val finalLength = countCompression(str)
        if(finalLength > str.length) return str

        var prev: Char = '\u0000'
        var count = 0
        val result = StringBuilder(finalLength)

        for (ch in str) {
            when (ch) {
                prev -> count++
                else -> {
                    if (prev != '\u0000') {
                        result.append(prev).append(count)
                    }
                    prev = ch
                    count = 1
                }
            }
        }

        if (prev != '\u0000') {
            result.append(prev).append(count)
        }

        return if (result.length <= str.length) result.toString() else str
    }

    fun countCompression(str: String): Int {
        var compressedLength = 0;
        for(i in str.indices) {
            if(i + 1 >= str.length || str[i] != str[i + 1]) {
                compressedLength = compressedLength.plus(2 )
            }
        }
        return compressedLength
    }
}

fun main() {
    println(StringContractionChecker().contractString("aabccccaaa"))
}