package com.jsu.dao;

import com.jsu.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
//    查询所有用户
    @Select("select * from user;")
    public List<User> findAll();

//    保存账户信息
    @Insert("insert into user(username,password,age) value(#{username},#{password},#{age})")
    public void saveUser(User user);

}
