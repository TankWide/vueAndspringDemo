package com.example.demo.service;

import com.example.demo.dao.entity.UserEntity;

public interface UserService {

    /**
     * 查询日志信息
     *
     * @param inputModel
     * @param
     */
    UserEntity login(UserEntity inputModel) throws Exception;


    UserEntity queryByUserId(Integer inputModel) throws Exception;
}
