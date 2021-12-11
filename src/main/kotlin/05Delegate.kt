/**
 * @author HaiLang
 * @date 2021/11/23 22:29
 */
interface Flyable {
    fun fly()
}

interface Eatable {
    fun eat()
}

class Flyer : Flyable {
    override fun fly() {
        println("I can fly")
    }
}

class Animal : Eatable {
    override fun eat() {
        println("I can eat")
    }
}

class Bird(flyer: Flyable, animal: Eatable) : Flyable by flyer, Eatable by animal

fun main(args: Array<String>) {
    val bird = Bird(Flyer(), Animal())
    bird.fly()
    bird.eat()
}