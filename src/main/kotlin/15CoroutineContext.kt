import kotlin.coroutines.*

/**
 * @author HaiLang
 * @date 2021/11/28 17:15
 */
class CoroutineName(val name: String = "zhangsan") : AbstractCoroutineContextElement(Key) {
    companion object Key : CoroutineContext.Key<CoroutineName>
}

fun main(args: Array<String>) {
    var context: CoroutineContext = EmptyCoroutineContext
    context += CoroutineName("lisi")
    suspend {
        println("In Coroutine [${context[CoroutineName]?.name}]")
        3
    }.startCoroutine(object : Continuation<Int> {
        override val context: CoroutineContext
            get() = context

        override fun resumeWith(result: Result<Int>) {
            println("Coroutine end:$result")
        }
    })

}