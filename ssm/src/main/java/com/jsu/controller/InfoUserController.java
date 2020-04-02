package com.jsu.controller;

import com.jsu.bean.MsgMap;
import com.jsu.bean.User;
import com.jsu.service.UserService;
import com.jsu.util.CheckAccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用于UserInfo的请求
 */
@RequestMapping("/userInfo")
@Controller
public class InfoUserController {

    @Autowired
    public UserService userService;

    @RequestMapping("/getCode")
    @ResponseBody
    public Map getCode(String email){
        Map<String,Object>  map = new HashMap<>();
        String code = CheckAccountUtil.sendEmail(email);
        if(code==null){
            map.put("code",100);
            map.put("data","not data");
            map.put("msg","failure");
        }else{
            map.put("code",200);
            map.put("data",new MsgMap("code",code));
            map.put("msg","success");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/updateEmail")
    public Map updateEmail(User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            userService.updateUser(user);
            User u = userService.queryUser(user);
            map.put("code", 200);
            map.put("data", new MsgMap("user", u));
            map.put("msg", "success");
        } catch (Exception e) {
            map.put("code", 100);
            map.put("data", "not data");
            map.put("msg", "failure");
        } finally {
            return map;
        }
    }
}
