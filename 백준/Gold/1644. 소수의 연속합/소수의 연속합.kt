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