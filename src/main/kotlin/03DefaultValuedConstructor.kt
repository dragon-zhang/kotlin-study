/**
 * @author HaiLang
 * @date 2021/11/23 20:57
 */
class `03DefaultValuedConstructor`(
    val name: String = "zhangsan",
    private val age: Int = 1,
    var birthYear: Int,
) {
    val sex: String by lazy(LazyThreadSafetyMode.NONE) {
        if (name == "xiaomei") {
            return@lazy "girl"
        }
        return@lazy "boy"
    }

    lateinit var ss: String
    fun initss() {
        ss = "ja"
    }

    constructor(name: String, age: Int = 1) : this(name, age, 2021 - age)

    init {
        println("init1")
    }

    init {
        println("init2")
    }

    fun test() {
        println(name)
        println(age)
        println(sex)
        println(birthYear)
    }
}

fun main(args: Array<String>) {
    val test = `03DefaultValuedConstructor`(name = "xiaomei")
    test.test()
}