import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * @author HaiLang
 * @date 2021/11/25 23:07
 */
fun main(args: Array<String>) {
    runBlocking {
        val start = System.currentTimeMillis()
        val work1 = async { doWork1() }
        val work2 = async { doWork2() }
        delay(500)
        println("all work:[" + work1.await() + "," + work2.await() + "]")
        println("cost " + (System.currentTimeMillis() - start) + "ms")
    }
}