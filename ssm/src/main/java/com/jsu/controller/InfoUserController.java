package com.jsu.controller;

import com.jsu.bean.MsgMap;
import com.jsu.bean.User;
import com.jsu.bean.UserInfo;
import com.jsu.service.UserInfoService;
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
    public UserInfoService userInfoService;


    @ResponseBody
    @RequestMapping("/updateUserInfo")
    public Map updateUserInfo(UserInfo userInfo){
        System.out.println(userInfo);
        HashMap<String, Object> map = new HashMap<>();
        boolean b = userInfoService.updateUserInfo(userInfo);
        if(!b){
            map.put("code",100);
            map.put("data","not data");
            map.put("msg","failure");
        }else{
            map.put("code",200);
            map.put("data","not data");
            map.put("msg","success");
        }
        return map;
    }
}
