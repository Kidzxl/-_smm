package com.jsu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsu.bean.MsgMap;
import com.jsu.bean.Product;
import com.jsu.service.CartService;
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
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 购物车页面的获取cart详情
     * @param uid 用户id
     * @return 获取的数据
     * @throws JsonProcessingException
     */
    @RequestMapping("/getCart")
    @ResponseBody
    public Map getCart(int uid) throws JsonProcessingException {
        Map<String,Object> map = new HashMap<>();
        String key ="user:"+uid+":cart";
        Jedis jedis = JedisUtil.getJedis();
        if(jedis.exists(key)){
            Map<String, String> carts = jedis.hgetAll(key);
            List<MsgMap> data = new ArrayList<>();
            for(String k : carts.keySet()){
                Product product = new ObjectMapper().readValue(k,Product.class);
                int num = Integer.parseInt(carts.get(k));
                data.add(new MsgMap(product,num));
            }
            map.put("data",data);
            map.put("code",200);
            map.put("msg","成功");
        }else{
            map.put("data","not data");
            map.put("code",200);
            map.put("msg","成功");
        }
        return map;
    }


}
