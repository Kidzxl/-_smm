package com.jsu.service;

import com.jsu.bean.User;

import java.util.List;

public interface UserService {
    //    查询所有用户
    public List<User> findAll();

    //    保存账户信息
    public void saveUser(User user);
}
