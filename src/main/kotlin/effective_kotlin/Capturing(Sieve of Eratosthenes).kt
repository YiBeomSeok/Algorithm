package effective_kotlin

/**
 * Sieve of Eratosthenes
 * 소수를 구하는 알고리즘
 *
 * 1. 2부터 시작하는 숫자 리스트(=(2..100) 등)를 만든다.
 * 2. 첫 번째 요소를 선택한다. 이는 소수이다.
 * 3. 남아 있는 숫자 중에서 2번에서 선택한 소수로 나눌 수 있는 모든 숫자를 제거한다.
 */

fun solution() {
    var numbers = (2..100).toList()
    val primes = mutableListOf<Int>()
    while (numbers.isNotEmpty()) {
        val prime = numbers.first()
        primes.add(prime)
        numbers = numbers.filter { it % prime != 0 }
    }
    print(primes.joinToString(" "))
}

fun main() {
    solution()
}