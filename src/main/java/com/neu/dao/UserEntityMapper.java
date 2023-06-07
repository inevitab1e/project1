package com.neu.dao;

import com.neu.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserEntityMapper {
    /**
     * @descriptions: 查询用户列表
     * @author: FEI BO
     * @date: 2023/6/1 12:29
     * @version: 1.0
     */
    List<UserEntity> queryUserList(UserEntity userEntity);

    /**
     * @descriptions: 创建用户基本信息
     * @author: FEI BO
     * @date: 2023/6/1 12:30
     * @version: 1.0
     */
    int insert(UserEntity userEntity);

    /**
     * @descriptions: 根据id删除用户信息
     * @author: FEI BO
     * @date: 2023/6/1 12:32
     * @version: 1.0
     */
    int deleteUserById(UserEntity userEntity);

    /**
     * @descriptions: 根据主键修改用户信息
     * @author: FEI BO
     * @date: 2023/6/1 12:32
     * @version: 1.0
     */
    int updateByPrimaryKeySelective(UserEntity userEntity);

     /**
      * @descriptions: 查询用户
      * @author: FEI BO
      * @date: 2023/6/1 21:16
      * @version: 1.0
      */
     List<UserEntity> selectUserInfo(UserEntity userEntity);
}
