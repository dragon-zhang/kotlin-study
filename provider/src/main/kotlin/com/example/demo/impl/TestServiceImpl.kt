package com.example.demo.impl

import com.example.demo.TestService
import org.apache.dubbo.config.annotation.DubboService

/**
 * @author HaiLang
 * @date 2021/12/1 21:09
 */
@DubboService
class TestServiceImpl : TestService {
    override fun Hello(param: String): String {
        try {
            //模拟耗时操作
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return "hello " + param
    }
}
