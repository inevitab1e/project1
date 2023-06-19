package com.neu;

import com.neu.beans.HttpResponseEntity;
import com.neu.common.utils.UUIDUtil;
import com.neu.controller.ProjectController;
import com.neu.controller.UserController;
import com.neu.dao.ProjectEntityMapper;
import com.neu.dao.UserEntityMapper;
import com.neu.dao.entity.ProjectEntity;
import com.neu.dao.entity.UserEntity;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class Project1ApplicationTests {

    @Resource
    private UserController userController;

    @Resource
    private ProjectController projectController;

    Logger log = LogManager.getLogger(Project1ApplicationTests.class);

    //通过username找到user
    @Test
    public void testSelect() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("admin");
        HttpResponseEntity httpResponseEntity = userController.queryUserList(userEntity);

        log.info("---结果---");
//        log.info(httpResponseEntity.getData().toString());
    }

    //加载用户列表
    @Test
    public void queryUserList() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
        //调用userMapper的方法
        UserEntity userEntity = new UserEntity();
        List<UserEntity> list = userEntityMapper.queryUserList(userEntity);
        if (CollectionUtils.isEmpty(list)) {
            // 记录error级别的信息
        } else {
            System.out.println(list);
            // 记录info级别的信息
            log.info(">>queryUserList用户列表查询测试成功");
        }
    }

    //测试登录
    @Test
    public void selectUserInfo() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("admin");
        //登录成功
        userEntity.setPassword("123");
        //登录失败
//        userEntity.setPassword("1234");

        HttpResponseEntity httpResponseEntity = userController.userLogin(userEntity);
    }

    //测试添加用户
    @Test
    public void insertUser() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUIDUtil.getOneUUID());
//        userEntity.setStatus("1");
        userEntity.setUsername("LS");
        userEntity.setPassword("123");
        userController.addUserInfo(userEntity);
    }

    //测试更新用户
    @Test
    public void updateUser() throws Exception {
        UserEntity userEntity = new UserEntity();
        //修改成功
//        userEntity.setId("1");
        //修改失败
        userEntity.setId("6");
        userEntity.setUsername("admin");
        userEntity.setPassword("123");
        userEntity.setLastUpdatedBy("admin");
        userEntity.setStatus("1");
        userEntity.setLastUpdateDate(new Date());
        userController.modifyUserInfo(userEntity);
    }

    //测试删除用户
    @Test
    public void testDeleteUser() throws Exception {
        //调用userMapper的方法
        UserEntity userEntity = new UserEntity();
        //删除失败
//        userEntity.setUsername("ccc");
        //删除成功
        userEntity.setUsername("aaaaa");
        HttpResponseEntity httpResponseEntity = userController.deleteUserInfo(userEntity);

        log.info("---结果---");
//        log.info(httpResponseEntity.getData().toString());
    }

    //---------------------

    @Test
    public void queryProjectList() throws Exception {
        ProjectEntity projectEntity = new ProjectEntity();
        HttpResponseEntity httpResponseEntity = projectController.queryProjectList(projectEntity);
    }

    @Test
    public void selectProjectInfo() throws Exception {
        ProjectEntity projectEntity = new ProjectEntity();
        //查询成功
//        projectEntity.setProjectName("test");
        //查询失败
        projectEntity.setProjectName("666");
        projectController.selectProjectInfo(projectEntity);
    }

    //新建项目
    @Test
    public void insertProject() throws Exception {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(UUIDUtil.getOneUUID());
        projectEntity.setProjectName("1");
        projectEntity.setCreatedBy("LS");
        projectEntity.setProjectContent("123");
        projectController.addProjectInfo(projectEntity);
    }

    //根据主键改项目
    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        ProjectEntity projectEntity = new ProjectEntity();
        //修改成功
//        projectEntity.setId("1");
        //修改失败
        projectEntity.setId("666");
        projectEntity.setProjectName("1");
        projectEntity.setProjectContent("123");
        projectEntity.setLastUpdatedBy("admin");
        projectEntity.setLastUpdateDate(new Date());
        projectController.modifyProjectInfo(projectEntity);
    }

    //通过id删项目
    @Test
    public void deleteProjectById() throws Exception {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId("1");
        projectController.deleteProjectById(projectEntity);
    }

}
