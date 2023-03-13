package boostcourse2.ch03

/**
 * 인터페이스는 클래스가 아닙니다. 따라서 상속이라는 형태로 하위 클래스에 프로퍼티와 메서드를 전하지 않습니다.
 * 그래서 하위 클래스보다는 구현 클래스라고 이야기 합니다.
 * 이런 구현 클래스는 인터페이스가 제시한 메서드들을 구체적으로 '구현'한다는데 있습니다.
 * 그리고 인터페이스는 구현 클래스들과 강한 연관을 가지지 않습니다.
 *
 * 인터페이스는 원하는 만큼 구현 클래스에 붙여서 필요한 메서드들을 구현해 내면 됩니다.
 * 인터페이스가 바뀐다고 할지라도 그것을 구현하는 클래스에 크게 영향을 끼치지 않게 할 수 있죠.
 */
interface Pet {
    var category: String // abstract 키워드가 없어도 기본은 추상 프로퍼티
    fun feeding() // 마찬가지로 추상 메서드
    fun patting() { // 일반 메서드: 구현부를 포함하면 일반적인 메서드로 기본이 됨
        println("Keep patting!") // 구현부
    }
}

/**
 * 인터페이스에서는 추상 클래스와는 다르게 abstract를 붙여 주지 않아도 기본적으로 추상 프로퍼티와 추상 메서드가 지정됩니다.
 * 그리고 메서드에는 기본 구현부가 있으면 일반 메서드로서 기본 구현을 가지게 됩니다.
 * 상태를 저장할 수 없기에 프로퍼티에는 기본값을 가질 수 없습니다.
 */

interface Bird {
    val wings: Int
    fun fly()
    fun jump() = println("bird jump")
}

interface Horse {
    val maxSpeed: Int
    fun run()
    fun jump() = println("jump!, max speed: $maxSpeed")
}

class Pegasus : Bird, Horse {
    override val maxSpeed: Int = 100
    override val wings: Int = 2
    override fun fly() {
        println("Fly!")
    }

    override fun run() {
        println("Run!")
    }

    override fun jump() {
        super<Horse>.jump()
        println("and Jump!")
    }
}

/**
 * 인터페이스의 위임 사용
 */
interface A {
    fun functionA() {}
}
interface B {
    fun functionB() {}
}

class C(val a: A, val b: B) {
    fun functionC() {
        a.functionA()
        b.functionB()
    }
}

class DelegatedC(a: A, b: B): A by a, B by b {
    fun functionC() {
        functionA() // A의 위임
        functionB() // B의 위임
    }
}

// 위임을 이용한 멤버 접근
interface Nameable {
    var name: String
}

class StaffName : Nameable {
    override var name: String = "Sean"
}

class Work: Runnable { // 스레드 실행을 위한 인터페이스
    override fun run() {
        println("work...")
    }
}

// 1. 각 매개변수에 해당 인터페이스를 위임한다.
class Person(name: Nameable, work: Runnable): Nameable by name, Runnable by work

fun main() {
    val person = Person(StaffName(), Work()) // 생성자를 사용해 객체를 바로 전달
    println(person.name) // 여기서 StaffName 클래스의 name 접근
    person.run() // 여기서 Work 클래스의 run 접근
}