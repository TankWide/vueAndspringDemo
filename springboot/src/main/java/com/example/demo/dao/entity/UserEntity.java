package com.example.demo.dao.entity;

import lombok.Data;

@Data
public class UserEntity {

    private Integer id;
    private String username;
    private String password;
    private String token;
}
