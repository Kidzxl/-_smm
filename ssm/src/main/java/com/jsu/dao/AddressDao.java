package com.jsu.dao;


import com.jsu.bean.Address;
import com.jsu.dynamicSql.AddressDynamicSql;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

public interface AddressDao {

    @InsertProvider(type = AddressDynamicSql.class,method = "insertAddressWithDynamic")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void inserAddress(Address address);

    @UpdateProvider(type = AddressDynamicSql.class,method = "updateAddressWithDynamic")
    void updateAddress(Address address);

    @Select("select * from address where choice = 1 ")
    Address queryChoiceAddress();

    @Select("select * from address where uid = #{uid}")
    List<Address> queryAllAddress(int uid);
}
