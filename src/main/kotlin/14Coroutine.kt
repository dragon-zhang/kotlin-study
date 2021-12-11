import kotlin.coroutines.*

/**
 * @author HaiLang
 * @date 2021/11/28 11:29
 */
fun main(args: Array<String>) {
    val continuation = suspend {
        println("In Coroutine")
        5
    }.createCoroutine(object : Continuation<Int> {
        override fun resumeWith(result: Result<Int>) {
            println("Coroutine end:$result")
        }

        override val context: CoroutineContext
            get() = EmptyCoroutineContext

    })
    continuation.resumeWith(Result.success(Unit))

    suspend {
        println("In Coroutine")
        3
    }.startCoroutine(object : Continuation<Int> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Int>) {
            println("Coroutine end:$result")
        }
    })
}