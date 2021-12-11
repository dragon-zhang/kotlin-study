/**
 * @author HaiLang
 * @date 2021/11/24 21:31
 */
data class `04DataClass` (
    var name: String = "zhangsan",
    var age: Int = 1
) {
    fun test() {
        println(name)
        println(age)
    }
}

fun main(args: Array<String>) {
    val dataClass = `04DataClass`("zhangsan", 10)
    dataClass.test()
    dataClass.name = "haha"
    println(dataClass.name)
    println(dataClass)
    println(dataClass.hashCode())
    val zhangsan = dataClass.copy("haha", 10)
    println(dataClass === zhangsan)
    println(dataClass == zhangsan)
}