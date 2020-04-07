package com.jsu.service;

import com.jsu.bean.Product;

import java.util.List;

public interface IndexService {

    public List<Product> getTopProduct(int cnt);

    public List<Product> getHistoryProduct(String key, int cnt);

}
