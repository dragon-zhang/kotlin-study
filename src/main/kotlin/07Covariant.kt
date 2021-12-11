/**
 * @author HaiLang
 * @date 2021/11/24 21:31
 */
fun <T> copyIn(src: Array<T>, dest: Array<in T>) {
    if (dest.size < src.size) {
        throw IllegalArgumentException()
    }
    src.forEachIndexed { index, _ ->
        dest[index] = src[index]
    }
}

fun main(args: Array<String>) {
    val list = ArrayList<String>();
    list.add("1");
    //String是Any的子类
    val any: List<Any> = list;
    //编译报错，无法添加，只读
    //any.add("2");
    println(any)

    val dest = arrayOfNulls<Number>(3)
    val src = arrayOf(1.0, 2.0, 3.0)
    copyIn(src, dest)
    for (number in dest) {
        print(number.toString() + "\t")
    }
    println()
}