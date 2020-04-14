package com.jsu.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class JedisUtil {
    public static JedisPool jp = null;
    public static Jedis jd = null;
    static{
        ResourceBundle resourceBundle = ResourceBundle.getBundle("redis");
        String host = resourceBundle.getString("redis.host");
        int MaxIdle = Integer.parseInt(resourceBundle.getString("redis.MaxIdle"));
        int MaxTotal = Integer.parseInt(resourceBundle.getString("redis.MaxTotal"));
        int port = Integer.parseInt(resourceBundle.getString("redis.port"));
        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxIdle(MaxIdle); //最大活动数
        jpc.setMaxTotal(MaxTotal);//最大连接数
        jp = new JedisPool(jpc,host,port);
        jd = jp.getResource();
    }
    public static Jedis getJedis(){
        return jd;
    }
    public static void main(String[] args){
        Jedis jedis = JedisUtil.getJedis();
    }
}
