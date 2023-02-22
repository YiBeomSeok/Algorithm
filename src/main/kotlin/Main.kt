fun sum(numbers: IntArray): Int {
    return numbers.filter { it >= 0 }.sum()
}