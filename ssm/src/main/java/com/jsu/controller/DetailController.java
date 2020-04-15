package com.jsu.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsu.bean.Cart;
import com.jsu.bean.MsgMap;
import com.jsu.bean.Product;
import com.jsu.service.DetailService;
import com.jsu.util.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
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
        System.out.println("id="+id);
        Product detailProduct =null;
        String key = "product:"+id;
        if(jedis.exists(key)){
            String value = jedis.get(key);
            try {
                 detailProduct = new ObjectMapper().readValue(value,Product.class); // json 转obj
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println(1);

        }else  if(id == null || id<=0 ){
            Map<String,Object> map = new HashMap<>();
            map.put("code",100);
            map.put("data",null);
            map.put("msg","失败");

            System.out.println(22);
            return map;
        }else{
            detailProduct = detailService.getDetail(id);
            try {
                String mapJakcson = new ObjectMapper().writeValueAsString(detailProduct); //obj -> json
                jedis.set("product:"+id,mapJakcson); // product:1  json
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                System.out.println("detail 60");
            }
            System.out.println(3);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("data",detailProduct);
        map.put("msg","成功");
        System.out.println(map);
        return map;
    }

    @ResponseBody
    @RequestMapping("/addCart")
    public Map addCart(Product product,int num,int uid) {
        String key = "user:"+uid+":cart";
        Jedis jedis = JedisUtil.getJedis();

        String flied = null;
        try {
            flied = new ObjectMapper().writeValueAsString(product);
            String value = jedis.hget(key, flied);
            int n;
            if(value==null){
                n = 0;
            }else{
                n = Integer.parseInt(value);
            }
            num += n;
            jedis.hdel(key,flied);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // 写入数据库
        int pid = detailService.getPid(product);
        Cart cart = new Cart();
        cart.setUid(uid);
        cart.setNum(num);
        cart.setPid(pid);
        detailService.insertCart(cart);
        jedis.hincrBy(key,flied,num);
        Map<String, String> m = jedis.hgetAll(key);
        System.out.println("购物车内容"+ m);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("data",m);
        map.put("msg","成功");
        return map;
    }


//    @RequestMapping("/getIndexCart")
//    @ResponseBody
//    public Map getIndexCart(int uid){
//        String key ="user:"+uid+":cart";
//        Jedis jedis  = JedisUtil.getJedis();
//        if(jedis.exists(key)){
//
//        }
//        return null;
//    }

}
