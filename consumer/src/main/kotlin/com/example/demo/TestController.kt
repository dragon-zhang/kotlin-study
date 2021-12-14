package com.example.demo

import kotlinx.coroutines.*
import org.apache.dubbo.config.annotation.Reference
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

/**
 * @author HaiLang
 * @date 2021/12/2 00:01
 */
@RestController
class TestController {

    @Reference(timeout = 9999, check = false)
    private val testService: TestService? = null

    @GetMapping("/hello")
    fun hello(@RequestParam(defaultValue = "param") param: String?): String {
        return testService!!.hello(param!!)
    }

    @GetMapping("/thread")
    fun thread(@RequestParam(defaultValue = "param") param: String?): Long {
        val start = System.currentTimeMillis()
        val threadPool: ThreadPoolExecutor = Executors.newFixedThreadPool(1000) as ThreadPoolExecutor
        threadPool.prestartAllCoreThreads()
        val list = arrayOfNulls<CompletableFuture<Unit?>>(1000)
        for (i in 0..999) {
            val job = CompletableFuture.supplyAsync({
                println("$i " + testService!!.hello(param!!))
            }, threadPool)
            list[i] = job
        }
        CompletableFuture.allOf(*list).join()
        val done = System.currentTimeMillis() - start
        println("thread cost " + done + "ms")
        return done
    }

    @GetMapping("/coroutine")
    suspend fun coroutine(@RequestParam(defaultValue = "param") param: String?): Long {
        //这里可以测试出kotlin JVM的协程是"假协程"
        val start = System.currentTimeMillis()
        val list = LinkedList<Job>()
        val executor = Dispatchers.IO.asExecutor()
        for (i in 0..999) {
            val job = GlobalScope.launch(Dispatchers.IO) {
                println("$i " + testService!!.hello(param!!))
            }
            list.add(job)
        }
        for (job in list) {
            job.join()
        }
        val done = System.currentTimeMillis() - start
        println("coroutine cost " + done + "ms")
        println(executor.javaClass)
        return done
    }
}