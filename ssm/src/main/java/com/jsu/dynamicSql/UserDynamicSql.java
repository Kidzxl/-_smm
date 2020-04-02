package com.jsu.dynamicSql;

import com.jsu.bean.User;
import org.apache.ibatis.jdbc.SQL;

import java.util.Set;

public class UserDynamicSql {
    public String selectUserWithDynamic(User user) {
        return new SQL() {
            {
                SELECT("*");
                FROM("user");
                if (user.getId() != 0) {
                    WHERE("id=#{id}");
                }
                if(user.getEmail()!=null) {
                    WHERE("email=#{email}");
                }
                if(user.getPassword()!=null) {
                    WHERE("password=#{password}");
                }
                if(user.getUsername()!=null) {
                    WHERE("username=#{username}");
                }
                if(user.getTel()!=null) {
                    WHERE("tel=#{tel}");
                }
            }

        }.toString();
    }
    public String updateUserWithDynamic(User user){
        return new SQL() {
            {
                UPDATE("user");
                if (user.getId() != 0) {
                    SET("id=#{id}");
                }
                if(user.getEmail()!=null) {
                    SET("email=#{email}");
                }
                if(user.getPassword()!=null) {
                    SET("password=#{password}");
                }
                if(user.getUsername()!=null) {
                    SET("username=#{username}");
                }
                if(user.getTel()!=null) {
                    SET("tel=#{tel}");
                }
                WHERE("id=#{id}");
            }

        }.toString();
    }
}
