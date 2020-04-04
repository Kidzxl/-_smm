package com.jsu.dynamicSql;

import com.jsu.bean.UserInfo;
import org.apache.ibatis.jdbc.SQL;

public class UserInfoDynamicSql {
    public String insertUserInfoWithDynamic(UserInfo userInfo) {
        return new SQL() {
            {
                INSERT_INTO("userinfo");
                if (userInfo.getName() != null) {
                    VALUES("name", "#{name}");
                }
                if (userInfo.getNickname() != null) {
                    VALUES("nickname", "#{nickname}");
                }
                if (userInfo.getSex() != null) {
                    VALUES("sex", "#{sex}");
                }
                if (userInfo.getUid() != 0) {
                    VALUES("uid", "#{uid}");
                }
                if (userInfo.getAddress_sf() != null) {
                    VALUES("address_sf", "#{address_sf}");
                }
                if (userInfo.getAddress_cs() != null) {
                    VALUES("address_cs", "#{address_cs}");
                }
                if (userInfo.getAddress_qx() != null) {
                    VALUES("address_qx", "#{address_qx}");
                }
            }
        }.toString();
    }

    public String updateUserInfoWithDynamic(UserInfo userInfo){
        String sql =  new SQL() {
            {
                UPDATE("userinfo");
                if (userInfo.getName() != null) {
                    SET("name=#{name}");
                }
                if (userInfo.getNickname() != null) {
                    SET("nickname=#{nickname}");
                }
                if (userInfo.getSex() != null) {
                    SET("sex=#{sex}");
                }
                if (userInfo.getAddress_sf() != null) {
                    SET("address_sf=#{address_sf}");
                }
                if (userInfo.getAddress_cs() != null) {
                    SET("address_cs=#{address_cs}");
                }
                if (userInfo.getAddress_qx() != null) {
                    SET("address_qx=#{address_qx}");
                }
                WHERE("uid=#{uid}");
            }
        }.toString();
        System.out.println(sql);
        return sql;
    }
}
