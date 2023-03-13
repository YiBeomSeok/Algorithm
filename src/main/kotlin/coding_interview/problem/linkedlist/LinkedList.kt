package coding_interview.problem.linkedlist

class Node<T>(val data: T, var next: Node<T>? = null)

class LinkedList<T> : Iterable<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun add(data: T) {
        val newNode = Node(data)
        if(head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
    }

    fun remove(data: T) {
        if (head?.data == data) {
            head = head?.next
            if (head == null) {
                tail = null
            }
            return
        }

        var currentNode = head
        while (currentNode?.next != null) {
            if (currentNode.next?.data == data) {
                currentNode.next = currentNode.next?.next
                if (currentNode.next == null) {
                    tail = currentNode
                }
                return
            }
            currentNode = currentNode.next
        }
    }

    fun printList() {
        var currentNode = head
        while(currentNode != null) {
            print("${currentNode.data} ")
            currentNode = currentNode.next
        }
    }

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            private var currentNode = head
            override fun hasNext(): Boolean {
                return currentNode != null
            }

            override fun next(): T {
                val data = currentNode?.data
                currentNode = currentNode?.next
                return data!!
            }
        }
    }
}