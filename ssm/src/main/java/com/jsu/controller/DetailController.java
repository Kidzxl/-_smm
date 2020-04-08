package com.jsu.controller;

import com.jsu.bean.Product;
import com.jsu.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class DetailController {
    @Autowired
    private DetailService detailService;

    @ResponseBody
    @RequestMapping("/getDetail")
    public Map getProductDetail(Integer id){
        System.out.println(id);

        if(id == null || id<=0 ){
            Map<String,Object> map = new HashMap<>();
            map.put("code",100);
            map.put("data",null);
            map.put("msg","失败");
            return map;
        }
        Map<String,Object> map = new HashMap<>();
        Product detailProduct = detailService.getDetail(id.intValue());
        map.put("code",200);
        map.put("data",detailProduct);
        map.put("msg","成功");
        return map;
    }
}
