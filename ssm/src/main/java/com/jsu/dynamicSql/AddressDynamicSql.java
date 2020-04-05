package com.jsu.dynamicSql;

import com.jsu.bean.Address;
import org.apache.ibatis.jdbc.SQL;

public class AddressDynamicSql {
    public String insertAddressWithDynamic(Address address) {
        return new SQL() {
            {
                INSERT_INTO("address");
                if (address.getName() != null) {
                    VALUES("name", "#{name}");
                }
                if (address.getPostalCode() != null) {
                    VALUES("postalCode", "#{postalCode}");
                }
                if (address.getDetailAddress()!= null) {
                    VALUES("detailAddress", "#{detailAddress}");
                }
                if (address.getUid() != 0) {
                    VALUES("uid", "#{uid}");
                }
                if (address.getAddressSf() != null) {
                    VALUES("addressSf", "#{addressSf}");
                }
                if (address.getAddressCs() != null) {
                    VALUES("addressCs", "#{addressCs}");
                }
                if (address.getAddressQx() != null) {
                    VALUES("addressQx", "#{addressQx}");
                }
                if (address.getChoice() != -1) {
                    VALUES("choice", "#{choice}");
                }
                if (address.getTel() != null) {
                    VALUES("tel", "#{tel}");
                }
            }
        }.toString();
    }

    public String updateAddressWithDynamic(Address address){
        return  new SQL() {
            {
                UPDATE("address");
                if (address.getName() != null) {
                    SET("name=#{name}");
                }
                if (address.getPostalCode() != null) {
                    SET("postalCode=#{postalCode}");
                }
                if (address.getDetailAddress() != null) {
                    SET("detailAddress=#{detailAddress}");
                }
                if (address.getAddressSf() != null) {
                    SET("addressSf=#{addressSf}");
                }
                if (address.getAddressCs() != null) {
                    SET("addressCs=#{addressCs}");
                }
                if (address.getAddressQx() != null) {
                    SET("addressQx=#{addressQx}");
                }
                if (address.getChoice() != -1) {
                    SET("choice=#{choice}");
                }
                if (address.getTel() != null) {
                    SET("tel=#{tel}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }

    public String queryAddressWithDynamic(Address address){
        return new SQL() {
            {
                SELECT("*");
                FROM("address");
                if (address.getName() != null) {
                    WHERE("name=#{name}");
                }
                if (address.getPostalCode() != null) {
                    WHERE("postalCode=#{postalCode}");
                }
                if (address.getDetailAddress() != null) {
                    WHERE("detailAddress=#{detailAddress}");
                }
                if (address.getAddressSf() != null) {
                    WHERE("addressSf=#{addressSf}");
                }
                if (address.getAddressCs() != null) {
                    WHERE("addressCs=#{addressCs}");
                }
                if (address.getAddressQx() != null) {
                    WHERE("addressQx=#{addressQx}");
                }
                if (address.getChoice() != -1) {
                    WHERE("choice=#{choice}");
                }
                if (address.getId() != 0) {
                    WHERE("id=#{id}");
                }
                if (address.getUid() != 0) {
                    WHERE("uid=#{uid}");
                }
                if (address.getTel() != null) {
                    WHERE("tel=#{tel}");
                }
            }

        }.toString();
    }
}
