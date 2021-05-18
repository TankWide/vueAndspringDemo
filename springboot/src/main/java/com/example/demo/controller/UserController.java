package com.example.demo.controller;

import com.example.demo.dao.entity.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.util.CommonReturnType;
import com.example.demo.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping(value = "/login")
    @ResponseBody
    public CommonReturnType login(@RequestBody UserEntity diaryEntity) throws Exception {
        CommonReturnType result = new CommonReturnType();
        UserEntity login = userService.login(diaryEntity);
        Map map = new HashMap<>();
        map.put("token", JwtUtils.getToken(login));
        result.setCode(20000);
        result.setData(map);
        return result;
    }

    @GetMapping(value = "/info")
    @ResponseBody
    public UserEntity getInfo(@RequestParam String token) throws Exception {
        // 根据token获取userID查询user信息
        CommonReturnType result = new CommonReturnType();
        Integer userId = JwtUtils.getUserId(token);
        UserEntity login = userService.queryByUserId(userId);
        Map map = new HashMap<>();
        List list = new ArrayList();
        list.add("admin");

        login.setRoles(list);
        login.setToken(token);
        result.setCode(20000);
        result.setData(login);
        return login;
    }

    @PostMapping(value = "/logout")
    @ResponseBody
    public CommonReturnType logout() throws Exception {
        CommonReturnType result = new CommonReturnType();
        result.setCode(20000);
        result.setData("success");
        return result;
    }

    @PostMapping(value = "/userList")
    @ResponseBody
    public CommonReturnType userList() throws Exception {
        CommonReturnType result = new CommonReturnType();
        Integer inputModel = 0;
        List<UserEntity> userEntities = userService.userList(inputModel);
        result.setCode(200);
        result.setData(userEntities);
        return result;
    }
}