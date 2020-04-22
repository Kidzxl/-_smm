package com.jsu.service;

import com.jsu.bean.Cart;
import com.jsu.bean.MyCart;
import com.jsu.bean.Product;

import java.util.List;

public interface DetailService {

    Product getDetail(int id);

    void insertCart(Cart cart);

    int getPid(Product product);

    List<MyCart> getCartsByUid(int uid);
}
