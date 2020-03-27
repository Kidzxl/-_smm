package com.jsu.service.impl;

import com.jsu.bean.User;
import com.jsu.dao.UserDao;
import com.jsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        System.out.println("业务层 查询所有信息");
        return userDao.findAll();
    }

    @Override
    public void saveUser(User user) {
        System.out.println("业务层:保存账户");
        User u1 = new User();
        u1.setUsername("aaa");
        u1.setAge(15);
        u1.setPassword("414");
        userDao.saveUser(u1);
        System.out.println(user);
        userDao.saveUser(user);
    }
}
