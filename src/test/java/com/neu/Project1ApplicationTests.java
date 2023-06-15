package com.neu;

import com.neu.beans.HttpResponseEntity;
import com.neu.controller.ProjectController;
import com.neu.controller.UserController;
import com.neu.dao.entity.UserEntity;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class Project1ApplicationTests {

    @Resource
    private UserController userController;

    @Resource
    private ProjectController projectController;


    Logger log = LogManager.getLogger(Project1ApplicationTests.class);

    @Test
    public void testUserSelect() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("admin");
//        userEntity.setUsername("4444444");
        HttpResponseEntity httpResponseEntity = userController.queryUserList(userEntity);

        log.info("---结果---");
    }

    @Test
    public void testLogin() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("admin");
//        userEntity.setPassword("123");
        userEntity.setPassword("666");
        HttpResponseEntity httpResponseEntity = userController.userLogin(userEntity);
    }

    @Test
    public void testAddUserInfo() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("测试");
        userEntity.setPassword("333");
        HttpResponseEntity httpResponseEntity = userController.addUserInfo(userEntity);
    }

    @Test
    public void testModifyUserInfo(){
        UserEntity userEntity = new UserEntity();
//        userEntity.setId("1");
        userEntity.setId("6");
        HttpResponseEntity httpResponseEntity = userController.modifyUserInfo(userEntity);
    }

    @Test
    public void testDeleteUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId("0");
        HttpResponseEntity httpResponseEntity = userController.deleteUser(userEntity);
    }

//    @Test
//    public void queryUserList() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
//        //调用userMapper的方法
//        UserEntity userEntity = new UserEntity();
//        List<UserEntity> list = userEntityMapper.queryUserList(userEntity);
//        if(CollectionUtils.isEmpty(list)){
//            // 记录error级别的信息
//        }else{
//            System.out.println(list);
//            // 记录info级别的信息
//            log.info(">>queryUserList用户列表查询测试成功");
//        }
//    }
//
//    @Test
//    public void selectUserInfo() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
//        //调用userMapper的方法
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername("admin");
//        userEntity.setPassword("123");
//        List<UserEntity> list = userEntityMapper.selectUserInfo(userEntity);
//        if(CollectionUtils.isEmpty(list)){
//            // 记录error级别的信息
//        }else{
//            System.out.println(list);
//            // 记录info级别的信息
//            log.info(">>qselectUserInfo用户登录测试成功");
//        }
//    }
//
//    //@Test
//    public void insert() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
//        //调用userMapper的方法
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(UUIDUtil.getOneUUID());
//        userEntity.setStatus("1");
//        userEntity.setUsername("LS");
//        userEntity.setPassword("123");
//        int i = userEntityMapper.insert(userEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//            log.info(">>insert用户插入测试成功");
//        }
//    }
//
//    //@Test
//    public void deleteUserByName() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
//        //调用userMapper的方法
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername("aaaaa");
//        int i = userEntityMapper.deleteUserById(userEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//            log.info(">>delete用户删除测试成功");
//        }
//    }

}
