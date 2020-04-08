package com.jsu.service.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsu.bean.Product;
import com.jsu.dao.ProductDao;
import com.jsu.service.IndexService;
import com.jsu.util.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getTopProduct(int cnt) {
        List<Product> products = productDao.queryTopProductByAmmount(cnt);
        if(products.size() <=0){
            return null;
        }
        return products;
    }

    /**
     * 用于获取历史记录
     * @param key 用户id
     * @param cnt 个数
     * @return product List
     */
    public List<Product> getHistoryProduct(String key, int cnt){
        Jedis jedis = JedisUtil.getJedis();
        Boolean is = jedis.exists(key);
        if((key!=null || key.length()!=0) && is){
            List<String> jsonList = jedis.srandmember(key, cnt);
            List<Product> beanList = null;
            try {
                 beanList= new ObjectMapper().readValue((JsonParser) jsonList, new TypeReference<List<Product>>() {});
                System.out.println(beanList);

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("beanList");
            return beanList;
        }else{
            List<Product> products = productDao.queryLimitProduct(3);
            System.out.println(products);
            return products;
        }
    }

}
