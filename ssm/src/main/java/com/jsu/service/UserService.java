package com.jsu.service;

import com.jsu.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    //    查询所有用户
    public List<User> findAll();

    //    保存账户信息
    public int insertUser(User user);

    //查询某个用户
    public User queryUser(User user);
}
