/*
에라토네스의 체 알고리즘을 알아야 풀 수 있다. 
또한 에라토네스의 체 알고리즘 중,
O(N)의 시간복잡도를 가지는 풀이법을 사용해야 시간 제한을 통과할 수 있으니
본인이 알고 있는 `에라토네스의 체`의 시간복잡도는 어떻게 되는지 미리 확인하는 것이 좋겠다.
*/

fun getPrimes(n: Int): List<Int> {
    val isPrime = BooleanArray(n+1) { true }
    val primes = mutableListOf<Int>()

    for (i in 2..n) {
        if (isPrime[i]) {
            primes.add(i)
        }

        for (j in primes.indices) {
            val k = i * primes[j]
            if (k > n) break
            isPrime[k] = false
            if (i % primes[j] == 0) break
        }
    }

    return primes
}

fun main(args: Array<String>) {
    val n = readln().toInt()
    // 2 3 5 7 11 13 17 31 ...
    val primes = getPrimes(n)

    val last = primes.size
    var sum = 0
    var count = 0
    var lt = 0
    for (i in 0 until last) {
        sum += primes[i]
        if (sum == n) {
            count++
        } else if (sum > n) {
            while (lt < i && sum > n) {
                sum -= primes[lt++]
            }
            if (sum == n)
                count++
        }
    }

    print(count)
}
