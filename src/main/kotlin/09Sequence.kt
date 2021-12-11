/**
 * @author HaiLang
 * @date 2021/11/24 23:19
 */
fun main(args: Array<String>) {

    //构造"无限"序列
    var list = listOf(1, 2, 3, 4, 5)

    list.filter { i ->
        println("filter $i")
        i > 0
    }.map { i ->
        println("map $i")
        i
    }.toList()

    println("---------------------------------")
    //本质上是iterator
    list.asSequence()
        .filter { i ->
            println("filter $i")
            i > 0
        }.map { i ->
            println("map $i")
            i
        }.toList()

    println("---------------------------------")
    //本质上是iterator
    val sequence = generateSequence(1) { it + 1 }.takeWhile { it <= 5 }
    sequence.filter { i ->
        println("filter $i")
        i > 0
    }.map { i ->
        println("map $i")
        i
    }.toList()
}