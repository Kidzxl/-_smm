package com.jsu.dao;

import com.jsu.bean.Cart;
import com.jsu.bean.MyCart;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CartDao {

    @Select("select p.id,p.name,p.price,p.discounts,p.star,p.description,p.sell,p.inventory,c.num from product p, " +
            "cart c where p.id = c.pid and c.uid = #{0}")
    List<MyCart> queryCartByUid(int uid);

    @Insert("insert into cart(uid,pid,num) values(#{uid},#{pid},#{num})")
    void insertCart(Cart cart);

    @Select("select * from cart where pid=#{0}")
    Cart queryCartByPid(int pid);

    @Update("update cart set num=#{num} where pid=#{pid} and uid=#{uid}")
    void updateCartByPid(Cart cart);
}
