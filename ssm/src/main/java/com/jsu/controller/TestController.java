package com.jsu.controller;

import com.jsu.bean.VueTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequestMapping("/test")
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map testGet(VueTest vueTest){
        System.out.println("get.....");
        System.out.println(vueTest);
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("code",200);
        map.put("method","get");
        map.put("data",vueTest);
        return map;
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Map testPost(VueTest vueTest){
        System.out.println("post....");
        System.out.println(vueTest);
        vueTest.setUsername("123");
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("code",200);
        map.put("method","post");
        map.put("data22",vueTest);
        return map;
    }
}
