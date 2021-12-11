import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author HaiLang
 * @date 2021/11/25 23:07
 */
fun main(args: Array<String>) {
    GlobalScope.launch {
        delay(500)
        println(" World !")
    }
    print("Hello")
    Thread.sleep(1000)
}