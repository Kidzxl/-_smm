package com.jsu.controller;

import com.jsu.bean.MsgMap;
import com.jsu.util.CheckAccountUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用于UserInfo的请求
 */
@RequestMapping("/userInfo")
@Controller
public class InfoUserController {

    @RequestMapping("/getCode")
    @ResponseBody
    public Map getCode(String email){
        Map<String,Object>  map = new ConcurrentHashMap<>();
        String code = CheckAccountUtil.sendEmail(email);
        if(code==null){
            map.put("code",100);
            map.put("data","not data");
            map.put("msg","账号或者密码不正确");
        }else{
            map.put("code",200);
            map.put("data",new MsgMap("code",code));
            map.put("msg","success");
        }
        return map;
    }
}
