package com.welleplus.runmethod;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * springboot启动执行该方法
 * @Order 设置启动顺序
 */
@Component
@Order(value = 1)
public class MyRunMethod implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Spring boot run ...");
    }
}
