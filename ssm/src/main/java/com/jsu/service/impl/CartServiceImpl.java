package com.jsu.service.impl;

import com.jsu.bean.Cart;
import com.jsu.bean.MyCart;
import com.jsu.dao.CartDao;
import com.jsu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    public List<MyCart> getCartByUid(int uid){
        return cartDao.queryCartByUid(uid);
    }
}
