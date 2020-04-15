package com.jsu.dao;

import com.jsu.bean.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartDao {

    @Select("select * from cart where uid=#{0}")
    List<Cart> queryCartByUid(int uid);

    @Insert("insert into cart(uid,pid,num) values(#{uid},#{pid},#{num})")
    void insertCart(Cart cart);
}
