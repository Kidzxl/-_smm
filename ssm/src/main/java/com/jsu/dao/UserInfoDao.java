package com.jsu.dao;

import com.jsu.bean.User;
import com.jsu.bean.UserInfo;
import com.jsu.dynamicSql.UserInfoDynamicSql;
import org.apache.ibatis.annotations.*;

public interface UserInfoDao {

    @Select("select * from userinfo where uid=#{0}")
    UserInfo queryUserInfoByid(int uid);

    @InsertProvider(type = UserInfoDynamicSql.class , method = "insertUserInfoWithDynamic")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void insertUserInfo (UserInfo userInfo);

    @UpdateProvider(type = UserInfoDynamicSql.class,method = "updateUserInfoWithDynamic")
    void updateUserInfo(UserInfo userInfo);
}
