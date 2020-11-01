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
    public CommonReturnType getInfo(@RequestParam String token) throws Exception {
        CommonReturnType result = new CommonReturnType();
//        UserEntity login = userService.login(diaryEntity);
        Map map = new HashMap<>();
        List list = new ArrayList();
        list.add("admin");

        map.put("roles", list);
        map.put("introduction", "I am a super administrator");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name", "Super Admin");
        result.setCode(20000);
        result.setData(map);
        return result;
    }

    @PostMapping(value = "/logout")
    @ResponseBody
    public CommonReturnType logout() throws Exception {
        CommonReturnType result = new CommonReturnType();
        result.setCode(20000);
        result.setData("success");
        return result;
    }
}