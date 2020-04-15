package com.jsu.service;

import com.jsu.bean.Cart;
import com.jsu.bean.Product;

public interface DetailService {

    Product getDetail(int id);

    void insertCart(Cart cart);

    int getPid(Product product);
}
