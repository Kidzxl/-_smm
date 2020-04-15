package com.jsu.service;

import com.jsu.bean.Cart;

import java.util.List;

public interface CartService {

    public List<Cart> getCartByUid(int uid);
}
