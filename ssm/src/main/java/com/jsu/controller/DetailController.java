package com.jsu.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsu.bean.Cart;
import com.jsu.bean.MsgMap;
import com.jsu.bean.MyCart;
import com.jsu.bean.Product;
import com.jsu.service.DetailService;
import com.jsu.util.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.*;

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

        // 写入数据库
        int pid = detailService.getPid(product);
        Cart cart = new Cart();
        cart.setUid(uid);
        cart.setNum(num);
        cart.setPid(pid);
        detailService.insertCart(cart);

        HashMap<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("data","ok");
        map.put("msg","成功");
        return map;
    }


    @RequestMapping("/getIndexCart")
    @ResponseBody
    public Map getIndexCart(int uid){
        List<MyCart> carts = detailService.getCartsByUid(uid);
        double sum = 0 ;
        int num = 0;
        for (MyCart cart : carts) {
            sum = sum + cart.getNum() * cart.getDiscounts();
            num += cart.getNum();
        }
        Map<String,Object> map = new HashMap<>();
        Map<Object, Object> data = new HashMap<>();
        data.put("sum",sum);
        data.put("num",num);
        map.put("msg","成功");
        map.put("code",200);
        map.put("data",data);
        return map;
    }

}
