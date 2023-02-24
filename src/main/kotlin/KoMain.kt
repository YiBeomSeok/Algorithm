fun main(args: Array<String>){
    val input = readText().split("\n")
    val n = input[0].toInt()
    val list = IntArray(n)
    for (i in 1..n) {
        list[i-1] = input[i].toInt()
    }
    list.sort()
    val sb = StringBuilder()

    for (i in 0 until n) {
        sb.append(list[i]).append('\n')
    }
    print(sb)
}