/**
 * @author HaiLang
 * @date 2021/11/24 21:40
 */
fun <T> copyOut(src: Array<out T>, dest: Array<T>) {
    if (dest.size < src.size) {
        throw IllegalArgumentException()
    }
    src.forEachIndexed { index, _ ->
        dest[index] = src[index]
    }
}

fun main(args: Array<String>) {
    val intComparator = Comparator<Int> { o1: Int?, o2: Int? ->
        return@Comparator when {
            o1 == null && o2 == null -> 0
            o1 == null -> -1
            o2 == null -> 1
            else -> o1.compareTo(o2)
        }
    }
    val numberComparator = Comparator<Number?> { o1: Number?, o2: Number? ->
        return@Comparator when {
            o1 == null && o2 == null -> 0
            o1 == null -> -1
            o2 == null -> 1
            else -> o1.toDouble().compareTo(o2.toDouble())
        }
    }

    val dest = arrayOfNulls<Number>(3)
    val src = arrayOf(1.0, 2.0, 3.0)
    copyOut(src, dest)
    for (number in dest) {
        print(number.toString() + "\t")
    }
    println()
}