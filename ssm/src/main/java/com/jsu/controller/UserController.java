package com.jsu.controller;

import com.jsu.bean.MsgMap;
import com.jsu.bean.User;
import com.jsu.service.UserService;
import org.apache.ibatis.annotations.AutomapConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * web 层
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map loginUser( User user){
        Map<String,Object> map = new ConcurrentHashMap<>();
        List<MsgMap> list = new CopyOnWriteArrayList<>();
        User u = userService.queryUser(user);
        if(u==null){
            map.put("code",100);
            map.put("data","not data");
            map.put("msg","账号或者密码不正确");
        }else{
            map.put("code",200);
            list.add(new MsgMap("user",u));
//            list.add("token")
            map.put("data",list);
            map.put("msg","success");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Map registerUser(User user){

        int id = userService.insertUser(user);
        Map<String,Object> map = new ConcurrentHashMap<>();

        if (id !=0 || (Integer)id ==null){
            map.put("code",200);
            map.put("data",new MsgMap("id",id));
            map.put("msg","success");
        }else{
            map.put("code",100);
            map.put("data","not data");
            map.put("msg","failure");
        }

        System.out.println(id);
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public Map testDemo(User user){
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("code",200);
        map.put("data","not data");
        map.put("msg","success");
        System.out.println("成功");
        return map;
    }

    @ResponseBody
    @RequestMapping("/checkUsername")
    public Map checkUsername(User user){
        Map<String,Object> map = new ConcurrentHashMap<>();
        System.out.println(user);
        User u = userService.queryUser(user);
        map.put("code",200);
        if(u==null){
            map.put("data","not data");
            map.put("msg","failure");
        }else{
            map.put("data",new MsgMap("uid",u.getId()));
            map.put("msg","success");
        }
        return map;
    }

}
