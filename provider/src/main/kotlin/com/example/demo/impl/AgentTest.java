package com.example.demo.impl;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author HaiLang
 * @date 2022/3/19 14:48
 */
public class AgentTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
        });
        System.out.println(thread);
        // 理论上可以hook掉Thread的start、stop、interrupt、run
        ByteBuddyAgent.install();
        new ByteBuddy().redefine(Thread.class)
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("test"))
                .make()
                .load(Thread.currentThread().getContextClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
        System.out.println(thread);
    }
}
