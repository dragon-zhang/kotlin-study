import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author HaiLang
 * @date 2021/11/25 23:07
 */
suspend fun doWork1(): String {
    delay(500)
    return "work1 done"
}

suspend fun doWork2(): String {
    delay(300)
    return "work2 done"
}

fun main(args: Array<String>) {
    runBlocking {
        val start = System.currentTimeMillis()
        val work1 = doWork1()
        println(work1)
        val work2 = doWork2()
        println(work2)
        delay(500)
        println("all work:[$work1,$work2]")
        println("cost " + (System.currentTimeMillis() - start) + "ms")
    }
}