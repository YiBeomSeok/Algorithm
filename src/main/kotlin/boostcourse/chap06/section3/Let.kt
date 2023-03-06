package boostcourse.chap06.section3


/**
 * public inline fun <T, R> T.let(block: (T) -> R) : R { ... return block(this) }
 */
class Let {
    private val score: Int? = 32

    // let을 사용해 null 검사를 제거
    fun checkScoreLet() {
        score?.let { println("Score: $it")}
        val str = score.let { it.toString() }
        println(str)
    }

    // null 가능성 있는 객체에서 let() 활용하기
//    fun checkObject(obj: Objects?) {
//        obj?.let {
//            Toast.makeText(applicationContext, it, Toast.LENGTH_LONG).show()
//        }
//    }

    // 안드로이드 커스텀 뷰에서 Padding 값을 지정
    /*
    val padding = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        16f,
        resources.displayMetrics
    ).toInt()

    에서 다음으로
    TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        16f,
        resources.displayMetrics
    ).toInt().let { padding ->
            setPadding(padding, 0, padding, 0)
    }

    에서 또 다음으로
        TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        16f,
        resources.displayMetrics
    ).toInt().let { setPadding(it, 0, it, 0) }
     */
}