package com.jsu.service.impl;

import com.jsu.bean.Address;
import com.jsu.bean.User;
import com.jsu.bean.UserInfo;
import com.jsu.dao.AddressDao;
import com.jsu.dao.UserInfoDao;
import com.jsu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private AddressDao addressDao;

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        try{
            UserInfo u = userInfoDao.queryUserInfoByid(userInfo.getUid());
            if(u == null){
                userInfoDao.insertUserInfo(userInfo);
            }else{
                userInfoDao.updateUserInfo(userInfo);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public int updateAddress(Address addresss) {
        addressDao.updateAddress(addresss);
        return 0;
    }

    @Override
    public int insertAddress(Address address) {
        if(1 == address.getChoice()){// 如果要设置默认的
            Address choiceAddress = addressDao.queryChoiceAddress();
            System.out.println(choiceAddress);
            if(choiceAddress != null){
                choiceAddress.setChoice(0);
                addressDao.updateAddress(choiceAddress);
            }
        }
        addressDao.inserAddress(address);
        return address.getId();
    }

    public Address getDefult(){
        Address address = addressDao.queryChoiceAddress();
        return address;
    }

    @Override
    public List<Address> getAllAddress(int uid) {
        List<Address> addressList = addressDao.queryAllAddress(uid);
        Collections.sort(addressList, new Comparator<Address>() {
            public int compare(Address arg0, Address arg1) {
                int hits0 = arg0.getChoice();
                int hits1 = arg1.getChoice();
                if (hits1 > hits0) {
                    return 1;
                } else if (hits1 == hits0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        System.out.println(addressList);
        return addressList;
    }
}
