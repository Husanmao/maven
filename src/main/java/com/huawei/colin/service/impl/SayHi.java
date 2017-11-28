package com.huawei.colin.service.impl;

import com.huawei.colin.ITest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: hudongfeng
 * @Description: Hello World Like
 * @Date: 2017/11/28
 */
public class SayHi {

    /**
     * Say Hi
     * @return Return Message
     */
    public String hi() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc.xml");
        final ITest service = (ITest) context.getBean("springservice");
        return service.sayHi();
    }
}
