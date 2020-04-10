package com.jsu.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsu.bean.Product;
import com.jsu.service.DetailService;
import com.jsu.util.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class DetailController {
    @Autowired
    private DetailService detailService;

    @ResponseBody
    @RequestMapping("/getDetail")
    public Map getProductDetail(Integer id){
        Jedis jedis = JedisUtil.getJedis();
        System.out.println(id);
        Product detailProduct =null;
        String key = "product:"+id;
        if(jedis.exists(key)){
            String value = jedis.get(key);
            try {
                 detailProduct = new ObjectMapper().readValue(value, new TypeReference<Product>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }else  if(id == null || id<=0 ){
            Map<String,Object> map = new HashMap<>();
            map.put("code",100);
            map.put("data",null);
            map.put("msg","失败");
            return map;
        }else{
            detailProduct = detailService.getDetail(id);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("data",detailProduct);
        map.put("msg","成功");
        return map;
    }
}
