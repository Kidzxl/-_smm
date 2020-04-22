package com.jsu.service;

import com.jsu.bean.Cart;
import com.jsu.bean.MyCart;

import java.util.List;

public interface CartService {

    public List<MyCart> getCartByUid(int uid);
}
