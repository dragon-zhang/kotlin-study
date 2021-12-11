import kotlinx.coroutines.*
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

/**
 * @author HaiLang
 * @date 2021/12/1 20:29
 */
suspend fun main(args: Array<String>) {
    thread()
    coroutine()
}

private fun thread() {
    val start = System.currentTimeMillis()
    val executor = Executors.newSingleThreadExecutor()
    val list = arrayOfNulls<CompletableFuture<Unit?>>(100)
    for (i in 0..99) {
        val job = CompletableFuture.supplyAsync({
            //todo 换成dubbo调用
            Thread.sleep(100)
            println("$i")
        }, executor)
        list[i] = job
    }
    CompletableFuture.allOf(*list).join()
    println("thread cost " + (System.currentTimeMillis() - start) + "ms")
    executor.shutdown()
}

private suspend fun coroutine() {
    val start = System.currentTimeMillis()
    val newSingleThreadExecutor = Executors.newSingleThreadExecutor()
    val executor = newSingleThreadExecutor.asCoroutineDispatcher()
    val list = LinkedList<Deferred<Unit>>()
    for (i in 0..99) {
        val job = GlobalScope.async(executor) {
            //todo 换成dubbo调用
            delay(100)
            println("$i")
        }
        list.add(job)
    }
    for (job in list) {
        job.await()
    }
    println("coroutine cost " + (System.currentTimeMillis() - start) + "ms")
    newSingleThreadExecutor.shutdown()
}