import com.google.gson.Gson

/**
 * @author HaiLang
 * @date 2021/11/23 23:15
 */
inline fun <reified T : Any> Gson.fromJson(json: String): T {
    return fromJson(json, T::class.java)
}

fun main(args: Array<String>) {
    val list = listOf(1, "2", "3")
    val gson = Gson()
    val json: String = gson.toJson(list)
    val fromJson = gson.fromJson<List<Any?>>(json)
    for (data in fromJson) {
        println(data)
    }
}