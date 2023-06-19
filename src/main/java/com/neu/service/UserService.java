package com.neu.service;

import com.neu.common.utils.UUIDUtil;
import com.neu.dao.entity.UserEntity;
import com.neu.dao.UserEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserEntityMapper userEntityMapper;

    public List<UserEntity> queryUserList(UserEntity userEntity) {
        List<UserEntity> queryUserList = userEntityMapper.queryUserList(userEntity);
        return queryUserList;
    }


    public int addUserInfo(UserEntity userEntity) {
        userEntity.setId(UUIDUtil.getOneUUID());
        userEntity.setStatus("1");
        int userResult = userEntityMapper.insert(userEntity);
        if (userResult == 0) {
            return 0;//数字0代表用户不存在
        } else {
            return userResult;
        }
    }


    public int modifyUserInfo(UserEntity userEntity) {
        int userResult = userEntityMapper.updateByPrimaryKeySelective(userEntity);
        return userResult;
    }


    public int deleteUserByName(UserEntity userEntity) {
        int userResult = userEntityMapper.deleteUserByName(userEntity);
        return userResult;
    }


    public List<UserEntity> selectUserInfo(UserEntity userEntity) {
        List<UserEntity> userEntityList = userEntityMapper.selectUserInfo(userEntity);
        return userEntityList;
    }


}
