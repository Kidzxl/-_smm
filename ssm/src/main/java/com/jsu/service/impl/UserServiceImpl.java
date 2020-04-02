package com.jsu.service.impl;

import com.jsu.bean.User;
import com.jsu.dao.UserDao;
import com.jsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public int insertUser(User user) {
        try {
             userDao.insertUser(user);
             System.out.println("注册成功:"+user.getId());
             return user.getId();
        }catch (Exception e){
            System.out.println("注册失败");
        }
        return 0;
    }

    @Override
    public User queryUser(User user) {
        return userDao.queryUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
