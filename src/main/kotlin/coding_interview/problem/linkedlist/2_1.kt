package coding_interview.problem.linkedlist

/**
 * 정렬되어 있지 않은 연결리스트가 주어졌을 때 이 리스트에서
 * 중복되는 원소를 제거
 */
class `2_1` {

}

fun deleteDups(n: Node<Any>?) {
    var cur = n
    val set = HashSet<Any>()
    var prev: Node<Any>? = null
    while(cur != null) {
        if (set.contains(cur.data)) {
            prev?.next = cur.next
        } else {
            set.add(cur.data)
            prev = n
        }
        cur = cur.next
    }
}

fun main() {

}