package com.jsu.controller;

import com.jsu.bean.User;
import com.jsu.service.UserService;
import org.apache.ibatis.annotations.AutomapConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * web 层
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(){
        System.out.println("表现层 查询所有用户");
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        return "list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveUser(User user){
        userService.saveUser(user);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/testJson",method = RequestMethod.GET)
    public Map testJson(){
        Map<String,Integer> map = new ConcurrentHashMap<>();
        map.put("code",200);

        return map;
    }
}
