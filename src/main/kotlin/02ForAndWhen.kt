/**
 * @author HaiLang
 * @date 2021/11/22 21:51
 */
fun main(args: Array<String>) {
    for (i in 1..10) {
        when {
            i % 2 == 0 -> println("2:$i")
            i % 3 == 0 -> println("3:$i")
            i % 5 == 0 -> println("5:$i")
            i % 7 == 0 -> println("7:$i")
            else -> println("else:$i")
        }
    }
}