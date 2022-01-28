package com.example.demo

import com.alibaba.fastjson.JSON
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * @author HaiLang
 * @date 2022/01/28 23:49
 */
@RestController
class TestController {

    @GetMapping("/rust")
    fun rust(@RequestParam(defaultValue = "rust") param: String?): String? {
        try {
            //模拟耗时操作
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        val map = HashMap<String, String?>()
        map["param"] = param
        return JSON.toJSONString(map)
    }
}