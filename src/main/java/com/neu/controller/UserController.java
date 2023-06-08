package com.neu.controller;

import com.neu.beans.HttpResponseEntity;
import com.neu.dao.entity.UserEntity;
import com.neu.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
//@CrossOrigin(origins = "*", allowedHeaders = "Content-Type")//解决跨域问题
public class UserController {
    @Autowired
    private UserService userService;

    //登录验证
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity userLogin(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try{
            List<UserEntity> hasUser = userService.selectUserInfo(userEntity);
            if(CollectionUtils.isEmpty(hasUser)) {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(hasUser.get(0));
                httpResponseEntity.setMessage("用户名或者密码错误");
            }
            else{
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasUser);
                httpResponseEntity.setMessage("登陆成功");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    @RequestMapping(value = "/queryUserList", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryUserList(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try{
            List<UserEntity> hasUser = userService.queryUserList(userEntity);
            if(CollectionUtils.isEmpty(hasUser)) {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(hasUser.get(0));
                httpResponseEntity.setMessage("无用户信息");
            }
            else{
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasUser);
                httpResponseEntity.setMessage("登陆成功");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    //添加用户
    @RequestMapping(value = "/addUserInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity addUserInfo(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try{
            int result = userService.addUserInfo(userEntity);
            if(result != 0) {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("创建成功");
            }
            else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("创建失败");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    //修改用户
    @RequestMapping(value = "/modifyUserInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity modifyUserInfo(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try{
            int result = userService.modifyUserInfo(userEntity);
            if(result != 0) {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("修改成功");
            }
            else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("修改失败");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    //用户删除
    @RequestMapping(value = "/deleteUserinfo", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity deleteUser(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try{
            int result = userService.deleteUserByName(userEntity);
            if(result != 0) {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("删除成功");
            }
            else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除失败");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
}

