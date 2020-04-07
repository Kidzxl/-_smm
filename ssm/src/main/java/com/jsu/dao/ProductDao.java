package com.jsu.dao;

import com.jsu.bean.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {

    @Select("select * from product ORDER BY amount DESC LIMIT 0,#{0}")
    public List<Product> queryTopProductByAmmount(int cnt);

    @Select("select * from product")
    public List<Product> queryAllProduct();

    @Select("select * from product limit 0,#{0}")
    public List<Product> queryLimitProduct(int limit);
}
