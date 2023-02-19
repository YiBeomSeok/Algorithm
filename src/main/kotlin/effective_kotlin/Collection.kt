package effective_kotlin

import kotlin.math.absoluteValue

class `변환`() {
    val number = listOf(1, 2, 3)

    /**
     * map
     * 컬렉션 내의 자료들을 변환
     */
    fun map() {
        // 숫자를 제곱으로 변환하여 출력
        number.map { n -> n * n }.forEach { println(it) }
    }

    /**
     * mapIndexed
     * 컬렉션 내의 자료들과 그 자료들의 인덱스를 사용하여 변환할 수 있다.
     */
    fun mapIndexed() {
        // 인덱스 값과 함께 출력
        number.mapIndexed { index, i ->
            println("$index 번째 수 : $i")
        }
    }

    /**
     * mapNotNull
     * 컬렉션 내의 자료들을 변환하고 값이 null이면 무시한다.
     */
    fun mapNotNull() {
        // null 값을 무시
        number.mapNotNull { i -> if (i > 3) i else null }.forEach { println(it) }
    }


    /**
     * flatMap
     * 컬렉션 내의 하나의 자료를 여러개의 인자로 바꾼다. 변환하여 iterator(컬렉션) 형태로 반환한다.
     */
    fun flatMap() {
        // 각 인자가 1부터 인자까지의 수를 담은 iterator가 됨
        number.flatMap { i -> 1..i }.forEach { print("$it ") }
    }

    /**
     * groupBy
     * 컬렉션 내의 자료들을 조건에 따라 분류하여 변환하여 map(key, value) 형태로 반환한다.
     */
    fun groupBy() {
        // 컬렉션 내의 자료들을 조건에 따라 분류하여 변환하여 map(key, value) 형태로 반환한다.
        number.groupBy { i -> if (i > 3) "4이상" else "3이하" }.forEach { println(it) }

        // key, value 값 사용 가능
        number.groupBy { i -> if (i > 3) "4이상" else "3이하" }.forEach { (key, i) -> println("Key : $key Value : $i") }
    }
}

class `필터`() {
    val number = listOf(1, 2, 3, 4, 5)

    /**
     * filter
     * 컬렉션 내의 자료들을 조건에 맞춰서 걸러준다.
     */
    fun filter() {
        // 3을 초과하는 수만 출력
        number.filter { i -> i > 3 }.forEach { println(it) }
    }

    /**
     * take
     * 인자로 받은 개수만큼을 갖는 리스트를 반환한다.
     */
    fun take() {
        // 앞에서부터 2개까지의 인자를 가지는 리스트 반환
        number.take(2).forEach { println(it) }
        println()

        // 뒤에서부터 2개까지의 인자를 가지는 리스트 반환
        number.takeLast(2).forEach { println(it) }
        println()

        // 앞에서부터 조건에 맞는 자료까지의 인자를 가지는 리스트 반환
        number.takeWhile { i -> i < 3 }.forEach { println(it) }
        println()

        // 뒤에서부터 조건에 맞는 자료까지의 인자를 가지는 리스트 반환
        number.takeLastWhile { i -> i > 3 }.forEach { println(it) }
    }


    /**
     * drop
     * take의 반대의 역할을 하며, 그 개수만큼을 제외한 리스트를 반환한다.
     */
    fun drop() {
        // 앞에서부터 2개까지의 인자를 제외하고 가지는 리스트 반환
        number.drop(2).forEach { println(it) }
        println()

        // 뒤에서부터 2개까지의 인자를 제외하고 가지는 리스트 반환
        number.dropLast(2).forEach { println(it) }
        println()

        // 앞에서부터 조건에 맞는 자료까지의 인자를 제외하고 가지는 리스트 반환
        number.dropWhile { i -> i < 3 }.forEach { println(it) }
        println()

        // 뒤에서부터 조건에 맞는 자료까지의 인자를 제외하고 가지는 리스트 반환
        number.dropLastWhile { i -> i > 3 }.forEach { println(it) }
        println()
    }

    /**
     * first, last
     * 각각 컬렉션의 첫번째, 마지막 자료를 반환한다.
     */
    fun firstLast() {
        // 첫번째 자료 반환
        println(number.first())
        // 조건에 맞는 첫번째 자료 반환, 없으면 예외
        println(number.first() { i -> i > 3 })
        // 조건에 맞는 첫번째 자료 반환, 없으면 null
        println(number.firstOrNull() { i -> i < 3 })

        // 마지막 자료 반환
        println(number.last())
        // 조건에 맞는 마지막 자료 반환, 없으면 예외
        println(number.last() { i -> i < 3 })
        // 조건에 맞는 마지막 자료 반환, 없으면 null
        println(number.lastOrNull { i -> i > 5 })
    }

    /**
     * distinct
     * 중복된 값을 제외하여 반환한다.
     */
    fun distinct() {
        val number2 = listOf(-1, -2, 1, 2, 3, 4, 5, 1, 2, 3)

        // 중복된 자료 제외하고 반환
        number2.distinct().forEach { println(it) }
        println()

        // 중복 기준 지정 (절대값)
        number2.distinctBy { i -> i.absoluteValue }.forEach { println(it) }
    }
}

class `조합과 합계`() {

    val name = listOf("KIM", "CHOI", "HAN", "LEE")
    val age = listOf(24, 30, 36, 20, 1)

    /**
     * zip
     * 두 컬렉션을 조합하여 새로운 컬렉션을 만들어준다,
     */
    fun zip() {
        // Pair 형태로 조합해준다. 리스트 인자의 개수가 더 적은 쪽의 수를 따라간다.
        name.zip(age).forEach { println(it) }
        // Pair 가 아닌 다른 형태로도 반환 가능
        name.zip(age) { name, age -> "${name}는 ${age}살 입니다." }.forEach { println(it) }
    }

    /**
     * joinToString
     * 컬렉션을 문자열로 변환하여 한 문자열로 반환한다.
     */
    fun joinToString() {
        // 문자열 형태로 변환하여 하나의 문자열로 합친다.
        println(name.joinToString())    // KIM, CHOI, HAN, LEE
        // 구분자 지정
        println(name.joinToString(" ")) // KIM CHOI HAN LEE
    }

    /**
     * reduce, fold
     * 컬렉션 내의 자료를 다 합쳐준다. 무슨 차이지..?
     */
    fun reduceFold() {
        val number = listOf(1, 2, 3, 4, 5)

        // 수를 모두 합친다.
        println(number.reduce { sum, i -> sum + i })

        // 수를 모두 합친다. (초기값 5)
        println(number.fold(5) { sum, i -> sum + i })
    }
}

class `기타` {

    /**
     * any, none
     * 컬렉션에서 자료의 존재여부를 반환한다.
     */
    fun anyNone() {
        val number = listOf(1, 2, 3, 4, 5)

        // 자료가 존재하면 true
        println(number.any())
        // 5를 넘는 자료가 존재하면 true
        println(number.any { i -> i > 5 })

        // 자료가 존재하지 않으면 true (any의 반대)
        println(number.none())
        // 5를 넘는 자료가 존재하지 않으면 true
        println(number.none { i -> i > 5 })
    }

    fun maxMinAverage() {
        val number = listOf(1, 2, 3, 4, 5)

        // 최대값
        println(number.max())
        // 최소값
        println(number.min())
        // 평균값 (Double)
        println(number.average())
    }
}