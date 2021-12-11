import kotlin.coroutines.*

/**
 * @author HaiLang
 * @date 2021/11/28 15:55
 */
fun <R, T> launchCoroutine(receiver: R, block: suspend R.() -> T) {
    block.startCoroutine(receiver, object : Continuation<T> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<T>) {
            println("Coroutine end:$result")
        }

    })
}

@RestrictsSuspension
class ProducerScope<T> {
    suspend fun produce(value: T) {}
}

fun main(args: Array<String>) {
    launchCoroutine(ProducerScope<Int>()) {
        println("In Coroutine")
        produce(1024)
        5
    }
}