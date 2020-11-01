package com.example.demo.service;

import com.example.demo.dao.entity.UserEntity;

import java.util.List;

public interface UserService {

    /**
     * 查询日志信息
     *
     * @param inputModel
     * @param
     */
    UserEntity login(UserEntity inputModel) throws Exception;


    UserEntity queryByUserId(Integer inputModel) throws Exception;


    List<UserEntity> userList(Integer inputModel) throws Exception;
}
