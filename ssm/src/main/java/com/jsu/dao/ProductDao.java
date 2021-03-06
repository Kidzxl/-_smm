package com.jsu.dao;

import com.jsu.bean.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {

    @Select("select * from product ORDER BY sell DESC LIMIT 0,#{0}")

    public List<Product> queryTopProductBySell(int cnt);

    @Select("select * from product")
    public List<Product> queryAllProduct();

    @Select("select * from product limit 0,#{0}")
    public List<Product> queryLimitProduct(int limit);

    @Select("select * from product where id=#{0}")
    public Product queryProductById(int id);

    @Select("select id from product where name=#{name} and price=#{price} and star = #{star}")
    public int queryId(Product product);

}
