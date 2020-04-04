package com.jsu.service.impl;

import com.jsu.bean.UserInfo;
import com.jsu.dao.UserInfoDao;
import com.jsu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

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
}
