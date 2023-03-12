package coding_interview.problem.stringrotator

fun String.isRotateStringOf(s2: String): Boolean {
    val len = this.length
    if (len == s2.length && len > 0) {
        val s1s1 = "$this$this"
        return isSubstring(s1s1, s2)
    }
    return false
}
/*
java code: isSubstring 함수가 있다고 가정함

boolean isRotation(String s1, String s2) {
    int len = s1.length();
    if(len == s2.length() && len > 0) {
        String s1s1 = s1 + s1;
        return isSubstring(s1s1, s2);
    }
    return false;
}
 */

fun isSubstring(longer: String, smaller: String): Boolean {
    if (longer.length < smaller.length) return false

    for (i in 0..longer.length - smaller.length) {
        if (longer.substring(i, i + smaller.length) == smaller) {
            return true
        }
    }
    return false
}