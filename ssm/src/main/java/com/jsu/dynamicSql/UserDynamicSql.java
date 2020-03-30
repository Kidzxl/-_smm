package com.jsu.dynamicSql;

import com.jsu.bean.User;
import org.apache.ibatis.jdbc.SQL;

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
}
