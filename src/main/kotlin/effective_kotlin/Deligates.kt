package effective_kotlin

import kotlin.properties.Delegates

var observableField: Int by Delegates.observable(0) { property, old, new ->
    println("old: $old, new: $new")
}

var vetoableField: Int by Delegates.vetoable(0) { property, old, new ->
    println("old: $old, new: $new")

    new % 2 == 0
}

fun main() {
    println(observableField) // 0

    observableField = 1

    println(observableField) // 1

    println(vetoableField)
    vetoableField = 1
    println(vetoableField)
    vetoableField = 2
    println(vetoableField)
}