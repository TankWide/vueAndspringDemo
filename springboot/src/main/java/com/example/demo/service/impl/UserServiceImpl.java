package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.dao.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserEntity login(UserEntity inputModel) throws Exception {
        UserEntity login = userMapper.login(inputModel);
        return login;
    }
}
