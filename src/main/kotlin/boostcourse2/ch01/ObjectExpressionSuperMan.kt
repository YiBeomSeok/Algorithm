package boostcourse2.ch01

open class Superman() {
    fun work() = println("Taking photos")
    fun talk() = println("Talking with people")
    open fun fly() = println("Flying in the air")
}


fun main() {
    /**
     * 하위 클래스를 만들지 않고도 새로운 구현인 fly()를 포함할 수 있다.
     *
     * 어떤 클래스에 메서드를 오버라이딩 하기 위해 하위 클래스를 정의하고
     * 해당 메서드를 재정의 한 뒤 객체를 생성하는 과정을 거쳐야 하지만
     * object 표현식은 이러한 과정 없이 간단히 할 수 있다.
     */

    val pretendedMan = object: Superman() {
        override fun fly() {
            println("Im not a real superman. I can not fly!")
        }
    }

    pretendedMan.work()
    pretendedMan.talk()
    pretendedMan.fly()
}