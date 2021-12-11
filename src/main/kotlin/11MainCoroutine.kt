import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author HaiLang
 * @date 2021/11/25 23:07
 */
fun main(args: Array<String>) {
    //runBlocking创建主协程
    runBlocking {
        val job = launch {
            delay(500)
            println(" World !")
        }
        print("Hello")
        job.join()
    }
}