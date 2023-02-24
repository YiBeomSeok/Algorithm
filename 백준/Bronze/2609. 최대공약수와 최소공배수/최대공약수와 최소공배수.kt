fun solution(inputs: List<Int>) {
    var input1 = inputs[0]
    var input2 = inputs[1]
    var gcd = 1
    var divisor = 2

    while(input1 >= divisor && input2 >= divisor) {
        if(input1 % divisor == 0 && input2 % divisor == 0) {
            gcd *= divisor
            input1 /= divisor
            input2 /= divisor
        }
        else {
            divisor++
        }
    }
    // GCD (Greatest Common Divisor)
    println(gcd)
    // LCM (Least Common Multiple)
    println(gcd * input1 * input2)
}
fun main(args: Array<String>) {
    solution(readln().split(" ").map { it.toInt() }.toList())
}