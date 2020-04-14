package com.jsu.service.impl;

import com.jsu.bean.Product;
import com.jsu.dao.ProductDao;
import com.jsu.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private ProductDao productDao;

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
}
