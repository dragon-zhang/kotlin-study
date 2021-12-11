import kotlin.coroutines.*

/**
 * @author HaiLang
 * @date 2021/11/28 17:15
 */
class LogInterceptor : ContinuationInterceptor {
    override val key = ContinuationInterceptor

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return LogContinuation(continuation)
    }

    class LogContinuation<T>(private val continuation: Continuation<T>) : Continuation<T> by continuation {
        override fun resumeWith(result: Result<T>) {
            println("before resume:$result")
            continuation.resumeWith(result)
            println("after resume:$result")
        }
    }
}

fun main(args: Array<String>) {
    var context: CoroutineContext = EmptyCoroutineContext
    context += LogInterceptor()
    suspend {
        println("In Coroutine")
        3
    }.startCoroutine(object : Continuation<Int> {
        override val context: CoroutineContext
            get() = context

        override fun resumeWith(result: Result<Int>) {
            println("Coroutine end:$result")
        }
    })

}