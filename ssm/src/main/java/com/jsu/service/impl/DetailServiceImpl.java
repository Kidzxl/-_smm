package com.jsu.service.impl;

import com.jsu.bean.Cart;
import com.jsu.bean.MyCart;
import com.jsu.bean.Product;
import com.jsu.dao.CartDao;
import com.jsu.dao.ProductDao;
import com.jsu.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CartDao cartDao;

    @Override
    public Product getDetail(int id) {
        System.out.println(id);
        Product product = productDao.queryProductById(id);
        System.out.println(product);
        if(product == null)
        {
            System.out.println(""+id+"查询不到");
        }
        return product;
    }

    @Override
    public void insertCart(Cart cart) {
        Cart is = cartDao.queryCartByPid(cart.getPid());
        if(is != null){
            is.setNum(is.getNum()+cart.getNum());
            cartDao.updateCartByPid(is);
        }else{
            cartDao.insertCart(cart);
        }

    }

    @Override
    public int getPid(Product product) {
        return productDao.queryId(product);
    }

    @Override
    public List<MyCart> getCartsByUid(int uid) {

        return cartDao.queryCartByUid(uid);
    }


}
