package com.jsu.dao;

import com.jsu.bean.User;
import com.jsu.dynamicSql.UserDynamicSql;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
//    查询所有用户
    @Select("select * from user")
    public List<User> findAll();

//    保存账户信息
    @Insert("insert into user(username,password,email,tel) values(#{username},#{password},#{email},#{tel})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public void insertUser (User user);

    @SelectProvider(type = UserDynamicSql.class , method = "selectUserWithDynamic")
    public User queryUser(User user);
}
