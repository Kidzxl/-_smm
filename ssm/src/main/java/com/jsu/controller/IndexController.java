package com.jsu.controller;

import com.jsu.bean.Product;
import com.jsu.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexService indexService;
    /**
     * 尝试获取销售最好的产品
     * @return Map 消息集合
     */
    @RequestMapping("/getTop")
    @ResponseBody
    public Map getTop(){
        List<Product> products = indexService.getTopProduct(3);
        Map<String,Object> map = new HashMap<>();
        int code ;
        String msg;
        Object data;
        if(products!=null){
            code = 200;
            data = products;
            msg="成功";
        }else{
            code = 100;
            data  = "not data";
            msg = " 失败";
        }
        map.put("code",code);
        map.put("data",data);
        map.put("msg",msg);
        return map;
    }

    /**
     * 尝试获取历史浏览
     * @return Map 消息集合
     */
    @RequestMapping("/getHistory")
    @ResponseBody
    public Map getHistory(){
        List<Product> products = indexService.getHistoryProduct("zxl",3);
        Map<String,Object> map = new HashMap<>();
        int code ;
        String msg;
        Object data;
        if(products!=null){
            code = 200;
            data = products;
            msg="成功";
        }else{
            code = 100;
            data  = "not data";
            msg = " 失败";
        }
        map.put("code",code);
        map.put("data",data);
        map.put("msg",msg);
        return map;

    }
}
