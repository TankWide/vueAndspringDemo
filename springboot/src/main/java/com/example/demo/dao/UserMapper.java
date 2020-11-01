package com.example.demo.dao;

import com.example.demo.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {


    UserEntity login(UserEntity userEntity);

    UserEntity queryByUserId(Integer userEntity);

    List<UserEntity> userList(Integer userEntity);

}
