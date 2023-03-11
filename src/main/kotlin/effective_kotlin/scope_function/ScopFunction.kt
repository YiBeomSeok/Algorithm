package effective_kotlin.scope_function

fun main() {
    //let, run, apply, also  with
    //1. let
    // 수신객체.let { user ->
    //
    // 마지막 줄 // return
    // }
    val a = 3
    a.let {  }
    var user : User? = User("이범석", 28, true)
    val age = user?.let {
        it.age
    }
    println(age)

    //2. run
    //수신객체.run {
    //
    // 마지막 줄
    //}
    val kid = User("아이", 4, false)
    val kidAge = kid.run {
        age
    }
    println(kidAge)

    //3. apply
    //수신객체.apply {
    //  ddwfewfew
    //}
    // return 값이 수신객체
    val female = User("슬기", 20, true, true)
    val femaleValue = female.apply {
        hasGlasses = false
    }
    println(femaleValue.hasGlasses)

    //4. also
    // 수신객체.also { it -> // local variable
    //
    //
    // } // return 수신객체 (자기자신)
    val male = User("민수", 17, false, true)
    val maleValue = male.also {
        println(it.name)
    }

    //5. with
    // with(수신객체) {
    //  ---
    // 마지막줄
    // }
    val result = with(male) {
        hasGlasses = false
        true
    }
}

class User(
    val name : String,
    val age: Int,
    val gender : Boolean, // true : female, false : male
    var hasGlasses : Boolean = true,
)