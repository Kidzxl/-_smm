package com.jsu.service;

import com.jsu.bean.Address;
import com.jsu.bean.UserInfo;

import java.util.List;

public interface UserInfoService {
    // 更新用户信息
    boolean updateUserInfo(UserInfo userInfo);

    //更新地址
    int updateAddress(Address addresss);

    //插入地址
    int insertAddress(Address address);

    //获取默认的地址
    public Address getDefult();

    //获取所有地址
    public List<Address> getAllAddress(int uid);
}
