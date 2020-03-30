package com.jsu.test;

import com.jsu.bean.User;
import com.jsu.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testMybatis {

    @Test
    public void run1() throws IOException {
//        加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapContext.xml");
//        创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.findAll();
        list.forEach(i->System.out.println(i));
        sqlSession.close();
        in.close();
    }

    @Test
    public void run2() throws IOException {
//        加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapContext.xml");
//        创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("zcl124j");
        user.setPassword("432");
        user.setEmail("124");
        user.setTel("124");
        System.out.println(user);
         userDao.insertUser(user);
        System.out.println(user.getId());
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
}
