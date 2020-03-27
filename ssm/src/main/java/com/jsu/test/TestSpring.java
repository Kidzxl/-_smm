package com.jsu.test;

import com.jsu.service.UserService;
import com.jsu.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void run1(){
//        加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        获取对象
        UserService userService = ac.getBean("userService", UserServiceImpl.class);
//        调用方法
        userService.findAll();
    }
}
